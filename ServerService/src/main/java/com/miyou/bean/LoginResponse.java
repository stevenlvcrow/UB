package com.miyou.bean;

import com.miyou.tableVo.UbMenu;
import com.miyou.tableVo.UbMerchant;
import com.miyou.tableVo.UbUser;
import lombok.Data;

@Data
public class LoginResponse {

    private String publicKey;

    private UbMerchant merchant;

    private UbUser ubUser;

    private UbMenu ubMenu;

}
