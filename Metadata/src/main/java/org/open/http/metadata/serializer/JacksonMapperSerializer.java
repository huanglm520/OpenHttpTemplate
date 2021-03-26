package org.open.http.metadata.serializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.open.http.metadata.excrption.ValueCannotSerializeException;
import org.open.http.metadata.model.JacksonConfigurationMetadata;

/**
 * Date: 2021/3/26
 * Time: 17:48
 * Create by HuangLiming
 * Desc: 使用Jackson实现的序列化器
 * 该序列化器为默认实现
 */
@AllArgsConstructor(staticName = "withMetadata")
@Slf4j
public class JacksonMapperSerializer implements Serializer {

    private final JacksonConfigurationMetadata jacksonConfigurationMetadata;

    @Override
    public String doSerialize(Object value) {
        ObjectMapper mapper = jacksonConfigurationMetadata.getObjectMapper();
        try {
            if (log.isDebugEnabled()) {
                log.debug("Serializing object for type: '{}'", value.getClass().getName());
            }
            return mapper.writeValueAsString(value);
        } catch (JsonProcessingException e) {
            throw new ValueCannotSerializeException(e);
        }
    }

    @Override
    public <T> T deSerialize(String json, Class<T> clazz) {
        ObjectMapper mapper = jacksonConfigurationMetadata.getObjectMapper();
        try {
            if (log.isDebugEnabled()) {
                log.debug("Deserializing json as type: '{}'", clazz.getName());
            }
            return mapper.readValue(json, clazz);
        } catch (JsonProcessingException e) {
            throw new ValueCannotSerializeException(e);
        }
    }
}
