package com.tbp.controller.dto;

import com.tbp.domain.Audit;

public class CpuStatus extends Status {

    private Long nonNiceUserCpuTicks;
    private Long niceUserCpuTicks;
    private Long systemCpuTicks;
    private Long idleCpuTicks;
    private Long ioWaitCpuTicks;
    private Long irqCpuTicks;
    private Long softirqCpuTicks;
    private Long stolenCpuTicks;


    public CpuStatus(Audit audit) {
        super(audit);
        nonNiceUserCpuTicks = audit.getNonNiceUserCpuTicks();
        niceUserCpuTicks = audit.getNiceUserCpuTicks();
        systemCpuTicks = audit.getSystemCpuTicks();
        idleCpuTicks = audit.getIdleCpuTicks();
        ioWaitCpuTicks = audit.getIoWaitCpuTicks();
        irqCpuTicks = audit.getIrqCpuTicks();
        softirqCpuTicks = audit.getSoftirqCpuTicks();
        stolenCpuTicks = audit.getStolenCpuTicks();
    }

    public Long getNonNiceUserCpuTicks() {
        return nonNiceUserCpuTicks;
    }

    public Long getNiceUserCpuTicks() {
        return niceUserCpuTicks;
    }

    public Long getSystemCpuTicks() {
        return systemCpuTicks;
    }

    public Long getIdleCpuTicks() {
        return idleCpuTicks;
    }

    public Long getIoWaitCpuTicks() {
        return ioWaitCpuTicks;
    }

    public Long getIrqCpuTicks() {
        return irqCpuTicks;
    }

    public Long getSoftirqCpuTicks() {
        return softirqCpuTicks;
    }

    public Long getStolenCpuTicks() {
        return stolenCpuTicks;
    }

}
