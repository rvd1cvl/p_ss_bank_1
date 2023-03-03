package com.bank.antifraud.service;

import com.bank.antifraud.model.SuspiciousAccountTransfer;

import java.math.BigInteger;
import java.util.List;

public interface SuspiciousAccountTransferService {
    List<SuspiciousAccountTransfer> getAll();
    SuspiciousAccountTransfer getById(BigInteger id);
    void save(SuspiciousAccountTransfer suspiciousAccountTransfer);
    void update(SuspiciousAccountTransfer transferToUpdate, BigInteger oldTransferId);
    void add(SuspiciousAccountTransfer suspiciousAccountTransfer);
    void deleteById(BigInteger id);
}
