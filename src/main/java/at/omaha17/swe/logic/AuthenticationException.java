package at.omaha17.swe.logic;

public class AuthenticationException extends Exception {

    public enum ReasonCode { BLOCKED_USER, DUPLICATE_USER, INVALID_USER, INVALID_PASSWORD }
    private ReasonCode reason;
    private boolean technical_error;

    //Business Exception
    public AuthenticationException(ReasonCode reason) {
        super(reason.toString());
        this.reason = reason;
        this.technical_error = false;
    }

    //Technical Exception
    public AuthenticationException(Throwable source) {
        super(source.getMessage(), source);
        this.technical_error = true;
        this.printStackTrace();
    }

    public ReasonCode getReason() {
        return reason;
    }

    public boolean isTechnical() {
        return technical_error;
    }

}
