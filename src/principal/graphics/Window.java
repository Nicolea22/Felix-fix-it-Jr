package principal.graphics;

import java.awt.Dimension;

import javax.swing.JFrame;

import principal.Constant;

public class Window extends JFrame{

	private static final long serialVersionUID = 1L;
	
	private final String title;
	
	public Window(String title, final DrawingSurface ds){
		this.title = title;
		init(ds);
	}

	private void init(final DrawingSurface ds) {
		add(ds);
		setSize(new Dimension(Constant.WIDTH, Constant.HEIGHT));
		
		// Deja de procesar al cerrar la ventana
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setResizable(true);
		setVisible(true);
		setTitle(title);
	}

	
	
	
}
