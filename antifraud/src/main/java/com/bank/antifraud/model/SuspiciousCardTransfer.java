package com.bank.antifraud.model;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Objects;

@Entity
@Table(name = "suspicious_card_transfer")
public class SuspiciousCardTransfer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private BigInteger id;

    @Column(name = "card_transfer_id")
    private BigInteger cardTransferId;

    @Column(name = "is_blocked")
    private Boolean isBlocked;

    @Column(name = "is_suspicious")
    private Boolean isSuspicious;

    @Column(name = "blocked_reason")
    private String blockedReason;

    @Column(name = "suspicious_reason")
    private String suspiciousReason;

    public SuspiciousCardTransfer(BigInteger cardTransferId, Boolean isBlocked,
                                  Boolean isSuspicious, String blockedReason,
                                  String suspiciousReason) {
        this.cardTransferId = cardTransferId;
        this.isBlocked = isBlocked;
        this.isSuspicious = isSuspicious;
        this.blockedReason = blockedReason;
        this.suspiciousReason = suspiciousReason;
    }

    public SuspiciousCardTransfer() {

    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public BigInteger getCardTransferId() {
        return cardTransferId;
    }

    public void setCardTransferId(BigInteger cardTransferId) {
        this.cardTransferId = cardTransferId;
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
        SuspiciousCardTransfer that = (SuspiciousCardTransfer) o;
        return Objects.equals(id, that.id) && Objects.equals(cardTransferId, that.cardTransferId) && Objects.equals(isBlocked, that.isBlocked) && Objects.equals(isSuspicious, that.isSuspicious) && Objects.equals(blockedReason, that.blockedReason) && Objects.equals(suspiciousReason, that.suspiciousReason);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cardTransferId, isBlocked, isSuspicious, blockedReason, suspiciousReason);
    }

    @Override
    public String toString() {
        return "SuspiciousCardTransfer{" +
                "id=" + id +
                ", cardTransferId=" + cardTransferId +
                ", isBlocked=" + isBlocked +
                ", isSuspicious=" + isSuspicious +
                ", blockedReason='" + blockedReason + '\'' +
                ", suspiciousReason='" + suspiciousReason + '\'' +
                '}';
    }
}
