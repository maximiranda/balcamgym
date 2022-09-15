package com.example.balcamgym.Repositories;

import com.example.balcamgym.Models.ImgFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImgFIleRepository extends JpaRepository<ImgFile, Long> {
}
