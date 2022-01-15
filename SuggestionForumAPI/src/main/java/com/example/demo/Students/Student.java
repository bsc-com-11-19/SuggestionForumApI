package com.example.demo.Students;





import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;



@Entity
@Component
@Table(name="commentForum")


public class Student {

    @Id
    @SequenceGenerator(name="studentdatabase_sequence",
    sequenceName = "studentdatabase",allocationSize = 1)



    private Long id;


    private String Name;

    private String RegNo;

    private String Comment;

    private String Email;

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
