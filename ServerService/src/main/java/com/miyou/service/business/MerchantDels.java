package com.miyou.service.business;


import com.miyou.bean.DelsRequest;
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

@BuinessBean(actionType = "merchantDel", name = "商户批量删除", reqClass = DelsRequest.class, resClass = BusinessResponse.class)
@Service
@Slf4j
public class MerchantDels extends BuinessBridgeService {

    @Autowired
    MerchantService merchantService;

    @Override
    public void process(BusinessContext context) throws BusinessException, IllegalArgumentException {
        DelsRequest delsRequest = (DelsRequest) context.getBusinessRequest();

        Integer result = merchantService.merchantDel(delsRequest.getIds());
        if(result!=1){
            throw new BusinessException(BusinessConstant.ERR_CODE.FATAL, "删除数据失败.请重试");
        }
        context.setBusinessResponse(new BusinessResponse());
    }
}
