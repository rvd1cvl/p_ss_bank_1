package com.bank.antifraud.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.math.BigInteger;
import java.util.Date;
import java.util.Objects;

@Data
@AllArgsConstructor
@Builder
@Entity
@Table(name = "audit", schema = "anti_fraud")
public class Audit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private BigInteger id;

    @Max(value = 40)
    @Column(name = "entity_type")
    private String entityType;

    @Column(name = "operation_type")
    private String operationType;

    @Column(name = "created_by")
    private String createdBy;
    @NotNull
    @Column(name = "modified_by")
    private String modifiedBy;

    @Column(name = "created_at")
    private Date createdAt;

    @NotNull
    @Column(name = "modified_at")
    private Date modifiedAt;

    @NotNull
    @Column(name = "new_entity_json")
    private String newEntityJson;

    @Column(name = "entity_json")
    private String entityJson;

    public Audit(String entityType, String operationType, String createdBy,
                 String modifiedBy, Date createdAt, Date modifiedAt,
                 String newEntityJson, String entityJson) {
        this.entityType = entityType;
        this.operationType = operationType;
        this.createdBy = createdBy;
        this.modifiedBy = modifiedBy;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.newEntityJson = newEntityJson;
        this.entityJson = entityJson;
    }

    public Audit() {

    }
    public Audit(BigInteger id) {
        this.id = id;

    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getEntityType() {
        return entityType;
    }

    public void setEntityType(String entityType) {
        this.entityType = entityType;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(Date modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public String getNewEntityJson() {
        return newEntityJson;
    }

    public void setNewEntityJson(String newEntityJson) {
        this.newEntityJson = newEntityJson;
    }

    public String getEntityJson() {
        return entityJson;
    }

    public void setEntityJson(String entityJson) {
        this.entityJson = entityJson;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Audit audit = (Audit) o;
        return Objects.equals(id, audit.id) && Objects.equals(entityType, audit.entityType) && Objects.equals(operationType, audit.operationType) && Objects.equals(createdBy, audit.createdBy) && Objects.equals(modifiedBy, audit.modifiedBy) && Objects.equals(createdAt, audit.createdAt) && Objects.equals(modifiedAt, audit.modifiedAt) && Objects.equals(newEntityJson, audit.newEntityJson) && Objects.equals(entityJson, audit.entityJson);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, entityType, operationType, createdBy, modifiedBy, createdAt, modifiedAt, newEntityJson, entityJson);
    }

    @Override
    public String toString() {
        return "audit{" +
                "id=" + id +
                ", entityType='" + entityType + '\'' +
                ", operationType='" + operationType + '\'' +
                ", createdBy='" + createdBy + '\'' +
                ", modifiedBy='" + modifiedBy + '\'' +
                ", createdAt=" + createdAt +
                ", modifiedAt=" + modifiedAt +
                ", newEntityJson='" + newEntityJson + '\'' +
                ", entityJson='" + entityJson + '\'' +
                '}';
    }
}
