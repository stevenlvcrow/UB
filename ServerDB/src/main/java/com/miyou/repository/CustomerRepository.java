package com.miyou.repository;

import com.miyou.tableVo.UbTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

public interface CustomerRepository extends JpaRepository<UbTest, Long> {



    @Procedure(name = "deleteTestCase")
    String deleteTestCase(@Param("inParam1") String inParam1,
                   @Param("inParam2") String inParam2,
                   @Param("inParam3") String inParam3,
                   @Param("inParam4") String inParam4);

}
