package com.UdemyProject.issuemanagement.service.impl;

import com.UdemyProject.issuemanagement.dto.ProjectDto;
import com.UdemyProject.issuemanagement.entitiy.Issue;
import com.UdemyProject.issuemanagement.entitiy.Project;
import com.UdemyProject.issuemanagement.repo.ProjectRepository;
import com.UdemyProject.issuemanagement.service.ProjectService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final ModelMapper modelMapper;

    public  ProjectServiceImpl (ProjectRepository projectRepository,ModelMapper modelMapper) {
        this.projectRepository = projectRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public Project save(Project project) {
        if (project.getProjectCode() == null) {
            throw new IllegalStateException("Project code cannot be null ");
        }
        project = projectRepository.save(project);
        return project;
    }

    @Override
    public ProjectDto getById(Long id) {
        Project p = projectRepository.getById(id);
        return modelMapper.map(p,ProjectDto.class);
    }

    @Override
    public List<Project> getByProjectCode(String projectCode) { return null; }

    @Override
    public List<Project> getByProjectCodeContains(String projectCode) {
        return null;
    }

    @Override
    public Page<Project> getAllPageable(Pageable pageable) {
        return projectRepository.findAll(pageable);
    }

    @Override
    public Boolean delete(Project project) {
        return null;
    }
}
