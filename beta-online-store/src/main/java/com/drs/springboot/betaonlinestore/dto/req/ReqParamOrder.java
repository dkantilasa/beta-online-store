package com.drs.springboot.betaonlinestore.dto.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class ReqParamOrder {
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ReqMakeOrder{
        private long userId;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ReqDeleteOrder{
        private long orderId;
    }
}
