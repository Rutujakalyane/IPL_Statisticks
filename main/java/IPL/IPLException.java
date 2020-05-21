package IPL;

public class IPLException extends Exception {

    public enum ExceptionType {
         NO_IPL_DATA, IPL_FILE_INTERNAL_ISSUES, INVALID_COUNTRY,IPL_FILE_PROBLEM;
    }

    public IPLException.ExceptionType type;

    public IPLException(String message, String name) {
        super(message);
        this.type = IPLException.ExceptionType.valueOf(name);
    }

    public IPLException(String message, IPLException.ExceptionType type) {
        super(message);
        this.type = type;
    }

    public IPLException(String message, IPLException.ExceptionType type, Throwable cause) {
        super(message, cause);
        this.type = type;
    }
}

