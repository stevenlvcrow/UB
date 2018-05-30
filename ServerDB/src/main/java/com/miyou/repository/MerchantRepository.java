package com.miyou.repository;

import com.miyou.tableVo.UbTest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MerchantRepository extends JpaRepository<UbTest, Long> {
}
