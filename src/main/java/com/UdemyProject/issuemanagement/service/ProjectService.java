package com.UdemyProject.issuemanagement.service;

import com.UdemyProject.issuemanagement.dto.ProjectDto;
import com.UdemyProject.issuemanagement.entitiy.Issue;
import com.UdemyProject.issuemanagement.entitiy.Project;
import com.UdemyProject.issuemanagement.entitiy.User;
import com.UdemyProject.issuemanagement.util.TPage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProjectService {

    ProjectDto save(ProjectDto project);

    ProjectDto getById(Long id);

    ProjectDto getByProjectCode(String projectCode);

    List<ProjectDto> getByProjectCodeContains(String projectCode);

    TPage<ProjectDto> getAllPageable(Pageable pageable);

    Boolean delete(ProjectDto project);

    ProjectDto update(Long id, ProjectDto project);
}
