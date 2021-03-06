package com.example.demo.entity;

import java.util.Arrays;

public class CollRecord {
    private int idCollRecord;
    private String disasterID;
    private String location;
    private String disasterDate;
    private String disasterType;
    private String status;
    private String note;
    private byte[] picture;
    private String reportingUnit;

    public CollRecord() {
    }

    public CollRecord(String disasterID) {
        this.disasterID = disasterID;
    }

    public int getIdCollRecord() {
        return idCollRecord;
    }

    public void setIdCollRecord(int idCollRecord) {
        this.idCollRecord = idCollRecord;
    }

    public String getDisasterID() {
        return disasterID;
    }

    public void setDisasterID(String disasterID) {
        this.disasterID = disasterID;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDisasterDate() {
        return disasterDate;
    }

    public void setDisasterDate(String disasterDate) {
        this.disasterDate = disasterDate;
    }

    public String getDisasterType() {
        return disasterType;
    }

    public void setDisasterType(String disasterType) {
        this.disasterType = disasterType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    public String getReportingUnit() {
        return reportingUnit;
    }

    public void setReportingUnit(String reportingUnit) {
        this.reportingUnit = reportingUnit;
    }


    @Override
    public String toString() {
        return "CollRecord{" +
                "idCollRecord=" + idCollRecord +
                ", disasterID='" + disasterID + '\'' +
                ", location='" + location + '\'' +
                ", disasterDate='" + disasterDate + '\'' +
                ", disasterType='" + disasterType + '\'' +
                ", status='" + status + '\'' +
                ", note='" + note + '\'' +
                ", picture=" + Arrays.toString(picture) +
                ", reportingUnit='" + reportingUnit + '\'' +
                '}';
    }
}
