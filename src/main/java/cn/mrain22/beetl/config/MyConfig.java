package cn.mrain22.beetl.config;

import cn.mrain22.beetl.i18n.BeetlI18n;
import com.ibeetl.starter.BeetlTemplateCustomize;
import org.beetl.core.GroupTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 22
 */
@Configuration
public class MyConfig {
    @Bean
    public BeetlTemplateCustomize beetlTemplateCustomize(){
        return new BeetlTemplateCustomize(){
            @Override
            public void customize(GroupTemplate groupTemplate){
                groupTemplate.registerFunction("i18n", new BeetlI18n());
            }
        };
    }

//    @Bean
//    public LocaleResolver localeResolver(){
//        return new MyLocaleResolver();
//    }
}
