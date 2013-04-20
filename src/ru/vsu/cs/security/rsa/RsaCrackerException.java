package ru.vsu.cs.security.rsa;

/**
 * Created with IntelliJ IDEA.
 * User: Pavel
 * Date: 4/20/13
 * Time: 4:23 PM
 * To change this template use File | Settings | File Templates.
 */
public class RsaCrackerException extends Exception {
    public RsaCrackerException() {
        super();
    }
    public RsaCrackerException(String message) {
        super(message);
    }

    public RsaCrackerException(String message, Throwable cause) {
        super(message, cause);
    }

    public RsaCrackerException(Throwable cause) {
        super(cause);
    }
}
