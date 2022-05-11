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
        this.modelMapper = modelMapper;
        this.issueRepository = issueRepository;
    }

    @Override
    public IssueDto save(IssueDto issueDto) {
        if(issueDto.getDate() == null) {
            throw new IllegalStateException("issue date cannot be null");

        }
        Issue issueEntity = modelMapper.map(issueDto , Issue.class);
        issueEntity=  issueRepository.save(issueEntity);
        return modelMapper.map(issueEntity,IssueDto.class);
    }

    @Override
    public IssueDto getById(Long id) {
        return null;
    }

    @Override
    public TPage<IssueDto> getAllPageable(Pageable pageable) {
        Page<Issue> data = issueRepository.findAll(pageable);
        TPage page = new TPage<IssueDto>();
        IssueDto[] dtos = modelMapper.map(data.getContent(),IssueDto[].class);
        page.setStat(data, Arrays.asList(dtos));
        return page;
    }

    @Override
    public Boolean delete(IssueDto issue) {
        return null;
    }
}
