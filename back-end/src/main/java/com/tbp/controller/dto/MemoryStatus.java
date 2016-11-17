package com.tbp.controller.dto;

import com.tbp.domain.Audit;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;


public class MemoryStatus {


    public static final double CONVERSOR = 1e-6;
    private Double totalMemory;
    private Double usedMemory;
    private Double activeMemory;
    private Double inactiveMemory;
    private Double freeMemory;
    private Double bufferMemory;
    private String date;

    public MemoryStatus(Audit audit) {
        // convert kb to Gb
        this.totalMemory = audit.getTotalMemory() * CONVERSOR;
        this.usedMemory = audit.getUsedMemory() * CONVERSOR;
        this.activeMemory = audit.getActiveMemory() * CONVERSOR;
        this.inactiveMemory = audit.getInactiveMemory() * CONVERSOR;
        this.freeMemory = audit.getFreeMemory() * CONVERSOR;
        this.bufferMemory = audit.getBufferMemory() * CONVERSOR;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        this.date = simpleDateFormat.format(audit.getDate());

        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        this.usedMemory = audit.getUsedMemory() * CONVERSOR;
        this.activeMemory = audit.getActiveMemory() * CONVERSOR;
        this.inactiveMemory = audit.getInactiveMemory() * CONVERSOR;
        this.freeMemory = audit.getFreeMemory() * CONVERSOR;
        this.bufferMemory = audit.getBufferMemory() * CONVERSOR;
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

    public String getDate() {
        return date;
    }
}
