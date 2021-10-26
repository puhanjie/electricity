package com.puhj.electricity.service;

import com.puhj.electricity.model.Spu;
import org.springframework.data.domain.Page;

import java.util.List;

public interface SpuService {
    Spu getSpu(Long id);

    Page<Spu> getLatestPagingSpu(Integer pageNum, Integer size);

    List<Spu> getByIDList(List<Long> idList);

    Page<Spu> getByCategory(Long cid, Boolean isRoot, Integer pageNum, Integer size);
}
