package at.omaha17.swe.logic;

public class AuthenticationFailedException extends Exception {

    public enum ReasonCode { INVALID_USER, INVALID_PASSWORD, UNKNOWN }
    private ReasonCode reason;

    public AuthenticationFailedException(ReasonCode reason) {
        super(reason.toString());
        this.reason = reason;
    }

    public AuthenticationFailedException(ReasonCode reason, Throwable source) {
        super(reason.toString(), source);
    }

    public ReasonCode getReason() {
        return reason;
    }

}
