package cn.snowark.destinyhelper.init;

import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.spring.SpringUtil;
import cn.snowark.destinyhelper.DestinyHelperApplication;
import cn.snowark.destinyhelper.properties.BungieAPIProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class InitCheck implements ApplicationContextAware {
    @Autowired
    BungieAPIProperties bungieAPIProperties;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        checkBungieApi();
    }

    private void checkBungieApi() {
        log.info("Checking if API configuration exits...");
        if (StrUtil.isBlankIfStr(bungieAPIProperties.getClientId()) || StrUtil.isBlankIfStr(bungieAPIProperties.getKey())) {
            log.error("Please specify Bungie API key and client id in properties.");
            SpringApplication.exit(SpringUtil.getApplicationContext(), () -> -1);
            System.exit(-1);
        }
    }
}
