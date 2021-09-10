package com.Rioa.po;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "t_signupUser")
@Table
public class SignupUser {
    @Id
    @GeneratedValue
    @Getter @Setter private Long id;
    @Getter @Setter private String studentId;
    @Getter @Setter private String studentName;
    @Getter @Setter private boolean hadLearn; //whether had learned before
    @Getter @Setter private String selfIntro; //Self-introduction
    @Getter @Setter private String whyJoin; //why join in CSD
    public SignupUser() {
    }
}
