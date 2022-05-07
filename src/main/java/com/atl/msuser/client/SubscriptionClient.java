package com.atl.msuser.client;

import com.atl.msuser.client.request.FreeSubscriptionDto;
import com.atl.msuser.client.request.PremiumSubscriptionDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(
        name = "subscriptionClient",
        url = "${client.subscription.url}",
        decode404 = true
)
public interface SubscriptionClient {

    @PostMapping("/free")
    void getFreeSubscription(FreeSubscriptionDto freeSubscriptionDto);

    @PostMapping("/premium")
    void getPremiumSubscription(PremiumSubscriptionDto premiumSubscriptionDto);
}
