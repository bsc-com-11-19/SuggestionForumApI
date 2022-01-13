package com.example.demo.Repository;


import com.example.demo.Service.FileDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface FileDBRepository extends JpaRepository<FileDB, String> {

}
