package com.miyou.bean;

import com.miyou.domain.BusinessRequest;
import com.miyou.tableVo.UbMerchant;
import lombok.Data;

@Data
public class MerchantSaveRequest extends BusinessRequest {

    UbMerchant ubMerchant;
}
