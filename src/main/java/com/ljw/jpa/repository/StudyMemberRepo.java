package com.ljw.jpa.repository;

import com.ljw.jpa.entity.Study_member;
import com.ljw.jpa.entity.Study_record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudyMemberRepo extends JpaRepository<Study_member, Integer> {
    List<Study_member> findByLoginIdContains(String searchLoginId);

}
