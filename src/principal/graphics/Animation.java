package principal.graphics;

import java.awt.Image;
import java.util.ArrayList;

import principal.util.ResourceLoader;


public class Animation{
	
	
	private ArrayList<Sprite> sprites;
	private int actualFrame;
	private int framesAmount;
	
	
	public Animation() {
		sprites = new ArrayList<Sprite>();
		actualFrame = 0;
	}
	
	
	public Animation(String[] paths){
		this();
		addFrames(paths);
	}
	
	public Animation(ArrayList<Sprite> sprites) {
		this.sprites = sprites;
	}
	
	public void addFrames(String[] paths) {
		for (int i = 0; i < paths.length; i++){
			addFrame(new Sprite(ResourceLoader.getLoader().loadImage(paths[i])));
    	}
	}

	
	public void addFrame(Sprite frame) {
		sprites.add(frame);
		framesAmount++;
	}

	
	
	public int getIndexAnimation() {
		return actualFrame;
	}
	
	
	public Image getActualFrame() {
		return sprites.get(actualFrame).getImage();
	}
	
	
	public Image getFrame(int i) {
		return sprites.get(i).getImage();
	}
	
	
	public void tick() {
		if (actualFrame == framesAmount - 1)
			actualFrame = -1;
		actualFrame++;
	}
	
	
	public ArrayList<Sprite> getAnimation(){
		return sprites;
	}
	
	
	public Sprite getIanimation(int i){
		return sprites.get(i);
	}
	
	public void setAnimation(ArrayList<Sprite> sprites){
		this.sprites = sprites;
	}
	
	public int getFramesAmount(){
		return framesAmount;
	}
	
}

