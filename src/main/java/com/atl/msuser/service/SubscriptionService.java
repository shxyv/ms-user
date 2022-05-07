package com.atl.msuser.service;

import com.atl.msuser.client.SubscriptionClient;
import com.atl.msuser.client.request.FreeSubscriptionDto;
import com.atl.msuser.client.request.PremiumSubscriptionDto;
import com.atl.msuser.dao.repository.UserRepository;
import com.atl.msuser.model.constant.TopicType;
import com.atl.msuser.model.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.atl.msuser.model.constant.FreeLicenceStatus.*;
import static com.atl.msuser.model.exception.ExceptionConstants.USER_NOT_FOUND_EXCEPTION_CODE;
import static com.atl.msuser.model.exception.ExceptionConstants.USER_NOT_FOUND_EXCEPTION_MESSAGE_WITH_ID;
import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class SubscriptionService {

    private final SubscriptionClient subscriptionClient;
    private final UserRepository userRepository;

    public void getFreeSubscription(FreeSubscriptionDto freeSubscriptionDto, TopicType topicType) {
        var user = userRepository.findById(freeSubscriptionDto.getUserId()).orElseThrow(
                () -> new UserNotFoundException(
                        format(USER_NOT_FOUND_EXCEPTION_MESSAGE_WITH_ID, freeSubscriptionDto.getUserId()),
                        USER_NOT_FOUND_EXCEPTION_CODE
                )
        );
        user.setFreeLicenceStatus(IN_USE);
        user.setTopicType(topicType);
        userRepository.save(user);
        subscriptionClient.getFreeSubscription(freeSubscriptionDto);
    }

    public void getPremiumSubscription(PremiumSubscriptionDto premiumSubscriptionDto, TopicType topicType) {
        var user = userRepository.findById(premiumSubscriptionDto.getUserId()).orElseThrow(
                () -> new UserNotFoundException(
                        format(USER_NOT_FOUND_EXCEPTION_MESSAGE_WITH_ID, premiumSubscriptionDto.getUserId()),
                        USER_NOT_FOUND_EXCEPTION_CODE
                )
        );
        user.setTopicType(topicType);
        userRepository.save(user);
        subscriptionClient.getPremiumSubscription(premiumSubscriptionDto);
    }


}
