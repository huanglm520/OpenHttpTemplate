package org.open.http.sync.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Date: 2021/3/26
 * Time: 18:33
 * Create by HuangLiming
 * Desc: 标记一个接口为OpenHttpTemplate的代理接口
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface OpenHttpTemplate {
}
