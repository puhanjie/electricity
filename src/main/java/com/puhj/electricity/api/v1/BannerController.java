package com.puhj.electricity.api.v1;

import com.puhj.electricity.exception.http.NotFoundException;
import com.puhj.electricity.model.Banner;
import com.puhj.electricity.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;

// @Validated作用在类上开启参数校验，作用在方法参数上则是开启该对象参数的校验，对象参数校验在bead对象类中
@RestController("bannerController")
@RequestMapping("/banner")
@Validated
public class BannerController {
    @Autowired
    private BannerService bannerService;

    @GetMapping("/name/{name}")
    public Banner getByName(@PathVariable @NotBlank String name) {
        Banner banner = this.bannerService.getByName(name);
        if (banner == null) {
            throw new NotFoundException(30005);
        }
        return banner;
    }
}
