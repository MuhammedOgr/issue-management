package com.UdemyProject.issuemanagement.repo;

import com.UdemyProject.issuemanagement.entitiy.IssueHistory;
import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssueHistoryRepository extends JpaRepository<IssueHistory,Long> {
}
