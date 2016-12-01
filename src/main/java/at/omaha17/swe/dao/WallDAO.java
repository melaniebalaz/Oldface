package at.omaha17.swe.dao;

import java.util.Vector;
import at.omaha17.swe.model.Wall;

public interface WallDAO {
    public void saveWall(Wall wall);
    public void deleteWall(Wall wall) throws WallNotFoundException;
    public Wall getWallByUsername(String username) throws WallNotFoundException;
    public Vector<Wall> getWallList();
}
