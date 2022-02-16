package cn.snowark.destinyhelper.util;

import cn.snowark.destinyhelper.properties.BungieAPIProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

public class BungieAPIRestTemplate extends RestTemplate {

    public BungieAPIRestTemplate() {
        super();
        this.getInterceptors().add(new CustomHeaderInterceptor());
    }

    @Component
    static class CustomHeaderInterceptor implements ClientHttpRequestInterceptor {
        @Autowired
        BungieAPIProperties bungieAPIProperties;

        @Override
        public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
            request.getHeaders().set("apikey", bungieAPIProperties.getKey());
            request.getHeaders().set("client_id", bungieAPIProperties.getClientId());
            return execution.execute(request, body);
        }
    }
}
