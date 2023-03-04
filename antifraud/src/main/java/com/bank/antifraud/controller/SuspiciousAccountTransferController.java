package com.bank.antifraud.controller;

import com.bank.antifraud.model.SuspiciousAccountTransfer;
import com.bank.antifraud.service.SuspiciousAccountTransferService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/suspiciousAccount")
@CrossOrigin
public class SuspiciousAccountTransferController {

    private final SuspiciousAccountTransferService service;

    public SuspiciousAccountTransferController(SuspiciousAccountTransferService service) {
        this.service = service;
    }

    @GetMapping("/transfers")
    public ResponseEntity<List<SuspiciousAccountTransfer>> showAllTransfers() {;
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }
}
