package com.miyou.bean;

import com.miyou.domain.BusinessRequest;
import lombok.Data;

@Data
public class DelsRequest extends BusinessRequest {

    String ids[];
}
