package com.miyou.repository;

import com.miyou.tableVo.UbUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoRespository extends JpaRepository<UbUser, Long> {
}
