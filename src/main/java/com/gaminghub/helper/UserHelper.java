package com.gaminghub.helper;

import com.gaminghub.dto.UserDto;
import com.gaminghub.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author rumi.dipto
 * @since 8/23/22
 */
@Component
public class UserHelper {

    @Autowired
    private ModelMapper modelMapper;

    public UserDto convertUsertoUserDto(User user) {
        return modelMapper.map(user, UserDto.class);
    }

    public User convertUserDtoToUser(UserDto userDto) {
        return modelMapper.map(userDto, User.class);
    }
}
