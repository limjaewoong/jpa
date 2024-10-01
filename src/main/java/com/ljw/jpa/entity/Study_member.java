package com.ljw.jpa.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@TableGenerator(name = "MEMBER_SEQ", initialValue = 1, allocationSize = 1)
public class Study_member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "MEMBER_SEQ")
    @Column(name = "member_id", nullable = false, length = 11)
    private int memberId;

    @Column(name = "login_id", length = 20)
    private String loginId;

    @Column(name = "password", length = 100)
    private String password;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "role", length = 100)
    private String role;

    @Column(name = "reg_day", insertable = true, updatable = false)
    @CreationTimestamp
    private LocalDateTime regDay;

    @Column(name = "email", length = 200)
    private String email;

    @OneToMany(mappedBy = "study_member",fetch = FetchType.EAGER)
    private List<Study_record> study_records;

    @Transient
    private String searchLoginId;
}
