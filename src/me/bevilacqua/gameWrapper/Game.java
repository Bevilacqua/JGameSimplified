package me.bevilacqua.gameWrapper;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

import me.bevilacqua.gameWrapper.Input.Input;

public abstract class Game extends Canvas implements Runnable {
	/**No idea why this is here. It just is. Get over it*/
	private static final long serialVersionUID = 1L;
	private int screenWidth , screenHeight;
	private Dimension screenDimension;
	private String title;
	private boolean showFPS = false;
	
	private int ticks;
	private int frames;
	private float delta;
	
	protected Graphics g;
	protected Input input;
	
	public JFrame frame = new JFrame();
	public BufferedImage screenImage;
	public boolean running;
	

	/**
	 * Create a new Game
	 * @param screenWidth The width in pixels of the screen
	 * @param screenHeight The height in pixels of the screen
	 * @param title The title of the window
	 * Default constructor for a new game. Defaults visible to true and resizable to false.
	 */
	public Game(int screenWidth , int screenHeight , String title) {
		this.screenWidth = screenWidth;
		this.screenHeight = screenHeight;
		screenDimension = new Dimension(this.screenWidth , this.screenHeight);
		this.title = title;
		
		setSize(screenDimension);
		setPreferredSize(screenDimension);
		frame.setTitle(this.title);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(this);
		frame.setSize(screenDimension);
		frame.pack();
		frame.setVisible(true);
		frame.setResizable(false);
		frame.requestFocus();
		input = new Input();
		addKeyListener(input);
		
		screenImage = new BufferedImage(this.screenWidth , this.screenHeight , BufferedImage.TYPE_INT_RGB);
	}
	
	/**
	 * Create a new Game
	 * @param screenWidth The width in pixels of the screen
	 * @param screenHeight The height in pixels of the screen
	 * @param title The title of the window
	 * @param visible Should the window be visible?
	 * @param resizable Should the window be resizable?
	 * @param defaultBackImage Should the default RGB image be used?
	 * Advanced constructor for new Game with more options
	 */
	public Game(int screenWidth , int screenHeight , String title , boolean visible , boolean resizable , boolean defaultBackImage) {
		this.screenWidth = screenWidth;
		this.screenHeight = screenHeight;
		screenDimension = new Dimension(this.screenWidth , this.screenHeight);
		this.title = title;
		
		frame.setTitle(this.title);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(this);
		frame.setSize(screenDimension);
		frame.pack();
		frame.setVisible(visible);
		frame.setResizable(resizable);
		frame.requestFocus();
		input = new Input();
		addKeyListener(input);
		
		if(defaultBackImage)
			screenImage = new BufferedImage(this.screenWidth , this.screenHeight , BufferedImage.TYPE_INT_RGB);
	}
	
	@Override
	public void run() {
		long lastTime = System.nanoTime();
		double nsPerTick = 1000000000D / 60D;
		
		int ticks = 0;
		int frames = 0;
		
		long lastTimer = System.currentTimeMillis();
		double delta = 0;
		requestFocus();
		
		while(running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / nsPerTick;
			lastTime = now;
			boolean shouldRender = false;
			while (delta >= 1) {
				shouldRender = true;
				ticks++;
				update();
				delta--;
			}
			
			if(shouldRender) {
				frames++;
				self_render();
			}
			
			if(System.currentTimeMillis() - lastTimer >= 1000) {
				lastTimer += 1000;
				this.ticks = ticks;
				this.frames = frames;
				frames = 0;
				ticks = 0;
			}
			this.delta = (float) delta;
		}
	}
	
	/**
	 * Starts the game loop. Correct usage should be found in the main method;
	 * <br>
	 * EX:
	 * <br>
	 * <code>
	 * public static void main(String args[]) { <br>
	 * &#09; new Game().start(); <br>
	 * }
	 * </code>
	 */
	public synchronized void start() {
		running = true;
		new Thread(this).start();
	}
	
	/**
	 * Updated every tick in the game loop
	 */
	public abstract void update();
	/**
	 * Rendered every "Should Render" in the game loop
	 */
	public abstract void render();

	private void self_render() {
		BufferStrategy bs = getBufferStrategy();
		if(bs == null) {
			createBufferStrategy(2);
			return;
		}
		
		
		g = bs.getDrawGraphics();
		
		g.drawImage(this.screenImage , 0, 0, getWidth(), getHeight(), null);	
		
		render();
		
		//TODO: Render scenes and post processors
		g.setColor(Color.white);
		if(this.showFPS && screenWidth <= 200) g.drawString(("Frames: " + this.frames), screenWidth - (screenWidth / 2), 0 + (screenHeight / 10));
		else if(this.showFPS && screenWidth < 350) g.drawString("Frames: " + this.frames, screenWidth - (screenWidth / 4), 0 + (screenHeight / 10));
		else if(this.showFPS)  g.drawString("Frames: " + this.frames, screenWidth - (screenWidth / 6), 0 + (screenHeight / 10));
		//Cleanup
		bs.show();
		g.dispose();
	}
	
	/**
	 * @param show Show the fps counter?
	 */
	public void setShowFPS(boolean show) {
		this.showFPS = show;
	}
	
	/**
	 * Set the color to be used by the Graphics object
	 * @param color Color to use
	 * 
	 * <br>EX: <code>Color.red</code>
	 */
	public void setColor(Color color) {
		g.setColor(color);
	}
	
	/**
	 * Get the delta value from the game loop
	 * @return The delta value in millisecounds
	 */
	public float getDelta() {
		return this.delta;
	}

	
}
