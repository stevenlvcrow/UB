package com.miyou.repository;

import com.miyou.tableVo.UbTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import javax.persistence.QueryHint;

import static org.hibernate.jpa.QueryHints.HINT_COMMENT;

public interface CustomerRepository extends JpaRepository<UbTest, Long> {


    /**
     * 一个参数，匹配两个字段
     * @param name2
     * @Param pageable 分页参数
     * @return
     * 这里Param的值和=:后面的参数匹配，但不需要和方法名对应的参数值对应
     * 这里增加了@QueryHints注解，是给查询添加一些额外的提示
     * 比如当前的name值为HINT_COMMENT是在查询的时候带上一些备注信息
     */
    @QueryHints(value = { @QueryHint(name = HINT_COMMENT, value = "a query for pageable")})
    @Query("select c from UbTest c where c.name=:name or c.name=:name")
    Page<UbTest> findByName(@Param("name") String name2, Pageable pageable);

    @Procedure(name = "deleteTestCase")
    String deleteTestCase(@Param("inParam1") String inParam1,
                   @Param("inParam2") String inParam2,
                   @Param("inParam3") String inParam3,
                   @Param("inParam4") String inParam4);

}
