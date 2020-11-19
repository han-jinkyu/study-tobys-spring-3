package springbook.user.sqlservice;

public class SqlUpdateFailureException extends Exception {
    public SqlUpdateFailureException(String message) {
        super(message);
    }

    public SqlUpdateFailureException(String message, Throwable cause) {
        super(message, cause);
    }
}
