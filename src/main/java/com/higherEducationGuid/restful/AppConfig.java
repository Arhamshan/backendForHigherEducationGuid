package com.higherEducationGuid.restful;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by I.S.M. ARHAM on 5/19/2017.
 */

@ConfigurationProperties(prefix = "app")
@Component
public class AppConfig {
    private String secret;

    private long tokenValidityInSeconds;

    public String getSecret() {
        return this.secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public long getTokenValidityInSeconds() {
        return this.tokenValidityInSeconds;
    }

    public void setTokenValidityInSeconds(long tokenValidityInSeconds) {
        this.tokenValidityInSeconds = tokenValidityInSeconds;
    }

}
