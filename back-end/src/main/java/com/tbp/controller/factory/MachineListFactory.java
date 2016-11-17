package com.tbp.controller.factory;


import com.tbp.controller.dto.Machine;
import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class MachineListFactory {

    public List<Machine> create(Collection<String> ipList) {
        List<Machine> machineList = new ArrayList<>();
        if(ipList != null) {
            for(String ip: ipList) {
                machineList.add(new Machine(ip));
            }
        }
        return machineList;
    }

}
