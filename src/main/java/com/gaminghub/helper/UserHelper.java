package com.gaminghub.helper;

import com.gaminghub.dto.UserDto;
import com.gaminghub.entity.User;
import com.gaminghub.entity.UserType;
import com.gaminghub.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import static com.gaminghub.entity.UserType.USER_TYPE_CUSTOMER;

/**
 * @author rumi.dipto
 * @since 8/23/22
 */
@Component
public class UserHelper {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ModelMapper modelMapper;

    public UserDto convertUserToUserDto(User user) {
        return modelMapper.map(user, UserDto.class);
    }

    public User convertUserDtoToUser(UserDto userDto) {
        return modelMapper.map(userDto, User.class);
    }

    public User mapAndGetSavedCustomerForRegister(UserDto userDto) {
        User user = convertUserDtoToUser(userDto);
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setUserType(UserType.getUserTypeByLabel(userDto.getUserType()));
        user.setActivated(false);

        return userService.saveOrUpdate(user);
    }
}
