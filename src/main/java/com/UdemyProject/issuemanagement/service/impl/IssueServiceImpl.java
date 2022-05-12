package com.UdemyProject.issuemanagement.service.impl;

import com.UdemyProject.issuemanagement.dto.IssueDto;
import com.UdemyProject.issuemanagement.entitiy.Issue;
import com.UdemyProject.issuemanagement.repo.IssueRepository;
import com.UdemyProject.issuemanagement.service.IssueService;
import com.UdemyProject.issuemanagement.util.TPage;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class IssueServiceImpl implements IssueService {

    private final IssueRepository issueRepository;
    private final ModelMapper modelMapper;

    public IssueServiceImpl(IssueRepository issueRepository, ModelMapper modelMapper) {
        this.issueRepository = issueRepository;
        this.modelMapper = modelMapper;

    }

    @Override
    public IssueDto getById(Long id) {
        Issue issue = issueRepository.getOne(id);
        return modelMapper.map(issue, IssueDto.class);
    }

    @Override
    public TPage<IssueDto> getAllPageable(Pageable pageable) {
        Page<Issue> data = issueRepository.findAll(pageable);
        TPage<IssueDto> response = new TPage<>();
        response.setStat(data, Arrays.asList(modelMapper.map(data.getContent(), IssueDto.class)));
        return response;
    }

    @Override
    public Boolean delete(Long issueId) {
        issueRepository.deleteById(issueId);
        return true;
    }

    @Override
    public IssueDto save(IssueDto issue) {
        if (issue.getDate() == null) {
            throw new IllegalStateException("issue date cannot be null");

        }
        Issue issueEntity = modelMapper.map(issue, Issue.class);
        issueEntity = issueRepository.save(issueEntity);
        issue.setId(issueEntity.getId());
        return issue;
    }

    @Override
    public IssueDto update(Long id, IssueDto issueDto) {
        Issue issue = issueRepository.getOne(id);
        if (issue == null)
            throw new IllegalStateException("İssue does not exist id:" + id);

        issue.setDescription(issueDto.getDescription());
        issue.setDetails(issueDto.getDetails());
        issue.setDate(issueDto.getDate());
        issue.setIssueStatus(issueDto.getIssueStatus());
        issueRepository.save(issue);
        return modelMapper.map(issue,IssueDto.class);
    }
}
