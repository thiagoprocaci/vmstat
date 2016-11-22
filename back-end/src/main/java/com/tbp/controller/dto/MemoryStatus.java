package com.tbp.controller.dto;

import com.tbp.domain.Audit;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;

public class MemoryStatus {

    public static final double CONVERTER = 1e-6;
    public static final String DATE_FORMAT = "dd/MM/yyyy HH:mm:ss";
    private static final String UNIT_MEASUREMENT = "GB";
    public static final int PLACES = 2;

    private Double totalMemory;
    private Double usedMemory;
    private Double activeMemory;
    private Double inactiveMemory;
    private Double freeMemory;
    private Double bufferMemory;
    private String date;

    public MemoryStatus(Audit audit) {
        // convert kb to Gb
        this.totalMemory = round(audit.getTotalMemory() * CONVERTER, PLACES);
        this.usedMemory = round(audit.getUsedMemory() * CONVERTER, PLACES);
        this.activeMemory = round(audit.getActiveMemory() * CONVERTER, PLACES);
        this.inactiveMemory = round(audit.getInactiveMemory() * CONVERTER, PLACES);
        this.freeMemory = round(audit.getFreeMemory() * CONVERTER, PLACES);
        this.bufferMemory = round(audit.getBufferMemory() * CONVERTER, PLACES);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_FORMAT);
        this.date = simpleDateFormat.format(audit.getDate());
    }

    static double round(double value, int places) {
        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    public Double getTotalMemory() {
        return totalMemory;
    }

    public Double getUsedMemory() {
        return usedMemory;
    }

    public Double getActiveMemory() {
        return activeMemory;
    }

    public Double getInactiveMemory() {
        return inactiveMemory;
    }

    public Double getFreeMemory() {
        return freeMemory;
    }

    public Double getBufferMemory() {
        return bufferMemory;
    }

    public String getUnitMeasurement() {
        return UNIT_MEASUREMENT;
    }

    public String getDate() {
        return date;
    }
}
