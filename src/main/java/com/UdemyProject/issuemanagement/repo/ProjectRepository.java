package com.UdemyProject.issuemanagement.repo;

import com.UdemyProject.issuemanagement.entitiy.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface ProjectRepository extends JpaRepository<Project,Long> {

    List<Project> getByProjectCode(String projectCOde);
    List<Project> getByProjectCodeContains(String projectCOde);
    Page<Project> findAll(Pageable pageable);
    List<Project> findAll (Sort sort);
}
