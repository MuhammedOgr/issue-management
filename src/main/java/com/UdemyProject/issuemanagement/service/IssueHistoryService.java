package com.UdemyProject.issuemanagement.service;

import com.UdemyProject.issuemanagement.dto.IssueHistoryDto;
import com.UdemyProject.issuemanagement.entity.Issue;
import com.UdemyProject.issuemanagement.entity.IssueHistory;
import com.UdemyProject.issuemanagement.util.TPage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IssueHistoryService {

    IssueHistoryDto save(IssueHistoryDto issueHistory);

    IssueHistoryDto getById(Long id);

    List<IssueHistoryDto> getByIssueId(Long id);

    TPage<IssueHistoryDto> getAllPageable(Pageable pageable);

    Boolean delete(IssueHistoryDto issueHistory);

    void addHistory(Long id, Issue issue);
}
