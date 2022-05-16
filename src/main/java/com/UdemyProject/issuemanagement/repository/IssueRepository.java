package com.UdemyProject.issuemanagement.repository;

import com.UdemyProject.issuemanagement.entity.Issue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssueRepository extends JpaRepository<Issue, Long> {
}
