package me.bevilacqua.gameWrapper.Input;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class Input extends KeyAdapter{
	private List<Integer> currentPress = new ArrayList<Integer>();
	
	//List of basic arrow key events
	public static final int LEFT = KeyEvent.VK_LEFT;
	public static final int RIGHT = KeyEvent.VK_RIGHT;
	public static final int DOWN = KeyEvent.VK_DOWN;
	public static final int UP = KeyEvent.VK_UP;
	
	public void keyPressed(KeyEvent key) {
		for(int i = 0 ; i < currentPress.size() ; i++) {
			if(currentPress.get(i) == key.getKeyCode()) {
				return;
			}
		}
		currentPress.add(key.getKeyCode());
	}
	
	public void keyReleased(KeyEvent key) {
		for(int i = 0 ; i < currentPress.size() ; i++) {
			if(currentPress.get(i) == key.getKeyCode()) {
				currentPress.remove(i);
			}
		}
	}
	
	/**
	 * Is the key provided currently being held down on the keyboard. Note: Keys are taken as integers use KeyEvet.VK_?
	 * @param key The key to look for
	 * @return Is the key provided currently held down.
	 */
	public boolean keyDown(int key) {
		for(int i = 0 ; i < currentPress.size() ; i++) {
			if(currentPress.get(i) == key) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Prints the current key values(int ~ to string) to the console.
	 */
	public void printKeys() {
		System.out.println("=====");
		for(int i = 0 ; i < currentPress.size() ; i++) {
			System.out.println(currentPress.get(i).toString());
		}
		System.out.println("=====\n\n");
	}
	
	/**
	 * Currently unused. Future support for single pressed keys will utilize this.
	 */
	public void update(){}
        
}
