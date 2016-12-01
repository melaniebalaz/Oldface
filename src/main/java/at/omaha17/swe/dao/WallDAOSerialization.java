package at.omaha17.swe.dao;

import at.omaha17.swe.model.Wall;
import java.util.Vector;

public class WallDAOSerialization implements WallDAO {

    private String filename;

    public WallDAOSerialization(String filename) {
        this.filename = filename;
    }

    public void saveWall(Wall wall) {

    }

    public void deleteWall(Wall wall) throws WallNotFoundException {

    }

    public Wall getWallByUsername(String username) throws WallNotFoundException {
        return null;
    }

    public Vector<Wall> getWallList() {
        return null;
    }
}
