package at.omaha17.swe.logic;

public class WallException extends Exception {

    public enum ReasonCode { }
    private ReasonCode reason;
    private boolean technical_error;

    //Business Exception
    public WallException(ReasonCode reason) {
        super(reason.toString());
        this.reason = reason;
        this.technical_error = false;
    }

    //Technical Exception
    public WallException(Throwable source) {
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
