package at.omaha17.oldface.model;

public class Retiree extends User {
    private Wall wall;

    public Retiree(String email, String password, String displayName) {
        super(User.ROLE_RETIREE, email, password,displayName);
        this.wall = new Wall();
    }

    public Wall getWall() {
        return wall;
    }
}
