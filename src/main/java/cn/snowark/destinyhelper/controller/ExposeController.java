package cn.snowark.destinyhelper.controller;

import cn.snowark.destinyhelper.properties.BungieAPIProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExposeController {
    @Autowired
    BungieAPIProperties bungieAPIProperties;

    @GetMapping("apiInfo")
    public String apiInfo() {
        return "APIKEY:" + bungieAPIProperties.getKey() + " " + "ClientId:" + bungieAPIProperties.getClientId();
    }
}
