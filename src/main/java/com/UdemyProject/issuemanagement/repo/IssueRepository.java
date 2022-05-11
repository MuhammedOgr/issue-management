package com.UdemyProject.issuemanagement.repo;

import com.UdemyProject.issuemanagement.entitiy.Issue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssueRepository extends JpaRepository<Issue, Long> {
}
