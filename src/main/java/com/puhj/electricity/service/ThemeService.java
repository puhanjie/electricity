package com.puhj.electricity.service;

import com.puhj.electricity.model.Theme;

import java.util.List;
import java.util.Optional;

public interface ThemeService {
    List<com.puhj.electricity.model.Theme> findByNames(List<String> names);

    Optional<Theme> findByName(String name);
}
