package com.miyou.tableVo;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
@Data
public class UbTtest {

    @Id
    @GeneratedValue
    String id;

    @Column(name = "name", nullable = true, length = 20)
    String name;

}
