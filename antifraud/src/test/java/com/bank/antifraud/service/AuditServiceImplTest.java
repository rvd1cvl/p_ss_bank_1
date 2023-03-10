package com.bank.antifraud.service;

import com.bank.antifraud.entity.Audit;
import com.bank.antifraud.repository.AuditRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigInteger;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration
public class AuditServiceImplTest {
    @Autowired
    private AuditRepository auditService;

    @Test
    public void saveAudit() {
        Audit audit = Audit.builder()
                .createdAt(new Date())
                .createdBy("aboba1")
                .modifiedAt(new Date())
                .modifiedBy("aboba2")
                .entityJson("aboba3")
                .entityType("aboba4")
                .operationType("aboba5")
                .newEntityJson("aboba6")
                .build();

        auditService.save(audit);
        Assertions.assertThat(audit.getId()).isGreaterThan(BigInteger.ZERO);
    }

    @Test
    public void getAuditTest() {
        Audit audit = auditService.getById(BigInteger.valueOf(1));

        Assertions.assertThat(audit.getId()).isEqualTo(BigInteger.ONE);

    }
}

