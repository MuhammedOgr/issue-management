package com.UdemyProject.issuemanagement.service;

import com.UdemyProject.issuemanagement.dto.UserDto;
import com.UdemyProject.issuemanagement.entity.User;
import com.UdemyProject.issuemanagement.util.TPage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {

    UserDto save(UserDto user);

    UserDto getById(Long id);

    TPage<UserDto> getAllPageable(Pageable pageable);

    UserDto getByUsername(String username);
}
