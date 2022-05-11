package com.UdemyProject.issuemanagement.service.impl;

import com.UdemyProject.issuemanagement.entitiy.User;
import com.UdemyProject.issuemanagement.repo.UserRepository;
import com.UdemyProject.issuemanagement.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(User user) {
        if(user.getEmail() == null) {
            throw new IllegalStateException("username cannnot be null");
        }
        user = userRepository.save(user);
        return user;
    }

    @Override
    public User getById(Long id) {
        return userRepository.getOne(id);
    }

    @Override
    public Page<User> getAllPageable(Pageable pageable) {
        return null;
    }

    @Override
    public User getByUsername(String username) {
        return null;
    }
}
