package com.atl.msuser.mapper;



import com.atl.msuser.dao.entity.User;
import com.atl.msuser.model.dto.UserRegisterDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User mapDtoToEntity(UserRegisterDto registerDto);
}
