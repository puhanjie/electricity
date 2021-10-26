package com.puhj.electricity.service.impl;

import com.puhj.electricity.model.GridCategory;
import com.puhj.electricity.repository.GridCategoryRepository;
import com.puhj.electricity.service.GridCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GridCategoryServiceImpl implements GridCategoryService {
    @Autowired
    private GridCategoryRepository gridCategoryRepository;

    @Override
    public List<GridCategory> getGridCategoryList() {
        return gridCategoryRepository.findAll();
    }
}
