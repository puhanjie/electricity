package com.puhj.electricity.repository;

import com.puhj.electricity.model.GridCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GridCategoryRepository extends JpaRepository<GridCategory, Long> {
}
