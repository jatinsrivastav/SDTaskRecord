package com.example.record.controller;

import com.example.record.DTO.RecordDTO;
import com.example.record.service.RecordService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/records")
public class RecordController {

    @Autowired
    private RecordService service;

    @PostMapping
    public ResponseEntity<RecordDTO> add(@Valid @RequestBody RecordDTO dto) {
        RecordDTO savedDto = service.addRecord(dto);
        return new ResponseEntity<>(savedDto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<RecordDTO>> getAll(
            @RequestParam(required = false) String status,
            @RequestParam(required = false) String category) {
        return ResponseEntity.ok(service.getAll(status, category));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RecordDTO> update(
            @PathVariable Long id,
            @RequestBody RecordDTO dto) {

        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok("Deleted successfully");
    }
}