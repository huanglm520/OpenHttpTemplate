package org.open.http.utils;

import io.vavr.collection.Array;

import java.lang.annotation.Annotation;

/**
 * Date: 2021/3/26
 * Time: 18:39
 * Create by HuangLiming
 * Desc: 注解工具类
 */
public abstract class AnnotationTools {

    public static boolean hasAnnotation(Class<?> clazz, Class<? extends Annotation> annotationClass) {
        return clazz.isAnnotationPresent(annotationClass);
    }

    public static boolean hasAnnotationDeep(Class<?> clazz, Class<? extends Annotation> annotationClass) {
        return Array.of(clazz.getDeclaredAnnotations())
                .exists(a -> annotationDeepScanner(a, annotationClass));
    }

    private static boolean annotationDeepScanner(Annotation annotation, Class<? extends Annotation> annotationClass) {
        Annotation[] annotations = annotation.getClass().getDeclaredAnnotations();
        for (Annotation a : annotations) {
            if (annotation.getClass().isAnnotationPresent(annotationClass)
                    || annotationClass.equals(a.getClass())
                    || annotationDeepScanner(a, annotationClass)
            ) {
                return true;
            }
        }
        return false;
    }
}
