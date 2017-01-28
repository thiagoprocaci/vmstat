package com.tbp.controller;


import com.tbp.controller.dto.StatusGroup;
import com.tbp.controller.factory.StatusGroupFactory;
import com.tbp.domain.Audit;
import com.tbp.domain.AuditFactory;
import com.tbp.repository.AuditRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletRequest;
import java.util.List;


@RestController
@RequestMapping("audit")
public class AuditController {

    @Autowired
    AuditFactory auditFactory;
    @Autowired
    AuditRepository auditRepository;
    @Autowired
    StatusGroupFactory statusGroupFactory;


    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public Audit startsAuditing(
                                @RequestParam(value = "totalMemory") Long totalMemory,
                                @RequestParam(value = "usedMemory") Long usedMemory,
                                @RequestParam(value = "activeMemory") Long activeMemory,
                                @RequestParam(value = "inactiveMemory") Long inactiveMemory,
                                @RequestParam(value = "freeMemory") Long freeMemory,
                                @RequestParam(value = "bufferMemory") Long bufferMemory,
                                @RequestParam(value = "swapCache") Long swapCache,
                                @RequestParam(value = "totalSwap") Long totalSwap,
                                @RequestParam(value = "usedSwap") Long usedSwap,
                                @RequestParam(value = "freeSwap") Long freeSwap,
                                @RequestParam(value = "nonNiceUserCpuTicks") Long nonNiceUserCpuTicks,
                                @RequestParam(value = "niceUserCpuTicks") Long niceUserCpuTicks,
                                @RequestParam(value = "systemCpuTicks") Long systemCpuTicks,
                                @RequestParam(value = "idleCpuTicks") Long idleCpuTicks,
                                @RequestParam(value = "ioWaitCpuTicks") Long ioWaitCpuTicks,
                                @RequestParam(value = "irqCpuTicks") Long irqCpuTicks,
                                @RequestParam(value = "softirqCpuTicks") Long softirqCpuTicks,
                                @RequestParam(value = "stolenCpuTicks") Long stolenCpuTicks,
                                @RequestParam(value = "pagesPagedIn") Long pagesPagedIn,
                                @RequestParam(value = "pagesPagedOut") Long pagesPagedOut,
                                @RequestParam(value = "pagesSwappedIn") Long pagesSwappedIn,
                                @RequestParam(value = "pagesSwappedOut") Long pagesSwappedOut,
                                @RequestParam(value = "interrupts") Long interrupts,
                                @RequestParam(value = "cpuContextSwitches") Long cpuContextSwitches,
                                @RequestParam(value = "bootTime") Long bootTime,
                                @RequestParam(value = "forks") Long forks,
                                ServletRequest request) {
        String ipRunnerMachine = request.getRemoteAddr();
        Audit audit = auditFactory.create(ipRunnerMachine,  totalMemory,  usedMemory,  activeMemory,  inactiveMemory,  freeMemory,  bufferMemory,  swapCache,  totalSwap,  usedSwap,  freeSwap,  nonNiceUserCpuTicks,  niceUserCpuTicks,  systemCpuTicks,  idleCpuTicks,  ioWaitCpuTicks,  irqCpuTicks,  softirqCpuTicks,  stolenCpuTicks,  pagesPagedIn,  pagesPagedOut,  pagesSwappedIn,  pagesSwappedOut,  interrupts,  cpuContextSwitches,  bootTime,  forks);
        return auditRepository.save(audit);
    }

    @CrossOrigin
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Iterable<Audit> list() {
        return auditRepository.findAll();
    }

    @CrossOrigin
    @RequestMapping(value = "/status", method = RequestMethod.GET)
    public StatusGroup listStatus(@RequestParam(value = "ipRunnerMachine") String ipRunnerMachine) {
        List<Audit> auditList = auditRepository.findTop4ByIpRunnerMachineOrderByDateDesc(ipRunnerMachine);
        return statusGroupFactory.create(auditList);
    }

}
