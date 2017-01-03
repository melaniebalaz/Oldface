package at.omaha17.swe.logic;

public class TechnicalException extends Exception {

    //Technical Exception
    public TechnicalException(Throwable source) {
        super(source.getMessage(), source);
        this.printStackTrace();
    }
}
