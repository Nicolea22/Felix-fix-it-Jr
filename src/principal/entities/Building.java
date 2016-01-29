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
	
	private static Building building =  new Building();
	
	private Sprite sprite; 
	
	private Sector[] sectors;
	private int state;
	
	private boolean changingSector;

	private Building() {
		super(POS_X, POS_Y);
		sprite = new Sprite(ResourceLoader.getLoader().loadImage("images/building/0.png"));
		changingSector = false;
		initSectors();
		state = 0;
	}
	
	
	private void initSectors() {
		sectors = new Sector[Constant.SECTORS];
		sectors[0] = new FirstSector();
		sectors[1] = new SecondSector();
		sectors[2] = new ThirdSector();
 	}
	
	
	public static Building getBuilding() {
		return building;
	}
	
	
	@Override
	public void tick(ArrayList<Creature> creat) {
		sectors[state].tick();
		if (changeSector() && state < 3) state++;
	}
	
	
	public void draw(Graphics2D g) {
		g.drawImage(sprite.getImage(), POS_X, POS_Y, null);
		
		g.setColor(Color.GREEN);
//		g.draw(getLeftBounds());
//		g.draw(getRightBounds());
		g.draw(getBotBounds());
		
		if (sectors[state] instanceof FirstSector) 
			sectors[0].draw(g);
		
		sectors[1].draw(g);
		
		if (sectors[state] instanceof ThirdSector) 
			sectors[2].draw(g);
	}
	
	
	
	public boolean changeSector() {
		return sectors[state].changeSector();
	}
	
	
	

	public Window[] getWindows() {
		return sectors[state].getWindows();
	}
	
	
	public Rectangle getBounds(){
		return null;
	}


	@Override
	public Rectangle getTopBounds() {
		return null;
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
		return sectors[state].getBotBounds();
	}

	
	public String getName() {
		System.out.println("hola");
		return "Building";
	}

	public boolean isChangingSector() {
		return changingSector;
	}
	
	
	public void setChangingSector(boolean changingSector){
		this.changingSector = changingSector;
	}

}