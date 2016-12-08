package at.omaha17.swe.logic;

public class AuthenticationFailedException extends Exception {

    public enum ReasonCode { INVALID_USER, INVALID_PASSWORD, TECHNICAL_ERROR }
    private ReasonCode reason;

    public AuthenticationFailedException(ReasonCode reason) {
        super(reason.toString());
        this.reason = reason;
    }

    public AuthenticationFailedException(Throwable source) {
        super(source.getMessage(), source);
        this.reason = ReasonCode.TECHNICAL_ERROR;
    }

    public ReasonCode getReason() {
        return reason;
    }

    public boolean isTechnical() {
        return this.reason.equals(ReasonCode.TECHNICAL_ERROR);
    }

}
