package me.bevilacqua.gameWrapper.test;

import java.awt.Color;

import me.bevilacqua.gameWrapper.Game;
import me.bevilacqua.gameWrapper.Input.Input;
import me.bevilacqua.gameWrapper.image.GameImage;

public class Example extends Game {

	private static final long serialVersionUID = 1L;
	
	private int x = 50;
	private int y = 50;
	private int speed = 3;
	private GameImage test;
	
	public Example() {
		super(500, 500, "Example Game");
		test = new GameImage("res\\test.png");
	}

	@Override
	public void update() {
		if(input.keyDown(Input.LEFT)) {
			x -= speed * getDelta();
		}
		if(input.keyDown(Input.RIGHT)) {
			x += speed * getDelta();
		}
		
		if(input.keyDown(Input.UP)) {
			y -= speed * getDelta();
		}
		if(input.keyDown(Input.DOWN)) {
			y += speed * getDelta();
		}
	}

	@Override
	public void render() {
		setColor(Color.red);
//		g.fillRect(x,y,50,50);
		test.draw(x, y, g);
	}
	
	public static void main(String args[]) {
		new Example().start();
	}

}
