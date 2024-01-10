package com.drs.springboot.betaonlinestore.dto.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class ReqParamCart {
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ReqAddToCart{
        private long userId;
        private long productId;
        private int qty;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ReqRemoveFromCart{
        private long cartId;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ReqUpdateQuantity{
        private long cartId;
        private int qty;
    }

}
