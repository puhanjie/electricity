package com.puhj.electricity.repository;

import com.puhj.electricity.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    List<Category> findAllByIsRootOrderByIndexAsc(Boolean isRoot);
}
