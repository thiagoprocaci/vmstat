package com.tbp.controller;

import com.tbp.controller.dto.Machine;
import com.tbp.controller.factory.MachineListFactory;
import com.tbp.repository.AuditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("machine")
public class MachineController {

    @Autowired
    AuditRepository auditRepository;
    @Autowired
    MachineListFactory machineListFactory;

    @CrossOrigin
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Collection<Machine> find() {
        return machineListFactory.create(auditRepository.findAllIp());
    }

}
