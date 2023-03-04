package com.bank.antifraud.model;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Objects;

@Entity
@Table(name = "suspicious_phone_transfers", schema = "anti_fraud")
public class SuspiciousPhoneTransfer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private BigInteger id;

    @Column(name = "phone_transfer_id")
    private BigInteger phoneTransferId;

    @Column(name = "is_blocked")
    private Boolean isBlocked;

    @Column(name = "is_suspicious")
    private Boolean isSuspicious;

    @Column(name = "blocked_reason")
    private String blockedReason;

    @Column(name = "suspicious_reason")
    private String suspiciousReason;

    public SuspiciousPhoneTransfer(BigInteger phoneTransferId, Boolean isBlocked,
                                   Boolean isSuspicious, String blockedReason,
                                   String suspiciousReason) {
        this.phoneTransferId = phoneTransferId;
        this.isBlocked = isBlocked;
        this.isSuspicious = isSuspicious;
        this.blockedReason = blockedReason;
        this.suspiciousReason = suspiciousReason;
    }

    public SuspiciousPhoneTransfer() {

    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public BigInteger getPhoneTransferId() {
        return phoneTransferId;
    }

    public void setPhoneTransferId(BigInteger phoneTransferId) {
        this.phoneTransferId = phoneTransferId;
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
        SuspiciousPhoneTransfer that = (SuspiciousPhoneTransfer) o;
        return Objects.equals(id, that.id) && Objects.equals(phoneTransferId, that.phoneTransferId) && Objects.equals(isBlocked, that.isBlocked) && Objects.equals(isSuspicious, that.isSuspicious) && Objects.equals(blockedReason, that.blockedReason) && Objects.equals(suspiciousReason, that.suspiciousReason);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, phoneTransferId, isBlocked, isSuspicious, blockedReason, suspiciousReason);
    }

    @Override
    public String toString() {
        return "SuspiciousPhoneTransfer{" +
                "id=" + id +
                ", phoneTransferId=" + phoneTransferId +
                ", isBlocked=" + isBlocked +
                ", isSuspicious=" + isSuspicious +
                ", blockedReason='" + blockedReason + '\'' +
                ", suspiciousReason='" + suspiciousReason + '\'' +
                '}';
    }
}
