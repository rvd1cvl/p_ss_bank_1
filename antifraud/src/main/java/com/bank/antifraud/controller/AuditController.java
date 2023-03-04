package com.bank.antifraud.controller;

import com.bank.antifraud.dto.AuditDto;
import com.bank.antifraud.dto.SuspiciousAccountTransferDto;
import com.bank.antifraud.model.Audit;
import com.bank.antifraud.model.SuspiciousAccountTransfer;
import com.bank.antifraud.service.AuditService;
import org.modelmapper.ModelMapper;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping()
@CrossOrigin
public class AuditController {

    private final AuditService service;

    public AuditController(AuditService service) {
        this.service = service;
    }

    @GetMapping("/audit")
    public ResponseEntity<List<Audit>> showAllTransfers() {;
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @GetMapping("/audit/{id}")
    public ResponseEntity<Audit> getOneTransfer(@PathVariable(name = "id") BigInteger id) {
        return new ResponseEntity<>(service.getById(id), HttpStatus.OK);
    }

    @PostMapping("/audit")
    public ResponseEntity<HttpStatus> addTransfer(@RequestBody AuditDto dto,
                                                  BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        try {
            service.save(convertToAudit(dto));
        } catch (DataIntegrityViolationException e) {
            System.out.println("Audit with this data already exists");
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/audit/{id}")
    public ResponseEntity<HttpStatus> deleteTransfer(@PathVariable("id") BigInteger id) {
        service.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/audit/{id}")
    public ResponseEntity<HttpStatus> updateTransfer(@RequestBody AuditDto dto,
                                                     @PathVariable("id") BigInteger oldTransferId,
                                                     BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        try {
            service.update(convertToAudit(dto), oldTransferId);
            return ResponseEntity.ok(HttpStatus.OK);
        } catch (DataIntegrityViolationException e) {
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    private Audit convertToAudit(AuditDto dto) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(dto, Audit.class);
    }
}
