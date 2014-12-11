package me.bevilacqua.gameWrapper.test;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import me.bevilacqua.gameWrapper.Game;

public class Example extends Game {

	private static final long serialVersionUID = 1L;
	
	private int x = 50;
	private int y = 50;
	private int speed = 3;
	
	public Example() {
		super(500, 500, "Example Game");
	}

	@Override
	public void update() {
		input.update();
		if(input.keyDown(KeyEvent.VK_LEFT)) {
			x -= speed * getDelta();
		}
		else if(input.keyDown(KeyEvent.VK_RIGHT)) {
			x += speed * getDelta();
		}
		
		else if(input.keyDown(KeyEvent.VK_UP)) {
			y -= speed * getDelta();
		}
		else if(input.keyDown(KeyEvent.VK_DOWN)) {
			y += speed * getDelta();
		}
		
	}

	@Override
	public void render() {
		setColor(Color.red);
		g.drawRect(x,y,50,50);
	}
	
	public static void main(String args[]) {
		new Example().start();
	}

}
