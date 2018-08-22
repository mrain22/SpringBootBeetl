package cn.mrain22.beetl.i18n;

import com.alibaba.fastjson.JSONObject;
import net.sf.ehcache.util.PropertyUtil;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.ServletWebRequest;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;

/**
 * @author 22
 */
@Component
public class JsI18n {
    public JSONObject getPropertyCn(ServletWebRequest webRequest) {
        Properties prop = new Properties();
        InputStream in = null;
        JSONObject job = new JSONObject();
        try {
            //在设置i18n时必须设置成--》zh_CN、en_US的这种形式。
            String i18n = (String) webRequest.getRequest().getSession().getAttribute("i18n");
            if (StringUtils.isEmpty(i18n)){
                in = PropertyUtil.class.getResourceAsStream("/i18n/test.properties");
            }else {
                in = PropertyUtil.class.getResourceAsStream("/i18n/test_"+i18n+".properties");
                //in = getClass().getResourceAsStream("/i18n/test_zh_CN.properties");

            }
            //装载配置文件
//            if ("cn".equals(language)) {
//                in = getClass().getResourceAsStream("/i18n/test_zh_CN.properties");
//            } else if ("en".equals(language)) {
//                in = getClass().getResourceAsStream("/i18n/test_en_US.properties");
//            }
            prop.load(in);
            //得到配置文件的名字
            Enumeration en = prop.propertyNames();
            while (en.hasMoreElements()) {
                String strKey = (String) en.nextElement();
                String strValue = prop.getProperty(strKey);
                //以键值对的方式保存返回。
                job.put(strKey,strValue);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //返回获取的值
        return job;
    }
}
