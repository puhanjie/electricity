package com.puhj.electricity.service.impl;

import com.puhj.electricity.model.Spu;
import com.puhj.electricity.repository.SpuRepository;
import com.puhj.electricity.service.SpuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpuServiceImpl implements SpuService {
    @Autowired
    private SpuRepository spuRepository;

    @Override
    public Spu getSpu(Long id) {
        return this.spuRepository.findOneById(id);
    }

    @Override
    public Page<Spu> getLatestPagingSpu(Integer pageNum, Integer size) {
//        分页操作PageRequest.of()
        Pageable page = PageRequest.of(pageNum, size, Sort.by("createTime").descending());
        return this.spuRepository.findAll(page);
    }

    @Override
    public List<Spu> getByIDList(List<Long> idList) {
        return this.spuRepository.findByIdIn(idList);
    }

    @Override
    public Page<Spu> getByCategory(Long cid, Boolean isRoot, Integer pageNum, Integer size) {
        Pageable page = PageRequest.of(pageNum, size);
        if (isRoot) {
            return this.spuRepository.findByCategoryIdOrderByCreateTimeDesc(cid, page);
        } else {
            return this.spuRepository.findByRootCategoryIdOrderByCreateTimeDesc(cid, page);
        }
    }
}
