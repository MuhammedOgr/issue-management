package com.UdemyProject.issuemanagement.api;


import com.UdemyProject.issuemanagement.dto.IssueDetailDto;
import com.UdemyProject.issuemanagement.dto.IssueDto;
import com.UdemyProject.issuemanagement.entity.IssueStatus;
import com.UdemyProject.issuemanagement.service.impl.IssueServiceImpl;
import com.UdemyProject.issuemanagement.util.ApiPaths;
import com.UdemyProject.issuemanagement.util.TPage;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(ApiPaths.IssueCtrl.CTRL)
public class IssueController {

    private final IssueServiceImpl issueServiceImpl;

    public IssueController(IssueServiceImpl issueServiceImpl) {
        this.issueServiceImpl = issueServiceImpl;
    }

    @GetMapping("/pagination")
    @ApiOperation(value = "Get By Pagination Operation", response = IssueDto.class)
    public ResponseEntity<TPage<IssueDto>> getAllByPagination(Pageable pageable) {
        TPage<IssueDto> data = issueServiceImpl.getAllPageable(pageable);
        return ResponseEntity.ok(data);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get By Id Operation" , response = IssueDto.class)
    public ResponseEntity<IssueDto> getById(@PathVariable("id") Long id) {
        IssueDto projectDto = issueServiceImpl.getById(id);
        return ResponseEntity.ok(projectDto);
    }

    @GetMapping("/detail/{id}")
    @ApiOperation(value = "Get By Id Operation", response = IssueDto.class)
    public ResponseEntity<IssueDetailDto> getByIdWithDetails(@PathVariable(value = "id", required = true) Long id) {
        IssueDetailDto detailDto = issueServiceImpl.getByIdWithDetails(id);
        return ResponseEntity.ok(detailDto);
    }

    @PostMapping
    @ApiOperation(value = "Create Operation" , response = IssueDto.class)
    public ResponseEntity<IssueDto> createProject(@Validated @RequestBody IssueDto project) {
        return ResponseEntity.ok(issueServiceImpl.save(project));
    }
    @PutMapping("/{id}")
    @ApiOperation(value = "Update Operation" , response = IssueDto.class)
    public ResponseEntity<IssueDto> updateProject(@PathVariable("id") Long id,@Validated @RequestBody IssueDto project) {
        return ResponseEntity.ok(issueServiceImpl.update(id,project));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete Operation" , response = Boolean.class)
    public ResponseEntity<Boolean> delete(@PathVariable(value = "id",required = true) Long id) {
        return ResponseEntity.ok(issueServiceImpl.delete(id));
    }

    @GetMapping("/statuses")
    @ApiOperation(value = "Get All Issue Statuses Operation", response = String.class, responseContainer = "List")
    public ResponseEntity<List<IssueStatus>> getAll() {
        return ResponseEntity.ok(Arrays.asList(IssueStatus.values()));
    }
}
