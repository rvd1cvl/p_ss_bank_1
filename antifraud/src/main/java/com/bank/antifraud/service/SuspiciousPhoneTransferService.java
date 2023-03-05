package com.bank.antifraud.service;

import com.bank.antifraud.entity.SuspiciousPhoneTransfer;

import java.math.BigInteger;
import java.util.List;

public interface SuspiciousPhoneTransferService {
    List<SuspiciousPhoneTransfer> getAll();
    SuspiciousPhoneTransfer getById(BigInteger id);
    void save(SuspiciousPhoneTransfer suspiciousPhoneTransfer);
    void update(SuspiciousPhoneTransfer transferToUpdate, BigInteger oldTransferId);
    void add(SuspiciousPhoneTransfer suspiciousPhoneTransfer);
    void deleteById(BigInteger id);
}
