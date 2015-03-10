package me.bevilacqua.gameWrapper.image;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class AnimatedGameImage {
	private float updateTime;
	private List<GameImage> images = new ArrayList<GameImage>();
	
	private float elapsedTime;
	private int animationIndex = 0;
	
	/**
	 * Create a game image that updates every x milliseconds.
	 * @param updateTime Time per animation image in milliseconds.
	 * @param paths List of paths to images.
	 */
	public AnimatedGameImage(float updateTime , String ... paths) {
		this.updateTime = updateTime;
		for(String path : paths) {
			images.add(new GameImage(path));
		}
	}
	
	/**
	 * Create a game image that updates every x milliseconds.
	 * @param updateTime Time per animation image in milliseconds.
	 * @param images List of images used.
	 */
	public AnimatedGameImage(float updateTime , GameImage ... images) {
		this.updateTime = updateTime;
		for(GameImage image : images) {
			this.images.add(image);
		}
	}
	
	/**
	 * Call in Game.update();
	 * @param delta Delta value.
	 */
	public void update(float delta) {
		if(elapsedTime >= updateTime) {
			if(animationIndex < images.size() - 1) {
				animationIndex++;
			} else {
				animationIndex = 0;
			}
			
			elapsedTime = 0;
		} else {
			elapsedTime += delta;
		}
	}
	
	/**
	 * Draw the animated image to the screen
	 * @param x The x position to draw the image.
	 * @param y The y position to draw the image.
	 * @param g The graphics object.
	 */
	public void draw(int x , int y, Graphics g) {
		images.get(animationIndex).draw(x, y, g);
	}


}
