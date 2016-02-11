package principal.graphics;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

import principal.Constant;
import principal.Game;


public class Window extends JFrame{

	private static final long serialVersionUID = 1L;
	
	private final String title;
	
	public Window(String title, final DrawingSurface ds){
		this.title = title;
		init(ds);
	}
	

	private void init(final DrawingSurface ds) {
		// Agrega el canvas y lo centra con la pantalla
		add(ds, BorderLayout.CENTER);
		setSize(new Dimension(Constant.WIDTH, Constant.HEIGHT));
		
		// Deja de procesar al cerrar la ventana
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Inicia la ventana en el medio 
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		setTitle(title);
		setIconImage(Game.animations.getLife().getImage());
	}

	
	
	
}
