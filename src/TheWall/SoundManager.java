package TheWall;
/* 
 * @author: Muhammad Hammad Malik
 */
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.String;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;


public class SoundManager {
	FileInputStream fis;
	BufferedInputStream bis;
	public Player player;
	
	public void playMusic(String path)
	{
		try 
		{
			fis = new FileInputStream(path);
			bis = new BufferedInputStream(fis);
			
			player = new Player(bis);
		}
		catch (FileNotFoundException | JavaLayerException ex)
		{
			
		}
		new Thread()
		{
			@Override
			public void run()
			{
				try 
				{
					player.play();
				}
				catch (JavaLayerException e) {}
			}
		}.start();
	}
	
	public void stopMusic() 
	{
		if(player != null)
		{
			player.close();
		}
	}

}
