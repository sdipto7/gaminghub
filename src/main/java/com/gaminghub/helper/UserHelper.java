package com.gaminghub.helper;

import com.gaminghub.dto.UserDto;
import com.gaminghub.entity.User;
import com.gaminghub.entity.UserType;
import com.gaminghub.model.SignUpRequest;
import com.gaminghub.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

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

    public UserDto convertUsertoUserDto(User user) {
        return modelMapper.map(user, UserDto.class);
    }

    public User convertUserDtoToUser(UserDto userDto) {
        return modelMapper.map(userDto, User.class);
    }

    public User getSavedUserFromSignUpRequest(SignUpRequest signUpRequest) {
        User user = new User();
        user.setFirstName(signUpRequest.getFirstName());
        user.setLastName(signUpRequest.getLastName());
        user.setUsername(signUpRequest.getUsername());
        user.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
        user.setAddress(signUpRequest.getAddress());
        user.setUserType(UserType.getUserTypeByLabel(signUpRequest.getUserType()));
        user.setActivated(false);

        return userService.saveOrUpdate(user);
    }
}
