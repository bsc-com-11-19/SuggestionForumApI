package com.example.demo.Students;




import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;





@Entity
@Component
@Table(name="CommentForum")
@SecondaryTable(name="pastPapers",pkJoinColumns = @PrimaryKeyJoinColumn(name="Id",referencedColumnName = "id"))

public class Student {
    @Id


@Column(name="id")
    private Long id;
    @Column(name="name")
    private String Name;
    @Column(name="regNo")
    private String RegNo;
    @Column(name="Comment")
    private String Comment;
    @Column(name="Email")
    private String Email;
    @Column(name="Dob")
    private LocalDate Dob;


    @Transient
    private Integer age;


    public Student() {
    }

    public Student(Long id, String name, String regNo, String comment, String email, LocalDate dob) {
        this.id = id;
        Name = name;
        RegNo = regNo;
        Comment = comment;
        Email = email;
        Dob = dob;

    }

    public Student(String name, String regNo, String comment, String email, LocalDate dob) {
        Name = name;
        RegNo = regNo;
        Comment = comment;
        Email = email;
        Dob = dob;

    }

    public LocalDate getDob() {
        return Dob;
    }

    public void setDob(LocalDate dob) {
        Dob = dob;
    }

    public Integer getAge() {

        return Period.between(this.Dob,LocalDate.now()).getYears() ;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getRegNo() {
        return RegNo;
    }

    public void setRegNo(String regNo) {
        RegNo = regNo;
    }

    public String getComment() {
        return Comment;
    }

    public void setComment(String comment) {
        Comment = comment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", Name='" + Name + '\'' +
                ", RegNo='" + RegNo + '\'' +
                ", Comment='" + Comment + '\'' +
                ", Email='" + Email + '\'' +
                ", Dob=" + Dob +
                ", age=" + age +
                '}';
    }
}
