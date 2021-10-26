package com.puhj.electricity.service;

import com.puhj.electricity.model.Spu;
import org.springframework.data.domain.Page;

public interface SearchService {
    Page<Spu> search(String q, Integer page, Integer count);
}
