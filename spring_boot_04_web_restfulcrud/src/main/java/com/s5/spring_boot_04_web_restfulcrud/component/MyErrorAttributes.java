package com.s5.spring_boot_04_web_restfulcrud.component;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

/**
 * @Author: Aresong
 * @Date: 2019/4/25 22:39
 * @Version 1.0
 */
//给容器中加入我们自己定义的ErrorAttributes
@Component
public class MyErrorAttributes extends DefaultErrorAttributes {
    //返回的map基石页面和json返回的所有字段
    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
        Map<String, Object> map = super.getErrorAttributes(webRequest, includeStackTrace);
        map.put("company","s5");
        //我们异常处理器携带的数据
        Map<String, Object> ext = (Map<String, Object>)webRequest.getAttribute("ext",0);
        map.put("ext",ext);
        return map;
    }

}
