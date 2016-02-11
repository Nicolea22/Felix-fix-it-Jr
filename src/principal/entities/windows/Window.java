package principal.entities.windows;

import principal.Handler;
import principal.entities.Entity;
import principal.entities.Nicelander;

public abstract class Window extends Entity{

	protected int strokesRequired;
	
	protected boolean hasFlowerPot;
	protected boolean hasRoof;
	
	protected Nicelander nicelander;
	
	public Window(float x, float y) {
		super(x, y);
		nicelander = null;
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
	
	
	public boolean hasFlowerPot(){
		return hasFlowerPot;
	}
	
	public boolean hasRoof(){
		return hasRoof;
	}
		
	
	public void setNicelander(Nicelander nicelander){
		this.nicelander = nicelander;
	}
	
	
	public void removeNicelander(){
		if (nicelander != null){
			Handler.remove(nicelander);
		}
	}

}
	

