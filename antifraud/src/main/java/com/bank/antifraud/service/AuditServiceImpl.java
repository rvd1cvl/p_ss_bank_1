package com.bank.antifraud.service;

import com.bank.antifraud.model.Audit;
import com.bank.antifraud.repository.AuditRepository;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class AuditServiceImpl implements AuditService {

    private final AuditRepository auditRepository;

    public AuditServiceImpl(AuditRepository auditRepository) {
        this.auditRepository = auditRepository;
    }

    @Override
    public List<Audit> getAll() {
        return auditRepository.findAll();
    }

    @Override
    public Audit getById(BigInteger id) {
        return auditRepository.findById(id).get();
    }

    @Override
    public void save(Audit audit) {
        auditRepository.save(audit);
    }

    @Override
    public void update(Audit auditToUpdate, BigInteger oldAuditId) {
        Audit oldAudit = auditRepository.getById(oldAuditId);
        oldAudit.setCreatedAt(auditToUpdate.getCreatedAt());
        oldAudit.setCreatedBy(auditToUpdate.getCreatedBy());
        oldAudit.setEntityType(auditToUpdate.getEntityType());
        oldAudit.setEntityJson(auditToUpdate.getEntityJson());
        oldAudit.setModifiedAt(auditToUpdate.getModifiedAt());
        oldAudit.setModifiedBy(auditToUpdate.getModifiedBy());
        oldAudit.setNewEntityJson(auditToUpdate.getNewEntityJson());
        oldAudit.setOperationType(auditToUpdate.getOperationType());
        auditRepository.save(oldAudit);
    }

    @Override
    public void add(Audit audit) {
        auditRepository.save(audit);
    }

    @Override
    public void deleteById(BigInteger id) {
        auditRepository.deleteById(id);
    }
}
