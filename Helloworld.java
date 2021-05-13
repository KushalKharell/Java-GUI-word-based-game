import javax.sound.sampled.*;
import java.io.*;
public class Helloworld{
	public static void main(String[] args){
		System.out.println("Helloworld");

	}
	public static void backgroundMusic(){
        try{
      
           File musicPath = new File("backgroundMusic.wav");

           AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
           Clip clip = AudioSystem.getClip();
           clip.open(audioInput);
           clip.start();
           //JOptionPane.showMessageDialog(null, "Press OK to stop Playing");
        } catch (Exception e){
            e.printStackTrace();
        }

    }
    
}
