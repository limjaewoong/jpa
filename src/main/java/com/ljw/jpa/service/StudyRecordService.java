package com.ljw.jpa.service;

import com.ljw.jpa.entity.Study_record;
import com.ljw.jpa.repository.StudyRecordRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudyRecordService {

    @Autowired
    StudyRecordRepo studyRecordRepo;

    public List<Study_record> doSelectAll() {
       // return studyRecordRepo.findAll();
        return studyRecordRepo.findJpqlAll();
    }

    public Study_record doSelectById(int id) {
        return studyRecordRepo.findById(id).get();
    }

    public void doInsert(Study_record record) {
        studyRecordRepo.save(record);
    }

    public void doUpdate(Study_record record) {
        studyRecordRepo.save(record);
    }
    public void doDelete(int id) {
        studyRecordRepo.deleteById(id);
    }
}
