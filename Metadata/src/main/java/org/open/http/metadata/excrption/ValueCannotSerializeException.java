package org.open.http.metadata.excrption;

/**
 * Date: 2021/3/26
 * Time: 18:08
 * Create by HuangLiming
 * Desc:
 */
public class ValueCannotSerializeException extends RuntimeException {

    public ValueCannotSerializeException(String msg) {
        super(msg);
    }

    public ValueCannotSerializeException(Throwable e) {
        super(e);
    }
}
