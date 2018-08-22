package cn.mrain22.beetl.i18n;


import org.beetl.core.Context;
import org.beetl.core.Function;
import org.beetl.core.exception.BeetlException;
import org.springframework.web.servlet.support.RequestContext;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 22
 * 这里实现的是beetl的Function。
 */
public class BeetlI18n implements Function {

    @Override
    public Object call(Object[] obj, Context context) {
        if(obj.length < 1) {
            try {
                throw new BeetlException("调用Beetl方法获取国际化信息时 参数列表传递错误");
            } catch (BeetlException e) {
                e.printStackTrace();
                return "调用Beetl方法获取国际化信息时 参数列表传递错误";
            }
        }
        HttpServletRequest request = (HttpServletRequest) context.getGlobal("request");
        RequestContext requestContext = new RequestContext(request);
        String message = "";
        try {
            message = requestContext.getMessage((String)obj[0]);
            if("".equals(message) && obj.length > 1){
                message = (String)obj[(int)(1+Math.random()*(obj.length-1))];
            }
        } catch (Exception e) {
            e.printStackTrace();
            if(obj.length > 1) {
                message = (String)obj[(int)(1+Math.random()*(obj.length-1))];
            }
        }
        return message;
    }
}
