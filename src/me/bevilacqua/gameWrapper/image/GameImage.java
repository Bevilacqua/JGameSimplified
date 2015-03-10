package me.bevilacqua.gameWrapper.image;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class GameImage {
	private BufferedImage image;
	
	public GameImage(String path) {
		try {
			image = ImageIO.read(new File(path));
		} catch (IOException e) {
			System.out.println("JGameSimplified: The image could not be created. This is most likely due to an invalid path location.");
			e.printStackTrace();
		}
	}
	
	/**
	 * Draw the image to the screen.
	 * @param x The x position to draw the image
	 * @param y The y position to draw the image
	 * @param g The graphics object (g)
	 */
	public void draw(int x , int y , Graphics g) {
		g.drawImage(this.image, x, y, null);
	}
	
}
