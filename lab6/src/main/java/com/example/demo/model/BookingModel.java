package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "booking")
public class BookingModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "patientname")
    private String patientName;

    @Column(name = "drname")
    private String drName;

    @Column(name = "date")
    private String apdate;

    @Column(name = "status")
    private String status;

    public BookingModel() {
    }

    public BookingModel(Long id, String patientName, String drName, String apdate, String status) {
        this.id = id;
        this.patientName = patientName;
        this.drName = drName;
        this.apdate = apdate;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getDrName() {
        return drName;
    }

    public void setDrName(String drName) {
        this.drName = drName;
    }

    public String getApdate() {
        return apdate;
    }

    public void setApdate(String apdate) {
        this.apdate = apdate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}