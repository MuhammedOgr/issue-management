package com.UdemyProject.issuemanagement.service;

import com.UdemyProject.issuemanagement.dto.ProjectDto;
import com.UdemyProject.issuemanagement.entitiy.Issue;
import com.UdemyProject.issuemanagement.entitiy.Project;
import com.UdemyProject.issuemanagement.entitiy.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProjectService {

    Project save (Project project);
    ProjectDto getById (Long id);
    List<Project> getByProjectCode(String projectCode);
    List<Project> getByProjectCodeContains(String projectCode);
    Page<Project> getAllPageable(Pageable pageable);
    Boolean delete(Project project);
}
