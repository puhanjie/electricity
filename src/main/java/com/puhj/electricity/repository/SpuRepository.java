package com.puhj.electricity.repository;

import com.puhj.electricity.model.Spu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * JPA的方法命名是有规则的，不是乱命名，自定义查询时命名方法需按照规则命名，JPA会根据方法名推断sql语句来执行查询
 */
public interface SpuRepository extends JpaRepository<Spu, Long> {
    Spu findOneById(Long id);

    Page<Spu> findByCategoryIdOrderByCreateTimeDesc(Long cid, Pageable pageable);

    Page<Spu> findByRootCategoryIdOrderByCreateTimeDesc(Long cid, Pageable pageable);

    List<Spu> findByIdIn(List<Long> ids);

    Page<Spu> findByRootCategoryIdOrderByCreateTime(Long cid, Pageable pageable);

    Page<Spu> findByTitleLikeOrSubtitleLike(String keyword, String keyword1, Pageable pageable);
}
