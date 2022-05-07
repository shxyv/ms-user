package com.atl.msuser.service;

import com.atl.msuser.dao.entity.User;
import com.atl.msuser.dao.repository.UserRepository;
import com.atl.msuser.model.dto.UserLoginDto;
import com.atl.msuser.model.dto.UserRegisterDto;
import com.atl.msuser.model.exception.UserAlreadyExistsException;
import com.atl.msuser.model.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

import static com.atl.msuser.mapper.UserMapper.INSTANCE;
import static com.atl.msuser.model.constant.FreeLicenceStatus.UNUSED;
import static com.atl.msuser.model.exception.ExceptionConstants.USER_ALREADY_EXISTS_EXCEPTION_CODE;
import static com.atl.msuser.model.exception.ExceptionConstants.USER_ALREADY_EXISTS_EXCEPTION_MESSAGE;
import static com.atl.msuser.model.exception.ExceptionConstants.USER_NOT_FOUND_EXCEPTION_CODE;
import static com.atl.msuser.model.exception.ExceptionConstants.USER_NOT_FOUND_EXCEPTION_MESSAGE_WITH_EMAIL;
import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User register(UserRegisterDto userRegisterDto){
        userRepository.getByEmail(userRegisterDto.getEmail()).ifPresent(s -> {
            throw new UserAlreadyExistsException(format(USER_ALREADY_EXISTS_EXCEPTION_MESSAGE,
                    userRegisterDto.getEmail()), USER_ALREADY_EXISTS_EXCEPTION_CODE);
        });
        var user = INSTANCE.mapDtoToEntity(userRegisterDto);
        user.setApiKey(String.valueOf(UUID.randomUUID()));
        user.setFreeLicenceStatus(UNUSED);
        return userRepository.save(user);
    }

    public String login(UserLoginDto userLoginDto){
        User user = userRepository.getByEmail(userLoginDto.getEmail()).orElseThrow(() -> new UserNotFoundException(
                format(USER_NOT_FOUND_EXCEPTION_MESSAGE_WITH_EMAIL, userLoginDto.getEmail()),
                USER_NOT_FOUND_EXCEPTION_CODE
        ));
        return user.getApiKey();
    }




}
