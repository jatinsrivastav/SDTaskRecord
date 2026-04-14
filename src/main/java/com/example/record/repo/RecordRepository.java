package com.example.record.repo;

import com.example.record.Entity.RecordEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecordRepository extends JpaRepository<RecordEntity, Long> {

    List<RecordEntity> findByStatus(String status);

    List<RecordEntity> findByCategory(String category);
}