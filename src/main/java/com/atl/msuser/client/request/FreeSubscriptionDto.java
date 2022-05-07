package com.atl.msuser.client.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class FreeSubscriptionDto {
    @NotNull
    private Long userId;
}
