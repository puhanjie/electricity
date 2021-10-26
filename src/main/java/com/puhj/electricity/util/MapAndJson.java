package com.puhj.electricity.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.puhj.electricity.exception.http.ServerErrorException;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.HashMap;
import java.util.Map;

/**
 * @Converter注解让JPA在处理对象序列化和反序列化时候会自动调用该类
 * 若数据库字段有存储json字符串，那JPA读取数据转为java对象时，会把json字段通过调用该类转为java对象里面对应Map类型的属性对象；
 * 若是往数据库写数据，同理也会将java对象里面Map类型的属性通过调用该方法转为数据库的json字段；
 * 注意，要能识别是java对象里面的哪个属性，必须在对象的属性上加上@Convert(converter = MapAndJson.class)注解
 */
@Converter
public class MapAndJson implements AttributeConverter<Map<String, Object>, String> {

    @Autowired
    private ObjectMapper mapper;

    @Override
    public String convertToDatabaseColumn(Map<String, Object> stringObjectMap) {
        try {
            return mapper.writeValueAsString(stringObjectMap);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServerErrorException(9999);
        }
    }

    @Override
    public Map<String, Object> convertToEntityAttribute(String s) {
        try {
            Map<String, Object> t = mapper.readValue(s, HashMap.class);
            return t;
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServerErrorException(9999);
        }
    }
}
