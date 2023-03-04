package com.bank.antifraud.controller;

import com.bank.antifraud.model.SuspiciousCardTransfer;
import com.bank.antifraud.service.SuspiciousCardTransferService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/suspiciousCard")
@CrossOrigin
public class SuspiciousCardTransferController {

    private final SuspiciousCardTransferService service;

    public SuspiciousCardTransferController(SuspiciousCardTransferService service) {
        this.service = service;
    }

    @GetMapping("/transfers")
    public ResponseEntity<List<SuspiciousCardTransfer>> showAllTransfers() {;
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }
}
