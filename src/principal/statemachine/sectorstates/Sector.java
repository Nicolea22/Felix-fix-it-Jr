package principal.statemachine.sectorstates;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;

import principal.Constant;
import principal.entities.Building;
import principal.entities.windows.Window;

public abstract class Sector {
	
	protected final static int POS_X = Building.POS_X;
	protected final static int POS_Y = Building.POS_Y;
	
	protected final int COL = 5;
	protected final int ROW = 3;
	
	protected Window[] windows;
	protected ArrayList<Window> brokenWindows;
	
	public Sector() {
		brokenWindows = new ArrayList<Window>();
	}
	
	public abstract void tick();
	public abstract void draw(Graphics2D g);
	
	public abstract boolean  hasBirds();
	public abstract boolean  hasNicelanders();
	public abstract boolean  hasObstacles();
	
	public abstract Rectangle getTopBounds();
	public abstract Rectangle getBotBounds();
	
	public Window[] getWindows() {
		return windows;
	}
	
	public int brokenWinsAmount() {
		return brokenWindows.size();
	}
	
	public boolean changeSector() {
		return brokenWindows.size() <= 0;
	}

	
	
}
