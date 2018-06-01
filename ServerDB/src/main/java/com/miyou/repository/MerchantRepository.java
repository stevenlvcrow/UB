package com.miyou.repository;

import com.miyou.tableVo.UbMerchant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MerchantRepository extends JpaRepository<UbMerchant, Long> {
}
