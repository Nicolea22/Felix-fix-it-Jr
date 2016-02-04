package principal.entities;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import principal.statemachine.gamestate.GameManager;
import principal.statemachine.sectorstates.*;

import java.util.ArrayList;








import principal.Constant;
import principal.Handler;
import principal.Score;
import principal.entities.creatures.Bird;
import principal.entities.creatures.Creature;
import principal.entities.windows.Window;
import principal.graphics.Sprite;
import principal.util.Random;
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
	private int actualSector;
	
	
	private Building() {
		super(POS_X, POS_Y);
		sprite = new Sprite(ResourceLoader.getLoader().loadImage("images/building/0.png"));
		
		initSectors();
		initActualSectors();
	}
	
	
	public void initSectors() {
		sectors = new Sector[Constant.SECTORS];
		sectors[0] = new FirstSector();
		sectors[1] = new SecondSector();
		sectors[2] = new ThirdSector();
		sectors[3] = new FourthSector();
 	}
	
	
	public void initActualSectors() {
		actualSector = 0;
	}
	
	public static Building getBuilding() {
		return building;
	}
	
	
	@Override
	public void tick(ArrayList<Creature> creat, long beforeTime) {
		sectors[actualSector].tick(beforeTime);
		if(isChangingSector()) globalMovement = true;		
//		if (changeSector() && actualState < 1) actualState++;
	}

	public void draw(Graphics2D g, long time) {
		g.drawImage(sprite.getImage(), POS_X, POS_Y, null);
		
		g.setColor(Color.GREEN);
		if (GameManager.showHitBox){
			g.draw(getLeftBounds());
			g.draw(getRightBounds());
			g.draw(getBotBounds());
			g.draw(getTopBounds());
		}
		
		
		sectors[0].draw(g, time);
		sectors[1].draw(g, time); 
		sectors[2].draw(g, time);
		sectors[3].draw(g, time);
	}
	/* el tercer sector no esta hecho = index 2 */
	
	
	public void changeSector() {
		actualSector++;
		Score.getScore().nextSector();
	}
	
	public void stopGM(){
		globalMovement = false;
	}
	
	
	public boolean getGM(){
		return globalMovement;
	}
	
	
	public Window[] getWindows() {
		return sectors[actualSector].getWindows();
	}
	
	
	public Rectangle getBounds(){
		return null;
	}


	@Override
	public Rectangle getTopBounds() {
		return sectors[actualSector].getTopBounds();
	}

	
	@Override
	public Rectangle getLeftBounds() {
		return new Rectangle(POS_X + 11, POS_Y, 3, 1000);
	}

	
	@Override
	public Rectangle getRightBounds() {
		return new Rectangle(POS_X + 298, POS_Y, 3, 1000);
	}

	
	@Override
	public Rectangle getBotBounds() {
		return sectors[actualSector].getBotBounds();
	}

	
	public String getName() {
		return "Building";
	}

	
	public boolean isChangingSector() {
		return sectors[actualSector].changeSector();
	}
	

	public Sector getActualSector() {
		return sectors[actualSector];
	}


	
}