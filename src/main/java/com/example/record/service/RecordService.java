package com.example.record.service;



import com.example.record.DTO.RecordDTO;
import com.example.record.Entity.RecordEntity;
import com.example.record.Exception.ResourceNotFoundException;
import com.example.record.repo.RecordRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RecordService {

    @Autowired
    private RecordRepository repository;

    private static final Logger log = LoggerFactory.getLogger(RecordService.class);

    public RecordDTO addRecord(RecordDTO dto) {
        log.info("Saving record: {}", dto);

        RecordEntity saved = repository.save(mapToEntity(dto));
        return mapToDTO(saved);
    }

    public List<RecordDTO> getAll(String status, String category) {
        List<RecordEntity> list;

        if (status != null)
            list = repository.findByStatus(status);
        else if (category != null)
            list = repository.findByCategory(category);
        else
            list = repository.findAll();

        return list.stream().map(this::mapToDTO).toList();
    }

    public RecordDTO update(Long id, RecordDTO dto) {
        RecordEntity existing = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Record not found with id: " + id));

        if (dto.getName() != null)
            existing.setName(dto.getName());

        if (dto.getStatus() != null)
            existing.setStatus(dto.getStatus());

        if (dto.getCategory() != null)
            existing.setCategory(dto.getCategory());

        return mapToDTO(repository.save(existing));
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Record not found with id: " + id);
        }
        repository.deleteById(id);
    }

    private RecordEntity mapToEntity(RecordDTO dto) {
        RecordEntity r = new RecordEntity();
        r.setName(dto.getName());
        r.setCategory(dto.getCategory());
        r.setStatus(dto.getStatus());
        return r;
    }

    private RecordDTO mapToDTO(RecordEntity r) {
        RecordDTO dto = new RecordDTO();
        dto.setId(r.getId());
        dto.setName(r.getName());
        dto.setCategory(r.getCategory());
        dto.setStatus(r.getStatus());
        return dto;
    }
}