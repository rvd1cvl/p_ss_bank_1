package com.bank.antifraud.service;

import com.bank.antifraud.entity.SuspiciousPhoneTransfer;
import com.bank.antifraud.repository.SuspiciousPhoneTransferRepository;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class SuspiciousPhoneTransferServiceImpl implements SuspiciousPhoneTransferService{

    private final SuspiciousPhoneTransferRepository suspiciousPhoneTransferRepository;

    public SuspiciousPhoneTransferServiceImpl(SuspiciousPhoneTransferRepository suspiciousPhoneTransferRepository) {
        this.suspiciousPhoneTransferRepository = suspiciousPhoneTransferRepository;
    }

    @Override
    public List<SuspiciousPhoneTransfer> getAll() {
        return suspiciousPhoneTransferRepository.findAll();
    }

    @Override
    public SuspiciousPhoneTransfer getById(BigInteger id) {
        return suspiciousPhoneTransferRepository.findById(id).get();
    }

    @Override
    public void save(SuspiciousPhoneTransfer suspiciousPhoneTransfer) {
        suspiciousPhoneTransferRepository.save(suspiciousPhoneTransfer);
    }

    @Override
    public void update(SuspiciousPhoneTransfer transferToUpdate, BigInteger oldTransferId) {
        SuspiciousPhoneTransfer oldTransfer = suspiciousPhoneTransferRepository.getById(oldTransferId);
        oldTransfer.setPhoneTransferId(transferToUpdate.getPhoneTransferId());
        oldTransfer.setSuspicious(transferToUpdate.getSuspicious());
        oldTransfer.setSuspiciousReason(transferToUpdate.getSuspiciousReason());
        oldTransfer.setBlocked(transferToUpdate.getBlocked());
        oldTransfer.setBlockedReason(transferToUpdate.getBlockedReason());
        suspiciousPhoneTransferRepository.save(oldTransfer);
    }

    @Override
    public void add(SuspiciousPhoneTransfer suspiciousPhoneTransfer) {
        suspiciousPhoneTransferRepository.save(suspiciousPhoneTransfer);
    }

    @Override
    public void deleteById(BigInteger id) {
        suspiciousPhoneTransferRepository.deleteById(id);
    }
}
