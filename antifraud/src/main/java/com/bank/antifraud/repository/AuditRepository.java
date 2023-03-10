package com.bank.antifraud.repository;

import com.bank.antifraud.entity.Audit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface AuditRepository extends JpaRepository<Audit, BigInteger> {
}
