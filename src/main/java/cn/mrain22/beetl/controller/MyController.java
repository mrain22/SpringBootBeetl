package cn.mrain22.beetl.controller;

import cn.mrain22.beetl.i18n.JsI18n;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * @author 22
 */
@Controller
public class MyController {

    @GetMapping("/")
    public String main(Model model){
        model.addAttribute("mrain","BeetlTest");
        return "hello.html";
    }
    @GetMapping("/hello")
    public String hello(Model model){
        model.addAttribute("mrain","Beetl_I18n_Test");
        return "i18n.html";
    }


    @Autowired
    private JsI18n jsI18n;

    @GetMapping("i18n")
    @ResponseBody
    public String i18n(ServletWebRequest webRequest){
//        webRequest.getRequest().getSession().setAttribute("i18n","en_Us");
        JSONObject propertyCn = jsI18n.getPropertyCn(webRequest);
        return propertyCn.toString();
    }
}
