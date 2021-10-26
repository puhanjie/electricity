package com.puhj.electricity.core.hack;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.lang.reflect.Method;

/**
 * 截取被调用的Controll的包路径下的子包路径，自动填充到每个Controll的RequestMapping路径前面
 * 如：请求RequestMapping路径为v1/banner的接口，只需RequestMapping的值写为/banner，本文件中的类会自动把前面的v1补上,
 * 因为配置文件中设置了接口Controller的跟路径，该类会自动把跟路径下的子路径名自动补全到请求url的前面
 * （该类由com.puhj.electricity.core.configuration.AutoPrefixConfiguration类调用执行）
 */
public class AutoPrefixUrlMapping extends RequestMappingHandlerMapping {
    @Value("${electricity.api-package}")
    private String apiPackagePath;

    @Override
    protected RequestMappingInfo getMappingForMethod(Method method, Class<?> handlerType) {
        RequestMappingInfo mappingInfo = super.getMappingForMethod(method, handlerType);
        if (mappingInfo != null) {
            String prefix = this.getPrefix(handlerType);
            return RequestMappingInfo.paths(prefix).build().combine(mappingInfo);
        }
        return mappingInfo;
    }

    private String getPrefix(Class<?> handlerType) {
        String packageName = handlerType.getPackageName();
        String dotPath = packageName.replaceAll(this.apiPackagePath, "");
        return dotPath.replace(".", "/");
    }
}
