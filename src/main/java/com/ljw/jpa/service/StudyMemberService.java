package com.ljw.jpa.service;

import com.ljw.jpa.entity.Study_member;
import com.ljw.jpa.entity.Study_record;
import com.ljw.jpa.repository.StudyMemberRepo;
import com.ljw.jpa.repository.StudyRecordRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.ljw.jpa.comm.CommUtil.encryptSha256;

@Service
public class StudyMemberService {

    @Autowired
    StudyMemberRepo studyMemberRepo;

    public List<Study_member> doSelectAll() {

        return studyMemberRepo.findAll();
    }

    public List<Study_member> doSearch(String searchLoginId) {

        return studyMemberRepo.findByLoginIdContains(searchLoginId);
    }

    public Study_member doSelectById(int id) {

        return studyMemberRepo.findById(id).get();
    }

    public void doInsert(Study_member member) {
        member.setPassword(encryptSha256(member.getPassword()));
        studyMemberRepo.save(member);
    }

    public void doUpdate(Study_member member) {
        studyMemberRepo.save(member);
    }
    public void doDelete(int id) {
        studyMemberRepo.deleteById(id);
    }
}
