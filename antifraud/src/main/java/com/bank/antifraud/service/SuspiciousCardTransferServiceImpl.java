package com.bank.antifraud.service;

import com.bank.antifraud.model.SuspiciousCardTransfer;
import com.bank.antifraud.repository.SuspiciousCardTransferRepository;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class SuspiciousCardTransferServiceImpl implements SuspiciousCardTransferService{

    private final SuspiciousCardTransferRepository suspiciousCardTransferRepository;

    public SuspiciousCardTransferServiceImpl(SuspiciousCardTransferRepository suspiciousCardTransferRepository) {
        this.suspiciousCardTransferRepository = suspiciousCardTransferRepository;
    }


    @Override
    public List<SuspiciousCardTransfer> getAll() {
        return suspiciousCardTransferRepository.findAll();
    }

    @Override
    public SuspiciousCardTransfer getById(BigInteger id) {
        return suspiciousCardTransferRepository.getById(id.intValue());
    }

    @Override
    public void save(SuspiciousCardTransfer suspiciousCardTransfer) {
        suspiciousCardTransferRepository.save(suspiciousCardTransfer);
    }

    @Override
    public void update(SuspiciousCardTransfer transferToUpdate, BigInteger oldTransferId) {
        SuspiciousCardTransfer oldTransfer = suspiciousCardTransferRepository.getById(oldTransferId.intValue());
        oldTransfer.setCardTransferId(transferToUpdate.getCardTransferId());
        oldTransfer.setSuspicious(transferToUpdate.getSuspicious());
        oldTransfer.setBlocked(transferToUpdate.getBlocked());
        oldTransfer.setSuspiciousReason(transferToUpdate.getSuspiciousReason());
        oldTransfer.setBlockedReason(transferToUpdate.getBlockedReason());
        suspiciousCardTransferRepository.save(oldTransfer);

    }

    @Override
    public void add(SuspiciousCardTransfer suspiciousCardTransfer) {
        suspiciousCardTransferRepository.save(suspiciousCardTransfer);
    }

    @Override
    public void deleteById(BigInteger id) {
        suspiciousCardTransferRepository.deleteById(id.intValue());
    }
}
