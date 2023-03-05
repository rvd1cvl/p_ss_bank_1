package com.bank.antifraud.service;

import com.bank.antifraud.entity.SuspiciousCardTransfer;

import java.math.BigInteger;
import java.util.List;

public interface SuspiciousCardTransferService {
    List<SuspiciousCardTransfer> getAll();
    SuspiciousCardTransfer getById(BigInteger id);
    void save(SuspiciousCardTransfer suspiciousCardTransfer);
    void update(SuspiciousCardTransfer transferToUpdate, BigInteger oldTransferId);
    void add(SuspiciousCardTransfer suspiciousCardTransfer);
    void deleteById(BigInteger id);
}
