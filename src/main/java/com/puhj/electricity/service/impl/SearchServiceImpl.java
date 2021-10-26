package com.puhj.electricity.service.impl;

import com.puhj.electricity.model.Spu;
import com.puhj.electricity.repository.SpuRepository;
import com.puhj.electricity.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SearchServiceImpl implements SearchService {
    @Autowired
    private SpuRepository spuRepository;

    @Override
    public Page<Spu> search(String q, Integer page, Integer count) {
        Pageable paging = PageRequest.of(page, count);
        String likeQ = "%" +q + "%";
        return spuRepository.findByTitleLikeOrSubtitleLike(likeQ,likeQ, paging);
    }
}
