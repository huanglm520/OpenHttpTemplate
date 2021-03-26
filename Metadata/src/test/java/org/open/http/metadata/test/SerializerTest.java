package org.open.http.metadata.test;

import lombok.Data;
import lombok.ToString;
import org.junit.jupiter.api.Test;
import org.open.http.metadata.model.JacksonConfigurationMetadata;
import org.open.http.metadata.serializer.JacksonMapperSerializer;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 * Date: 2021/3/26
 * Time: 17:52
 * Create by HuangLiming
 * Desc:
 */
public class SerializerTest {

    @Test
    public void doSerializerTest() {
        JacksonConfigurationMetadata metadata = JacksonConfigurationMetadata.defaults();
        JacksonMapperSerializer serializer = JacksonMapperSerializer.withMetadata(metadata);
        TestModel testModel = new TestModel();
        testModel.v1 = "v1";
        testModel.v2 = 100;
        testModel.v3 = Arrays.asList("q", "w", "e");
        String s = serializer.doSerialize(testModel);
        System.out.println(s);
        TestModel model = serializer.deSerialize(s, TestModel.class);
        System.out.println(model);
    }

    @ToString
    @Data
    static class TestModel {
        String v1;
        int v2;
        List<String> v3;
    }
}
