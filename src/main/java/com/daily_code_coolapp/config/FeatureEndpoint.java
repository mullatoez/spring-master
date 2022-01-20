package com.daily_code_coolapp.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.stereotype.Controller;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Controller
@Endpoint(id = "features")
public class FeatureEndpoint {

    private final Map<String, Feature> featureMap =
            new ConcurrentHashMap<>();

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Feature {
        private boolean isEnabled;
    }

    public FeatureEndpoint() {
        featureMap.put("Department", new Feature(true));
        featureMap.put("User", new Feature(false));
        featureMap.put("Authentication", new Feature(false));
    }


    @ReadOperation
    public Map<String, Feature> features() {
        return featureMap;
    }

    @ReadOperation
    public Feature feature(@Selector String featureName) {
        return featureMap.get(featureName);
    }
}