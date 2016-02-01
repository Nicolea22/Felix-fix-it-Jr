package principal;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.PriorityQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import principal.entities.Building;

public class Score {

	private String[] scoreNames=new String[4];
	private int[] scorePoints=new int[4];
	
	private JTextField userName;
	private JFrame frame;
	
	
	private boolean asking=false;
	private int bestScore;
	private int actualScore;
	private int MAX_SCORE_AMOUNT = 4;
	
	private static Score score=  new Score();
	
	public Score (){
		readFromFile();
		bestScore = scorePoints[0];
		
		actualScore = 0;
	}
	
	public static Score getScore() {
		return score;
	}
	
	public void readFromFile(){
		
	
        // The name of the file to open.
        String fileName = "src/principal/scores.txt";

        // This will reference one line at a time
        String line = null;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);
           
            int cont = 0;
            while((line = bufferedReader.readLine()) != null) {
            	
    			String []result = line.split(",");
    			scoreNames[cont]=result[0];
    			scorePoints[cont]=Integer.parseInt(result[1]);
    			cont++;
    			
            }     	
            
            // Always close files.
            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println("Unable to open file '" +  fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println("Error reading file '"  + fileName + "'");                  
            // Or we could just do this: 
            // ex.printStackTrace();
        }
    }


	
	public void useFileWriter( ) {
			
		 // The name of the file to open.
        String fileName = "src/principal/scores.txt";
		
        
        //Texto
        String content = "";
        for(int i=0;i< scorePoints.length;i++){
        	content = content + scoreNames[i]+","+scorePoints[i]+"\n";
		}
        System.out.println("ACA ARRANCA" + content);
		 Writer writer = null;
			
		try {
			writer = new FileWriter(fileName);
			
			writer.write(content);
			
		} catch (IOException e) {
			
				  System.err.println("Error writing the file : ");
			
				   e.printStackTrace();
		} finally {
		if (writer != null) {
			try {
				writer.close();
			} catch (IOException e) {
				System.err.println("Error closing the file : ");
				e.printStackTrace();
				}
			}
		}
	}
	
	
		
	public void printScores(){
		for(int i=0;i< scorePoints.length;i++){
			System.out.println(scoreNames[i]+", "+scorePoints[i]);
		}
	}
		
	//Agrega el score a la lista en la pos correcta
	public void add(Integer score, String nombre) {
		for (int i=0;i<MAX_SCORE_AMOUNT;i++){
			if(scorePoints[i]<score){
				int aux = scorePoints[i];
				String auxName=scoreNames[i];
				scorePoints[i]=score;
				scoreNames[i]=nombre;
				score = aux;
				nombre = auxName;
			}
		}
	}
	
	
	
	public void saveScore(){
		asking=true;
		//BOTONERA
		frame = new JFrame();
		JPanel newPanel = new JPanel(new BorderLayout());
		JLabel label = new JLabel("Enter username:");
		userName = new JTextField(20);
		 
		JButton btn = new JButton("Aceptar");
		newPanel.add(label, BorderLayout.NORTH);
		newPanel.add(userName, BorderLayout.CENTER);
		newPanel.setVisible(true);
		
		newPanel.add(btn,BorderLayout.SOUTH);
		frame.add(newPanel,BorderLayout.CENTER);
		frame.setVisible(true);
		frame.setSize(200, 100);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//PONE EL ULTIMO SCORE CON EL NOMBRE INDICADO
				add(actualScore,userName.getText());
				frame.setVisible(false);
				printScores();
				asking=false;
				useFileWriter();
				reset();
			}
		});
	}
	
	public int getActualScore(){
		return actualScore;
	}
	public int getHighScore(){
		return scorePoints[0];
	}
	
	public int getCertainScore(int i){
		return scorePoints[i];
	}
	
	public String getCertainNamee(int i){
		return scoreNames[i];
	}
	
	public boolean askName(){
		return asking;
	}
	
	public void fixWindow(){
		actualScore += 100;
	}
	
	public void nextSector(){
		actualScore += 500;
	}
	
	public void jump(){
		if (actualScore>10){
			actualScore -= 10;
		}else{actualScore=0;}
	}
	
	public void loseHP(){
		if (actualScore>800){
			actualScore -= 800;
		}else{actualScore=0;}
	}
	
	public void reset() {
		actualScore = 0;
	}
	

}
