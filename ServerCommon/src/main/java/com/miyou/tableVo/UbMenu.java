package com.miyou.tableVo;


import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class UbMenu implements java.io.Serializable{

    @Id
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

    @Transient
    private List<UbMenu> children;

}
