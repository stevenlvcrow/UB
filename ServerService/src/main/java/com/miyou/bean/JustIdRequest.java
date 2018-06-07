package com.miyou.bean;

import com.miyou.domain.BusinessRequest;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

@Data
public class JustIdRequest extends BusinessRequest {

    @NotEmpty(message="会员ID不能为空")
    private String id;
}
