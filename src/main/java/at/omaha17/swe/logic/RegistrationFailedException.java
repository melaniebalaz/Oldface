package at.omaha17.swe.logic;

public class RegistrationFailedException extends Exception {

    public enum ReasonCode { EXISTING_USER, TECHNICAL_ERROR }
    private ReasonCode reason;

    public RegistrationFailedException(ReasonCode reason) {
        super(reason.toString());
        this.reason = reason;
    }

    public RegistrationFailedException(Throwable source) {
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
