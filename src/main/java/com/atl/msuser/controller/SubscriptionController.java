package com.atl.msuser.controller;

import com.atl.msuser.client.request.FreeSubscriptionDto;
import com.atl.msuser.client.request.PremiumSubscriptionDto;
import com.atl.msuser.model.constant.TopicType;
import com.atl.msuser.service.SubscriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("users/subscriptions")
@RequiredArgsConstructor
public class SubscriptionController {

    private final SubscriptionService subscriptionService;

    @PostMapping("/free")
    public void getFreeSubscription(@RequestBody @Valid FreeSubscriptionDto freeSubscriptionDto,
                                    @RequestParam TopicType topicType) {
        subscriptionService.getFreeSubscription(freeSubscriptionDto, topicType);
    }

    @PostMapping("/premium")
    public void getPremiumSubscription(@RequestBody @Valid PremiumSubscriptionDto premiumSubscriptionDto,
                                       @RequestParam TopicType topicType) {
        subscriptionService.getPremiumSubscription(premiumSubscriptionDto, topicType);
    }


}
