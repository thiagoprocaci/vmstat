package com.tbp.controller.dto;


import com.tbp.domain.Audit;

import java.text.SimpleDateFormat;

public class Status {
    static final String DATE_FORMAT = "dd/MM/yyyy HH:mm:ss";
    private String date;
    private String ipRunnerMachine;

    public Status(Audit audit) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_FORMAT);
        this.date = simpleDateFormat.format(audit.getDate());
        this.ipRunnerMachine = audit.getIpRunnerMachine();
    }

    public String getDate() {
        return date;
    }

    public String getIpRunnerMachine() {
        return ipRunnerMachine;
    }
}
