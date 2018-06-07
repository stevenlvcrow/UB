package com.miyou.tableVo;


import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class UbMerchant  implements java.io.Serializable{

    private String id;

    public void setId(String id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    public String getId() {
        return id;
    }

    @NotEmpty(message = "姓名不能为空")
    @Column(name = "name", length = 20)
    private String name;

    @NotEmpty(message = "联系方式不能为空")
    @Column(name = "tel", length = 20)
    private String tel;

    @Column(name = "merchantNo", length = 20)
    private String merchantNo;

}
