package com.miyou.service.business;


import com.alibaba.fastjson.JSON;
import com.miyou.bean.PageRequest;
import com.miyou.bean.PageResponse;
import com.miyou.domain.BusinessContext;
import com.miyou.domain.BusinessResponse;
import com.miyou.domain.PaddingParam;
import com.miyou.framework.BuinessBean;
import com.miyou.framework.BuinessBridgeService;
import com.miyou.framework.BusinessException;
import com.miyou.service.db.MerchantService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;


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
        LinkedHashMap obj =  merchantService.merchantListPadding(req);
        BusinessResponse businessResponse = new BusinessResponse();
        PageResponse pageResponse = new PageResponse();
        pageResponse.setList((List) obj.get("content"));
        pageResponse.setTotal((Integer) obj.get("totalPages"));
        businessResponse.setResponseData(pageResponse);
        context.setBusinessResponse(businessResponse);
    }
}
