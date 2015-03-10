package me.bevilacqua.gameWrapper.test;

import me.bevilacqua.gameWrapper.Game;
import me.bevilacqua.gameWrapper.image.AnimatedGameImage;

public class AnimationExample extends Game {

	private static final long serialVersionUID = 1L;
	
	private AnimatedGameImage image = null;

	public AnimationExample(int screenWidth, int screenHeight, String title) {
		super(screenWidth, screenHeight, title);
		image = new AnimatedGameImage(100, "res\\AnimationOne.png" , "res\\AnimationTwo.png" , "res\\AnimationThree.png");
	}

	@Override
	public void update() {
		image.update(getDelta());
		
	}

	@Override
	public void render() {
		image.draw(50, 50, g);
	}
	
	public static void main(String args[]) {
		new AnimationExample(500 , 500 , "Animation Example").start();
	}

}
