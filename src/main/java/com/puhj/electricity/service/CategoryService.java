package com.puhj.electricity.service;

import com.puhj.electricity.model.Category;

import java.util.List;
import java.util.Map;

public interface CategoryService {
    Map<Integer, List<Category>> getAll();
}
