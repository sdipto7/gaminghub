package com.gaminghub.service;

import com.gaminghub.entity.User;
import com.gaminghub.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author rumi.dipto
 * @since 8/22/22
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User find(int id) {
        Optional<User> user = userRepository.findById(id);

        return user.isPresent() ? user.get() : null;
    }

    public User findByUsername(String username) {
        Optional<User> user = userRepository.findByUsername(username);

        return user.isPresent() ? user.get() : null;
    }

    public Boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    public boolean isValidUser(String username, String accessToken) {
        return existsByUsername(username)
                ? findByUsername(username).getAccessToken().equals(accessToken)
                : false;
    }

    public List<User> findAll() {
        return userRepository.findAll(Sort.by(Sort.Direction.DESC));
    }

    public User saveOrUpdate(User user) {
        return userRepository.save(user);
    }
}
