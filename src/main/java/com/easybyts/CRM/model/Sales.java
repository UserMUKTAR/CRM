package com.easybyts.CRM.model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "sales")
public class Sales{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String leadName;
    private String dealAmount;
    private String stage;
    private String assignedTo;
    private String company;

    @Temporal(TemporalType.DATE)
    private Date closeDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = new Date();
    }
    @PreUpdate
    protected  void onUpdate() {
        this.updatedAt = new Date();
    }

}
