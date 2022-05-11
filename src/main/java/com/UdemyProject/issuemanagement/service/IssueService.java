package com.UdemyProject.issuemanagement.service;

import com.UdemyProject.issuemanagement.dto.IssueDto;
import com.UdemyProject.issuemanagement.entitiy.Issue;
import com.UdemyProject.issuemanagement.util.TPage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IssueService {

    IssueDto save (IssueDto issue);
    IssueDto getById (Long id);
    TPage<IssueDto> getAllPageable(Pageable pageable);
    Boolean delete (IssueDto issue);
}
