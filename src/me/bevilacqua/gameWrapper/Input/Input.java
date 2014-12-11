package me.bevilacqua.gameWrapper.Input;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class Input extends KeyAdapter{
	private List<Integer> currentPress = new ArrayList<Integer>();
	
	public void keyPressed(KeyEvent key) {
		currentPress.add(key.getKeyCode());
	}
	
	public void keyReleased(KeyEvent key) {
		for(int i = 0 ; i < currentPress.size() ; i++) {
			if(currentPress.get(i) == key.getKeyCode()) {
				currentPress.remove(i);
			}
		}
	}
	
	public boolean keyDown(int key) {
		for(int i = 0 ; i < currentPress.size() ; i++) {
			if(currentPress.get(i) == key) {
				return true;
			}
		}
		return false;
	}
	
	public void update(){}
        
}
