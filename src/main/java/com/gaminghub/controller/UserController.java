package com.gaminghub.controller;

import com.gaminghub.dto.UserDto;
import com.gaminghub.helper.UserHelper;
import com.gaminghub.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author rumi.dipto
 * @since 8/22/22
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserHelper userHelper;

    @GetMapping
    public ResponseEntity<UserDto> showUser(@RequestParam int id) {
        UserDto userDto = userHelper.convertUserToUserDto(userService.find(id));

        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

//    @GetMapping(name = "/userList")
//    public ResponseEntity<List<UserDto>> showUserList() {
//        List<UserDto> userDtoList = userService.findAll()
//                .stream()
//                .map(user -> userHelper.convertUsertoUserDto(user))
//                .collect(Collectors.toList());
//
//        return new ResponseEntity<>(userDtoList, HttpStatus.OK);
//    }

    @PostMapping(name = "/save")
    public ResponseEntity<?> saveUser(@RequestBody UserDto userDto) {
        userService.saveOrUpdate(userHelper.convertUserDtoToUser(userDto));

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping(name = "/update")
    public ResponseEntity<?> updateUser(@RequestBody UserDto userDto) {
        userService.saveOrUpdate(userHelper.convertUserDtoToUser(userDto));

        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
