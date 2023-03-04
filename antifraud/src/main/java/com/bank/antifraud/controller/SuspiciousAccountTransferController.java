package com.bank.antifraud.controller;

import com.bank.antifraud.dto.SuspiciousAccountTransferDto;
import com.bank.antifraud.model.SuspiciousAccountTransfer;
import com.bank.antifraud.model.SuspiciousCardTransfer;
import com.bank.antifraud.service.SuspiciousAccountTransferService;
import liquibase.pro.packaged.M;
import org.modelmapper.ModelMapper;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/suspiciousAccount")
public class SuspiciousAccountTransferController {

    private final SuspiciousAccountTransferService service;

    public SuspiciousAccountTransferController(SuspiciousAccountTransferService service) {
        this.service = service;
    }

    @GetMapping("/transfers")
    public ResponseEntity<List<SuspiciousAccountTransfer>> showAllTransfers() {;
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @GetMapping("/transfers/{id}")
    public ResponseEntity<SuspiciousAccountTransfer> getOneTransfer(@PathVariable(name = "id") BigInteger id) {
        return new ResponseEntity<>(service.getById(id), HttpStatus.OK);
    }

    @PostMapping("/transfers")
    public ResponseEntity<HttpStatus> addTransfer(@RequestBody SuspiciousAccountTransferDto dto,
                                                                 BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        try {
            service.save(convertToTransfer(dto));
        } catch (DataIntegrityViolationException e) {
            System.out.println("Transfer with this data already exists");
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/transfers/{id}")
    public ResponseEntity<HttpStatus> deleteTransfer(@PathVariable("id") BigInteger id) {
        service.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/transfers/{oldTransferId}")
    public ResponseEntity<HttpStatus> updateTransfer(@RequestBody SuspiciousAccountTransferDto dto,
                                                     @PathVariable("oldTransferId") BigInteger oldTransferId,
                                                     BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        try {
            service.update(convertToTransfer(dto), oldTransferId);
            return ResponseEntity.ok(HttpStatus.OK);
        } catch (DataIntegrityViolationException e) {
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public SuspiciousAccountTransfer convertToTransfer(SuspiciousAccountTransferDto dto) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(dto, SuspiciousAccountTransfer.class);
    }
}