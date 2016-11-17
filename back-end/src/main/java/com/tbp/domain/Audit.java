package com.tbp.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Audit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String ipRunnerMachine;
    @Column(nullable = false)
    private Long totalMemory;
    @Column(nullable = false)
    private Long usedMemory;
    @Column(nullable = false)
    private Long activeMemory;
    @Column(nullable = false)
    private Long inactiveMemory;
    @Column(nullable = false)
    private Long freeMemory;
    @Column(nullable = false)
    private Long bufferMemory;
    @Column(nullable = false)
    private Long swapCache;
    @Column(nullable = false)
    private Long totalSwap;
    @Column(nullable = false)
    private Long usedSwap;
    @Column(nullable = false)
    private Long freeSwap;
    @Column(nullable = false)
    private Long nonNiceUserCpuTicks;
    @Column(nullable = false)
    private Long niceUserCpuTicks;
    @Column(nullable = false)
    private Long systemCpuTicks;
    @Column(nullable = false)
    private Long idleCpuTicks;
    @Column(nullable = false)
    private Long ioWaitCpuTicks;
    @Column(nullable = false)
    private Long irqCpuTicks;
    @Column(nullable = false)
    private Long softirqCpuTicks;
    @Column(nullable = false)
    private Long stolenCpuTicks;
    @Column(nullable = false)
    private Long pagesPagedIn;
    @Column(nullable = false)
    private Long pagesPagedOut;
    @Column(nullable = false)
    private Long pagesSwappedIn;
    @Column(nullable = false)
    private Long pagesSwappedOut;
    @Column(nullable = false)
    private Long interrupts;
    @Column(nullable = false)
    private Long cpuContextSwitches;
    @Column(nullable = false)
    private Long bootTime;
    @Column(nullable = false)
    private Long forks;
    @Column(nullable = false)
    private Date date;

    public Audit() {

    }

    public Audit(String ipRunnerMachine, Long totalMemory, Long usedMemory, Long activeMemory, Long inactiveMemory, Long freeMemory, Long bufferMemory, Long swapCache, Long totalSwap, Long usedSwap, Long freeSwap, Long nonNiceUserCpuTicks, Long niceUserCpuTicks, Long systemCpuTicks, Long idleCpuTicks, Long ioWaitCpuTicks, Long irqCpuTicks, Long softirqCpuTicks, Long stolenCpuTicks, Long pagesPagedIn, Long pagesPagedOut, Long pagesSwappedIn, Long pagesSwappedOut, Long interrupts, Long cpuContextSwitches, Long bootTime, Long forks) {
        this.ipRunnerMachine = ipRunnerMachine;
        this.totalMemory = totalMemory;
        this.usedMemory = usedMemory;
        this.activeMemory = activeMemory;
        this.inactiveMemory = inactiveMemory;
        this.freeMemory = freeMemory;
        this.bufferMemory = bufferMemory;
        this.swapCache = swapCache;
        this.totalSwap = totalSwap;
        this.usedSwap = usedSwap;
        this.freeSwap = freeSwap;
        this.nonNiceUserCpuTicks = nonNiceUserCpuTicks;
        this.niceUserCpuTicks = niceUserCpuTicks;
        this.systemCpuTicks = systemCpuTicks;
        this.idleCpuTicks = idleCpuTicks;
        this.ioWaitCpuTicks = ioWaitCpuTicks;
        this.irqCpuTicks = irqCpuTicks;
        this.softirqCpuTicks = softirqCpuTicks;
        this.stolenCpuTicks = stolenCpuTicks;
        this.pagesPagedIn = pagesPagedIn;
        this.pagesPagedOut = pagesPagedOut;
        this.pagesSwappedIn = pagesSwappedIn;
        this.pagesSwappedOut = pagesSwappedOut;
        this.interrupts = interrupts;
        this.cpuContextSwitches = cpuContextSwitches;
        this.bootTime = bootTime;
        this.forks = forks;
        this.date = new Date();
    }

    public Long getId() {
        return id;
    }

    public Long getTotalMemory() {
        return totalMemory;
    }

    public Long getUsedMemory() {
        return usedMemory;
    }

    public Long getActiveMemory() {
        return activeMemory;
    }

    public Long getInactiveMemory() {
        return inactiveMemory;
    }

    public Long getFreeMemory() {
        return freeMemory;
    }

    public Long getBufferMemory() {
        return bufferMemory;
    }

    public Long getSwapCache() {
        return swapCache;
    }

    public Long getTotalSwap() {
        return totalSwap;
    }

    public Long getUsedSwap() {
        return usedSwap;
    }

    public Long getFreeSwap() {
        return freeSwap;
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

    public Long getPagesPagedIn() {
        return pagesPagedIn;
    }

    public Long getPagesPagedOut() {
        return pagesPagedOut;
    }

    public Long getPagesSwappedIn() {
        return pagesSwappedIn;
    }

    public Long getPagesSwappedOut() {
        return pagesSwappedOut;
    }

    public Long getInterrupts() {
        return interrupts;
    }

    public Long getCpuContextSwitches() {
        return cpuContextSwitches;
    }

    public Long getBootTime() {
        return bootTime;
    }

    public Long getForks() {
        return forks;
    }

    public Date getDate() {
        return date;
    }

    public String getIpRunnerMachine() {
        return ipRunnerMachine;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Audit audit = (Audit) o;
        return id != null ? id.equals(audit.id) : audit.id == null;

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
