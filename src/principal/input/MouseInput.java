package principal.input;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseInput extends MouseAdapter{

	private static int x;
	private static int y;
	
	public static boolean leftClick;
	
	@Override
	public void mouseReleased(MouseEvent e) {
		leftClick = false;
	}
	
	
	@Override
	public void mousePressed(MouseEvent e) {		
		x = e.getX();
		y = e.getY();
		
		leftClick = e.getButton() == MouseEvent.BUTTON1;
	}

	
	public static Point getPointer(){
		return new Point(x,y);
	}
	
	
}
