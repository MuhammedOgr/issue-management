package com.UdemyProject.issuemanagement.service;

import com.UdemyProject.issuemanagement.entitiy.Issue;
import com.UdemyProject.issuemanagement.entitiy.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {

    User save (User user);
    User getById (Long id);
    Page<User> getAllPageable(Pageable pageable);
    User getByUsername(String username);
}
