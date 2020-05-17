package IPL;

public class IPLException extends Exception {

    public ExceptionType type;

    public enum ExceptionType { }

    public IPLException(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }
}
