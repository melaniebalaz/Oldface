package at.omaha17.swe.logic;

public class RegistrationFailedException extends Exception {

    public enum ReasonCode { EXISTING_USER, UNKNOWN }
    private ReasonCode reason;

    public RegistrationFailedException(ReasonCode reason) {
        super(reason.toString());
        this.reason = reason;
    }

    public RegistrationFailedException(ReasonCode reason, Throwable source) {
        super(reason.toString(), source);
    }

    public ReasonCode getReason() {
        return reason;
    }
}
