package at.omaha17.swe.model;

import java.util.Calendar;

public class Senior extends User {
    public enum SeniorStatus { ACTIVE, BLOCKED }

    private SeniorStatus status;
    private String displayName;
    private Calendar birthDate;
	private int wallid; //indirect wall relation (due to DAO separation)

    public Senior(String username, String password) {
    	super(User.ROLE_SENIOR, username, password);
        this.setStatus(SeniorStatus.ACTIVE);
//      this.displayName = "";
//      this.birthDate = null;
    }

    public SeniorStatus getStatus() {
        return status;
    }

    public String getDisplayName() {
        return displayName;
    }

    public Calendar getBirthDate() {
        return birthDate;
    }

    public void setStatus(SeniorStatus status) {
        this.status = status;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public void setBirthDate(Calendar birthDate) {
        this.birthDate = birthDate;
    }

    /*
    public Wall getWall() {
        return wall;
    }*/

}
