package principal.entities.windows;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;
import principal.entities.creatures.Creature;
import principal.graphics.Sprite;
import principal.util.Random;
import principal.util.ResourceLoader;

public class Semicircular extends Window{
	
	private Sprite[] images;
	private int state;
	
	private int strokes;
	
	
	public Semicircular(float x, float y) {
		super(x, y);
		
		loadImages();
		initState();
		
		width = images[0].getImage().getWidth(null);
		height = images[0].getImage().getHeight(null);
	}
	
	
	private void loadImages() {
		images = new Sprite[8];
		for (int i = 0; i < images.length; i++){
			images[i] = new Sprite(ResourceLoader.getLoader().
					loadImage("images/window/semicircular/bigwindow/"+ i+".png"));
		}
	}
	
	
	private void initState() {
//		strokesRequired = Random.value(0, 16);
		strokesRequired = 1;
		if (strokesRequired >= 12) state = 4;
		if (strokesRequired < 12 && strokesRequired >= 8) state = 3;
		if (strokesRequired < 8 && strokesRequired >= 4) state = 2;
		if (strokesRequired < 4 && strokesRequired >= 1) state = 1;
		if (strokesRequired <= 0) state = 0;
	}
	
	
	@Override
	public void tick(ArrayList<Creature> objects) {	
		broken = strokesRequired > 0;
		if (strokes >= 4 && state > 0) {
			state--;
			strokes = 0;
		}
	}
	
	
	@Override
	public void draw(Graphics2D g) {
		g.drawImage(images[state].getImage(), (int)getX(), (int)getY(), null);
//		g.draw(getBotBounds());
//		g.draw(getBounds());
	}


	@Override
	public Rectangle getTopBounds() {
		return null;
	}

	@Override
	public Rectangle getLeftBounds() {
		return null;
	}

	@Override
	public Rectangle getRightBounds() {
		return null;
	}

	@Override
	public Rectangle getBotBounds() {
		return new Rectangle((int)getX()  , (int)getY() + 51, 70, 5);
	}

	public String getName() {
		return "Semicircular";
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle((int)getX() + 5, (int)getY(), width - 11, height);
	}

	@Override
	public void getFixed(){
		if (isBroken()){
			strokesRequired--;
		}
		strokes++;
	}
	
	
}
