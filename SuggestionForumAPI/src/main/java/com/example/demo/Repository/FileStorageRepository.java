package com.example.demo.Repository;


import com.example.demo.Service.FileDatabase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface FileStorageRepository extends JpaRepository<FileDatabase, String> {

}
