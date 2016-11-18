package com.tbp.repository;


import com.tbp.domain.Audit;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.List;

public interface AuditRepository extends CrudRepository<Audit, Long> {

    @Query("select distinct(a.ipRunnerMachine) from Audit a")
    Collection<String> findAllIp();

    List<Audit> findByIpRunnerMachine(String ipRunnerMachine);


}
