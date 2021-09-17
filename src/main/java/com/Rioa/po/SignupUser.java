package com.Rioa.po;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity(name = "t_signupUser")
@Table
public class SignupUser {
    @Id
    @GeneratedValue
    @Getter @Setter private Long id;
    @NotBlank
    @Getter @Setter private String studentId;
    @NotBlank
    @Getter @Setter private String studentName;

    @Column(name = "qq")
    @Getter @Setter private String qq;

    @Column(name = "email")
    @Getter @Setter private String email;
    @Getter @Setter private boolean hadLearn; //whether had learned before
    @Getter @Setter private String selfIntro; //Self-introduction
    @NotBlank
    @Getter @Setter private String whyJoin; //why join in CSD

    public SignupUser() {
    }
}
