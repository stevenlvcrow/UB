package com.miyou.service.business;

import com.miyou.bean.MerchantSaveRequest;
import com.miyou.constant.BusinessConstant;
import com.miyou.domain.BusinessContext;
import com.miyou.domain.BusinessResponse;
import com.miyou.framework.BuinessBean;
import com.miyou.framework.BuinessBridgeService;
import com.miyou.framework.BusinessException;
import com.miyou.service.db.MerchantService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@BuinessBean(actionType = "merchantSave", name = "商户保存或者更新", reqClass = MerchantSaveRequest.class, resClass = BusinessResponse.class)
@Service
@Slf4j
public class MerchantSave extends BuinessBridgeService {

    @Autowired
    MerchantService merchantService;

    @Override
    public void process(BusinessContext context) throws BusinessException, IllegalArgumentException {
        MerchantSaveRequest merchantSaveRequest = (MerchantSaveRequest) context.getBusinessRequest();
        Integer result = merchantService.merchantSaveAndFlush(merchantSaveRequest.getUbMerchant());
        if(result!=1){
            throw new BusinessException(BusinessConstant.ERR_CODE.FATAL, "更新数据失败.请重试");
        }
        context.setBusinessResponse(new BusinessResponse());

    }
}
