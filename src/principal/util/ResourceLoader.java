package principal.util;

import java.awt.Image;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

// Carga las imagenes, hicimos esta clase aparte en caso de que se pueda subir cualquier tipo de archivos media
// como por ejemplo sonidos que tambien habria un metodo para subir sonidos en esta clase.

public class ResourceLoader {

	private ResourceLoader(){}
	
	private static  ResourceLoader resourceLoader = new ResourceLoader();
	private Image image;
		
	public Image loadImage(String path){
		URL imgUrl = getClass().getClassLoader().getResource(path);
		
		if (imgUrl == null){
			System.err.println("No se encuentra el archivo" + path);	
		}else{
			try{
				image = ImageIO.read(imgUrl);
			}catch(IOException ex){
				ex.printStackTrace();
			}
		}
		return image;
	}
	
	
	public static ResourceLoader getLoader(){
		return resourceLoader;
	}
	
}
