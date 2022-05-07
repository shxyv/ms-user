package com.atl.msuser.client.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class PremiumSubscriptionDto {
    @NotNull
    private Long userId;
    @NotNull
    private Long paymentId;
    @NotNull
    private Long accountId;
}
