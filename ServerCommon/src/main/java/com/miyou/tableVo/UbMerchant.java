package com.miyou.tableVo;


import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class UbMerchant {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    private String id;

    @Column(name = "name", length = 20)
    private String name;

    @Column(name = "tel", length = 20)
    private String tel;

    @Column(name = "merchantNo", length = 20)
    private String merchantNo;

}
