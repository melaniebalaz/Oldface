package at.omaha17.swe.logic;

public class UserException extends Exception {

    public enum ReasonCode { DUPLICATE_USER, INVALID_USER, INVALID_PASSWORD }
    private ReasonCode reason;
    private boolean technical_error;

    //Business Exception
    public UserException(ReasonCode reason) {
        super(reason.toString());
        this.reason = reason;
        this.technical_error = false;
    }

    //Technical Exception
    public UserException(Throwable source) {
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
