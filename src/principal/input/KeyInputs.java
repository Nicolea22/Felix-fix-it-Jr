package principal.input;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import principal.Handler;

public class KeyInputs extends KeyAdapter{

	
	private Handler handler;
	
	public KeyInputs(Handler handler){
		this.handler = handler;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		for(int i = 0; i < handler.objects.size(); i++){
			
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		for(int i = 0; i < handler.objects.size(); i++){
			
		}
	}

	
	
}
