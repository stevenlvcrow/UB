package com.miyou.service.business;


import com.miyou.bean.PageRequest;
import com.miyou.domain.BusinessContext;
import com.miyou.domain.BusinessResponse;
import com.miyou.domain.PaddingParam;
import com.miyou.framework.BuinessBean;
import com.miyou.framework.BuinessBridgeService;
import com.miyou.framework.BusinessException;
import com.miyou.service.db.MerchantService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@BuinessBean(actionType = "merchantList", name = "商户列表查询", reqClass = PageRequest.class, resClass = BusinessResponse.class)
@Service
@Slf4j
public class MerchantListPage extends BuinessBridgeService {

    @Autowired
    MerchantService merchantService;

    @Override
    public void process(BusinessContext context) throws BusinessException, IllegalArgumentException {
        PageRequest pageRequest = (PageRequest) context.getBusinessRequest();
        PaddingParam req = pageRequest.getPaddingParam();
        Object obj =  merchantService.merchantListPadding(req);
        //LinkedHashMap pageResult = (LinkedHashMap) obj;
        BusinessResponse businessResponse = new BusinessResponse();
        businessResponse.setResponseData(obj);
        context.setBusinessResponse(businessResponse);
    }
}
