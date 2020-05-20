package IPL;

public class IPLException extends Exception {
    public enum ExceptionType {
    FILE_PROBLEM,NO_CRICKET_DATA, CSV_FILE_INTERNAL_ISSUES
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
