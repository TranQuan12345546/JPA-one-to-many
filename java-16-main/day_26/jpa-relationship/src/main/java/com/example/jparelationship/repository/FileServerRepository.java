package com.example.jparelationship.repository;

import com.example.jparelationship.entity.FileServer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface FileServerRepository extends JpaRepository<FileServer, Integer> {
    List<FileServer> findByUser_Id(Integer id);
}