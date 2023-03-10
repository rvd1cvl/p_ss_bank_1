package com.bank.antifraud.service;

import com.bank.antifraud.entity.Audit;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.List;

@Component
public interface AuditService {
    List<Audit> getAll();
    Audit getById(BigInteger id);
    void save(Audit audit);
    void update(Audit auditToUpdate, BigInteger oldAuditId);
    void add(Audit audit);
    void deleteById(BigInteger id);
}
