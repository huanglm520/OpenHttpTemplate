package org.open.http.metadata.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;

/**
 * Date: 2021/3/26
 * Time: 17:53
 * Create by HuangLiming
 * Desc:
 */
@Data
public class JacksonConfigurationMetadata {

    private ObjectMapper objectMapper;

    private void initObjectMapper() {
        objectMapper = new ObjectMapper();
    }

    public static JacksonConfigurationMetadata defaults() {
        JacksonConfigurationMetadata metadata = new JacksonConfigurationMetadata();
        metadata.initObjectMapper();
        return metadata;
    }
}
