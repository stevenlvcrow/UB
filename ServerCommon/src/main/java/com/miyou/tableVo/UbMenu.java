package com.miyou.tableVo;


import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class UbMenu implements java.io.Serializable{

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    private String id;

    @Column(name = "name", length = 10)
    private String name;

    @Column(name = "url", length = 20)
    private String url;

    @Column(name = "path", length = 10)
    private String path;

    @Column(name = "isRoot", length = 1)
    private Integer isRoot;

    @Column(name = "hidden", length = 1)
    private Integer hidden;

    @Column(name = "iconCls", length = 20)
    private String iconCls;

    private UbMenu children;

}
