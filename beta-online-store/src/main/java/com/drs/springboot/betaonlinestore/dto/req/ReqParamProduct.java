package com.drs.springboot.betaonlinestore.dto.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class ReqParamProduct {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class convertProductById{
        private long productId;
        private String toConversion;
    }
}
