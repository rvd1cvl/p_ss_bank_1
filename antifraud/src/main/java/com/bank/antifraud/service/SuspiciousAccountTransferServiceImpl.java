package com.bank.antifraud.service;

import com.bank.antifraud.entity.SuspiciousAccountTransfer;
import com.bank.antifraud.repository.SuspiciousAccountTransferRepository;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class SuspiciousAccountTransferServiceImpl implements SuspiciousAccountTransferService {

    private final SuspiciousAccountTransferRepository suspiciousAccountTransferRepository;

    public SuspiciousAccountTransferServiceImpl(SuspiciousAccountTransferRepository suspiciousAccountTransferRepository) {
        this.suspiciousAccountTransferRepository = suspiciousAccountTransferRepository;
    }


    @Override
    public List<SuspiciousAccountTransfer> getAll() {
        return suspiciousAccountTransferRepository.findAll();
    }

    @Override
    public SuspiciousAccountTransfer getById(BigInteger id) {
        return suspiciousAccountTransferRepository.findById(id).get();
    }

    @Override
    public void save(SuspiciousAccountTransfer suspiciousAccountTransfer) {
        suspiciousAccountTransferRepository.save(suspiciousAccountTransfer);

    }

    @Override
    public void update(SuspiciousAccountTransfer transferServiceToUpdate, BigInteger oldTransferId) {
        SuspiciousAccountTransfer oldTransfer = suspiciousAccountTransferRepository.getById(oldTransferId);
        oldTransfer.setAccountTransferId(transferServiceToUpdate.getAccountTransferId());
        oldTransfer.setSuspicious(transferServiceToUpdate.getSuspicious());
        oldTransfer.setBlocked(transferServiceToUpdate.getBlocked());
        oldTransfer.setSuspiciousReason(transferServiceToUpdate.getSuspiciousReason());
        oldTransfer.setBlockedReason(transferServiceToUpdate.getBlockedReason());
        suspiciousAccountTransferRepository.save(oldTransfer);
    }

    @Override
    public void add(SuspiciousAccountTransfer suspiciousAccountTransfer) {
        suspiciousAccountTransferRepository.save(suspiciousAccountTransfer);
    }

    @Override
    public void deleteById(BigInteger id) {
        suspiciousAccountTransferRepository.deleteById(id);
    }
}
