package com.puhj.electricity.api.v1;

import com.puhj.electricity.bo.PageCounter;
import com.puhj.electricity.model.Spu;
import com.puhj.electricity.service.SearchService;
import com.puhj.electricity.util.CommonUtil;
import com.puhj.electricity.vo.PagingDozer;
import com.puhj.electricity.vo.SpuSimplifyVO;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@RequestMapping("search")
@RestController
public class SearchController {
    @Autowired
    private SearchService searchService;
    @GetMapping("")
    public PagingDozer<Spu, SpuSimplifyVO> search(@RequestParam String q,
                                                  @RequestParam(defaultValue = "0") Integer start,
                                                  @RequestParam(defaultValue = "10") Integer count) {
        PageCounter counter = CommonUtil.convertToPageParameter(start, count);
        Page<Spu> page = this.searchService.search(q, counter.getPage(), counter.getCount());
        return new PagingDozer<>(page, SpuSimplifyVO.class);
    }
}