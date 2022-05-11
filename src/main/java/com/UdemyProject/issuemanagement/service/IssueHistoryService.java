package com.UdemyProject.issuemanagement.service;

import com.UdemyProject.issuemanagement.entitiy.Issue;
import com.UdemyProject.issuemanagement.entitiy.IssueHistory;
import com.UdemyProject.issuemanagement.entitiy.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IssueHistoryService {

    IssueHistory save (IssueHistory issueHistory);
    IssueHistory getById (Long id);
    Page<IssueHistory> getAllPageable(Pageable pageable);
    Boolean delete(IssueHistory issueHistory);
}
