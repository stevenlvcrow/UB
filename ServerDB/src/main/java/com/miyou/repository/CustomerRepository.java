package com.miyou.repository;

import com.miyou.tableVo.UbTest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Map;

public interface CustomerRepository extends CrudRepository<UbTest, Long> {



    @Procedure(name = "deleteTestCase")
    String deleteTestCase(@Param("inParam1") String inParam1,
                   @Param("inParam2") String inParam2,
                   @Param("inParam3") String inParam3,
                   @Param("inParam4") String inParam4);
}
