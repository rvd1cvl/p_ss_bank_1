package com.bank.antifraud.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigInteger;
import java.util.Objects;

@Entity
@Table(name = "suspicious_account_transfers", schema = "anti_fraud")
public class SuspiciousAccountTransfer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private BigInteger id;

    @Column(name = "account_transfer_id")
    private BigInteger accountTransferId;

    @Column(name = "is_blocked")
    private Boolean isBlocked;

    @Column(name = "is_suspicious")
    private Boolean isSuspicious;

    @NotNull
    @Column(name = "blocked_reason")
    private String blockedReason;

    @Column(name = "suspicious_reason")
    private String suspiciousReason;

    public SuspiciousAccountTransfer(BigInteger accountTransferId, Boolean isBlocked,
                                     Boolean isSuspicious, String blockedReason,
                                     String suspiciousReason) {
        this.accountTransferId = accountTransferId;
        this.isBlocked = isBlocked;
        this.isSuspicious = isSuspicious;
        this.blockedReason = blockedReason;
        this.suspiciousReason = suspiciousReason;
    }

    public SuspiciousAccountTransfer() {

    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public BigInteger getAccountTransferId() {
        return accountTransferId;
    }

    public void setAccountTransferId(BigInteger accountTransferId) {
        this.accountTransferId = accountTransferId;
    }

    public Boolean getBlocked() {
        return isBlocked;
    }

    public void setBlocked(Boolean blocked) {
        isBlocked = blocked;
    }

    public Boolean getSuspicious() {
        return isSuspicious;
    }

    public void setSuspicious(Boolean suspicious) {
        isSuspicious = suspicious;
    }

    public String getBlockedReason() {
        return blockedReason;
    }

    public void setBlockedReason(String blockedReason) {
        this.blockedReason = blockedReason;
    }

    public String getSuspiciousReason() {
        return suspiciousReason;
    }

    public void setSuspiciousReason(String suspiciousReason) {
        this.suspiciousReason = suspiciousReason;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SuspiciousAccountTransfer that = (SuspiciousAccountTransfer) o;
        return Objects.equals(id, that.id) && Objects.equals(accountTransferId, that.accountTransferId) && Objects.equals(isBlocked, that.isBlocked) && Objects.equals(isSuspicious, that.isSuspicious) && Objects.equals(blockedReason, that.blockedReason) && Objects.equals(suspiciousReason, that.suspiciousReason);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, accountTransferId, isBlocked, isSuspicious, blockedReason, suspiciousReason);
    }

    @Override
    public String toString() {
        return "SuspiciousAccountTransfer{" +
                "id=" + id +
                ", accountTransferId=" + accountTransferId +
                ", isBlocked=" + isBlocked +
                ", isSuspicious=" + isSuspicious +
                ", blockedReason='" + blockedReason + '\'' +
                ", suspiciousReason='" + suspiciousReason + '\'' +
                '}';
    }
}
