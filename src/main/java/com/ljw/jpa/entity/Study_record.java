package com.ljw.jpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@TableGenerator(name = "STUDY_RECORD_SEQ1", initialValue = 1, allocationSize = 1)
public class Study_record {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "STUDY_RECORD_SEQ1")
    private int key_id;

    @Column(name = "study_day", columnDefinition = "varchar(255) not null")
    private String study_day;

    @Column(name = "contents", nullable = true, length = 1000)
    private String contents;

    @Column(columnDefinition = "datetime(6) default CURRENT_TIMESTAMP", insertable = true, updatable = false)
    @CreationTimestamp
    private LocalDateTime reg_day;

    @Column(columnDefinition = "datetime(6) default CURRENT_TIMESTAMP", insertable = false, updatable = true)
    @UpdateTimestamp
    private LocalDateTime mod_day;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Study_member study_member;

    @Transient
    private String memo;
}
