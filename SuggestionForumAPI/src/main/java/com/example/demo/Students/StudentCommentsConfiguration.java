package com.example.demo.Students;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentCommentsConfiguration {
    @Bean
    CommandLineRunner commandLineRunner(UserRepository repository){
        return args -> {


        Student Justice=new Student(
                1L,
                "Justice kasawala",
                "bsc-com-11-19",
                "The class was awesome but the lecture was too fast",
                "bsc-com-11-19@unima.ac.mw",
                LocalDate.of(1963, Month.JANUARY,6));
            Student Benson=new Student(
                    2L,
                    "benson",
                    "bsc-geo-12",
                    "OOOOsh the class was awesome.Nice presentation sir!!",
                    "bsc-geo-11-19@unima.ac.mw",
                    LocalDate.of(2000, Month.JANUARY,7)
             );

        Student sparrow=new Student(
                3L,
                "Sparrow",
                "bsc-geo-21-19",
                "I enjoyed the class",
                "bsc-geo-21@unima.ac.mw",
                LocalDate.of(1999, Month.JANUARY,6)
        );

            Student happy=new Student(
                    4L,
                    "happy",
                    "bsc-hon-21-19",
                    "The content was too big but the lecture has to provide us with lecture notes",
                    "bsc-hon-21-19@unima.ac.mw",
                    LocalDate.of(2000, Month.JANUARY,6));
            repository.saveAll(List.of(Justice,sparrow,Benson,happy));
        };
    }
}
