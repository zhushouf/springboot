package com.huaweisoft.training.restful.http.resource;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huaweisoft.training.restful.http.resource.dto.Body;

//@RestController //所有的方法都以ResponseBody返回
@Controller
@ResponseBody
@RequestMapping("/http")
public class HttpResource {

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @ResponseBody // 在http响应的response body返回结果, 否则结果将会被认为是返回的view的名称
    public String doGet() {
        return "<html>hello</html>";
    }

    // pathVariable可以在任何RequestMethod使用
    // RequestBody只能在有请求body的RequestMethod使用
    // RequestParam则是通过表单提交， 或者通过url参数提交
    @RequestMapping(value = "/post/{pathValue}", method = RequestMethod.POST)
    @ResponseBody // 在http响应的response body返回结果, 否则结果将会被认为是返回的view的名称
    public String doPost(@RequestBody Body bodyValue, @PathVariable String pathValue) {
        // 以JSON的格式返回了数据，这里直接硬编码写一个JSON字符串，实际应用中使用JSON相关的api
        return "{\"bodyValue\":\"" + bodyValue.getBodyValue() + "\", \"pathValue\":\"" + pathValue + "\"}";
    }

    @RequestMapping(value = "/get/redirect", method = RequestMethod.GET)
    public void getRedirect(HttpServletResponse response) throws Exception {
        // Send Redirect将向客户端返回302状态码
        response.sendRedirect("/http/get");
    }

}
