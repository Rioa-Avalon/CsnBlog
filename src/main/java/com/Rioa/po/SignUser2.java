package com.Rioa.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity(name = "sign2")
@Table
public class SignUser2 {
    @Id
    @GeneratedValue
    @Getter
    @Setter
    private Long id;

    @Column(name = "createTime")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime; //datetime(0) 创建时间

    @NotBlank
    @Getter @Setter private String studentId;

    @NotBlank
    @Getter @Setter private String studentName;

    @Column(name = "qq")
    @Getter @Setter private String qq;

    @Column(name = "email")
    @Getter @Setter private String email;

    @Column(name = "direction")
    @Getter @Setter private String direction; //whether had learned before

    @Getter @Setter private String selfIntro; //Self-introduction
    @NotBlank
    @Getter @Setter private String whyJoin; //why join in CSD
}
