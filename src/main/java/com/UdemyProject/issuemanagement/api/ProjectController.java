package com.UdemyProject.issuemanagement.api;

import com.UdemyProject.issuemanagement.service.impl.ProjectServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/project")
public class ProjectController {

    private final ProjectServiceImpl projectServiceImpl;

    public ProjectController(ProjectServiceImpl projectServiceImpl) {
        this.projectServiceImpl = projectServiceImpl;
        this.projectServiceImpl.getById(1L);
    }

}
