package com.bank.antifraud.repository;

import com.bank.antifraud.model.Audit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface AuditRepository extends JpaRepository<Audit, BigInteger> {
}
