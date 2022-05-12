package com.UdemyProject.issuemanagement.api;


import com.UdemyProject.issuemanagement.dto.IssueDto;
import com.UdemyProject.issuemanagement.service.impl.IssueServiceImpl;
import com.UdemyProject.issuemanagement.util.ApiPaths;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ApiPaths.IssueCtrl.CTRL)
public class IssueController {

    private final IssueServiceImpl issueServiceImpl;

    public IssueController(IssueServiceImpl issueServiceImpl) {
        this.issueServiceImpl = issueServiceImpl;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get By Id Operation" , response = IssueDto.class)
    public ResponseEntity<IssueDto> getById(@PathVariable("id") Long id) {
        IssueDto projectDto = issueServiceImpl.getById(id);
        return ResponseEntity.ok(projectDto);
    }

    @PostMapping()
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
}
