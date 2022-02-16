package cn.snowark.destinyhelper.properties;

import lombok.Data;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "bungie.oauth.api")
public class BungieAPIProperties {
    private String key;

    private String clientId;
}
