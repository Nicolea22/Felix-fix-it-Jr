package principal.entities;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import principal.statemachine.sectorstates.*;
import java.util.ArrayList;


import principal.Constant;
import principal.entities.creatures.Creature;
import principal.entities.windows.Window;
import principal.graphics.Sprite;
import principal.util.ResourceLoader;

public class Building extends Entity{ 
	
	private final static int BUILDING_WIDTH = 315;
	private final static int BUILDING_HEIGHT = 1065;
	
	public final static int POS_X = Constant.WIDTH/2 - BUILDING_WIDTH/2;
	public final static int POS_Y = Constant.HEIGHT - BUILDING_HEIGHT;
	
	private boolean globalMovement = false;
	
	private static Building building =  new Building();
	
	private Sprite sprite; 
	
	private Sector[] sectors;
	private Sector actualSector;
	private Sector nextSector;
	
	

	private Building() {
		super(POS_X, POS_Y);
		sprite = new Sprite(ResourceLoader.getLoader().loadImage("images/building/0.png"));
		
		initSectors();
		initActualSectors();
	}
	
	
	private void initSectors() {
		sectors = new Sector[Constant.SECTORS];
		sectors[0] = new FirstSector();
		sectors[1] = new SecondSector();
		sectors[2] = new ThirdSector();
 	}
	
	
	private void initActualSectors() {
		actualSector = sectors[0];
		nextSector = sectors[1];
	}
	
	public static Building getBuilding() {
		return building;
	}
	
	
	@Override
	public void tick(ArrayList<Creature> creat) {
		
		actualSector.tick();
		if(isChangingSector())
			globalMovement = true;
//		if (changeSector() && actualState < 1) actualState++;
	}
	
	
	public void draw(Graphics2D g) {
		g.drawImage(sprite.getImage(), POS_X, POS_Y, null);
		
		g.setColor(Color.GREEN);
//		g.draw(getLeftBounds());
//		g.draw(getRightBounds());
//		g.draw(getBotBounds());
//		g.draw(getTopBounds());
		
		sectors[0].draw(g);
		sectors[1].draw(g); 
		sectors[2].draw(g);
	}
	/* el tercer sector no esta hecho = index 2 */
	
	
	public void changeSector() {
		if (actualSector instanceof FirstSector) {
			actualSector = sectors[1];
			nextSector = sectors[2];
		}else
			if (actualSector instanceof SecondSector) {
				actualSector = sectors[2];
				nextSector = sectors[2];
			}
		
	}
	
	public void stopGM(){
		globalMovement = false;
	}
	
	
	public boolean getGM(){
		return globalMovement;
	}
	
	
	public Window[] getWindows() {
		return actualSector.getWindows();
	}
	
	
	public Rectangle getBounds(){
		return null;
	}


	@Override
	public Rectangle getTopBounds() {
		return nextSector.getBotBounds();
	}

	
	@Override
	public Rectangle getLeftBounds() {
		return new Rectangle(POS_X + 16, POS_Y, 3, 1000);
	}

	
	@Override
	public Rectangle getRightBounds() {
		return new Rectangle(POS_X + 295, POS_Y, 3, 1000);
	}

	
	@Override
	public Rectangle getBotBounds() {
		return actualSector.getBotBounds();
	}

	
	public String getName() {
		return "Building";
	}

	
	public boolean isChangingSector() {
		return actualSector.changeSector();
	}
	

	public Sector getActualSector() {
		return actualSector;
	}


	public Sector nextSector() {
		return nextSector;
	}

}