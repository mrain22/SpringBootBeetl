package cn.mrain22.beetl.i18n;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

@Component("localeResolver")
public class MyLocaleResolver implements LocaleResolver {

    /**
     * 决定Locale信息
     * @param request
     * @return
     */
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        //此处是获取请求里的参数，也可以将其放在session中，在这里获取session。
        String language = request.getParameter("l");
        System.out.println("区域信息"+language);
        //获取默认的区域信息
        Locale locale = Locale.getDefault();
        if (!StringUtils.isEmpty(language)){
            //将language（zh_CN）以"_"进行拆分。
            String[] split = language.split("_");
            //Locale(split[0](语言《zh》),split[1]（国家《CN》）)
            locale = new Locale(split[0],split[1]);
        }
        return locale;
    }

    /**
     * 设置Locale信息
     * @param httpServletRequest
     * @param httpServletResponse
     * @param locale
     */
    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
