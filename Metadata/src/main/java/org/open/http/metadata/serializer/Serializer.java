package org.open.http.metadata.serializer;

/**
 * Date: 2021/3/26
 * Time: 17:44
 * Create by HuangLiming
 * Desc: 序列化器，主要用于POST(application/json)中序列化body数据，以及反序列化返回数据
 */
public interface Serializer {

    /**
     * 将一个对象序列化为JSON字符串
     * @param value 待序列化的对象
     * @return 序列化后的JSON字符串
     */
    String doSerialize(Object value);

    /**
     * 将一个JSON字符串反序列化为对象
     * @param json JSON字符串
     * @return 反序列化后的对象
     */
    <T> T deSerialize(String json, Class<T> clazz);
}
