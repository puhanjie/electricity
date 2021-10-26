package com.puhj.electricity.vo;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

/**
 * 属性精简类
 * 说明：把数据库查询出来的所有记录的属性进行精简，赋值给vo对象传到前端
 * @param <T>
 * @param <K>
 */
public class PagingDozer<T, K> extends Paging {
    public PagingDozer(Page<T> pageT, Class<K> classK) {
        this.initPageParamters(pageT);

        List<T> tList = pageT.getContent();
        Mapper mapper = DozerBeanMapperBuilder.buildDefault();
        List<K> voList = new ArrayList<>();
        tList.forEach(t -> {
            K vo = mapper.map(t, classK);
            voList.add(vo);
        });

        this.setItems(voList);
    }
}
