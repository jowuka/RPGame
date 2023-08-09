package Main;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import entity.entity;
public class KeyHandler implements KeyListener{
	public int idleDirection;
	
	public boolean upPressed, downPressed, leftPressed, rightPressed;
	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		if (code == KeyEvent.VK_W) {
			upPressed = true;
		}
		
		if (code == KeyEvent.VK_S) {
			downPressed = true;
		}
		if (code == KeyEvent.VK_A) {
			leftPressed = true;
		}
		if (code == KeyEvent.VK_D) {
			rightPressed = true;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int code = e.getKeyCode();
		if (code == KeyEvent.VK_W) {
			upPressed = false;
			idleDirection = 1;
		}
		if (code == KeyEvent.VK_S) {
			downPressed = false;
			idleDirection = 2;
		}
		if (code == KeyEvent.VK_A) {
			leftPressed = false;
			idleDirection = 3;
		}
		if (code == KeyEvent.VK_D) {
			rightPressed = false;
			idleDirection = 4;
		}
		
	}



}
