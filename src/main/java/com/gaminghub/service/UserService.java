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

    public List<User> findAll() {
        return userRepository.findAll(Sort.by(Sort.Direction.DESC));
    }

    public void saveOrUpdate(User user) {
        userRepository.save(user);
    }
}
