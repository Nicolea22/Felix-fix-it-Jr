package principal.entities.windows;

import principal.entities.Entity;

public abstract class Window extends Entity{

	protected boolean broken;
	protected int strokesRequired;
	
	
	public Window(float x, float y) {
		super(x, y);
	}

	public int getStrokesRequired(){
		return strokesRequired;
	}
	
	
	public abstract String getName();
	
	
	public void getFixed() {
		if (isBroken()){
			strokesRequired--;
		}
	}
	
	
	public boolean isBroken() {
		return strokesRequired > 0;
	}
	
}
	

