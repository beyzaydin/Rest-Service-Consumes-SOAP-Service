package com.example.demo.repository;

import com.example.demo.Entity.ImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository  extends JpaRepository<ImageEntity, Integer>, QuerydslPredicateExecutor {
}
