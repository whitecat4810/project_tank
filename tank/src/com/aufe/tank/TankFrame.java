package com.aufe.tank;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame{

	int x = 200, y = 200;
	Direction dir = Direction.DOWN;
	private static final int SPEED = 10;
	
	public TankFrame() {
		
		setVisible(true);	//设置窗口可见
		setResizable(false);	//设置不可改变窗口大小
		setSize(800, 600);	//设置窗口宽度800px 长度600px
		setTitle("Tanks War");	//设置标题
		
		this.addKeyListener(new KeyListener());	//创建键盘监听
		
		addWindowListener(new WindowAdapter() {	
			
			/**
			 * 窗口关闭功能
			 */
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
			
		});
	}
	
	@Override
	public void paint(Graphics g) {
		
		g.fillRect(x, y, 50, 50);
		
		switch (dir) {
			case LEFT:
				x -= SPEED;
				break;
			case UP:
				y -= SPEED;
				break;
			case RIGHT:
				x += SPEED;
				break;
			case DOWN:
				y += SPEED;
				break;
	
			default:
				break;
		}
		
	}
	
	/**
	 * 键盘监听内部类
	 * @author whitecat
	 *
	 */
	class KeyListener extends KeyAdapter {

		/**
		 * 方向键按下判断
		 */
		boolean left = false;
		boolean right = false;
		boolean up = false;
		boolean down = false;
		
		/**
		 * 按下键盘事件监听
		 */
		@Override
		public void keyPressed(KeyEvent e) {
			
			int key = e.getKeyCode();
			
			switch (key) {
				case KeyEvent.VK_LEFT:
					left = true;
					break;
				case KeyEvent.VK_RIGHT:
					right = true;
					break;
				case KeyEvent.VK_UP:
					up = true;
					break;
				case KeyEvent.VK_DOWN:
					down = true;
					break;
	
				default:
					break;
			}
			
			setClientTankDir();
			
		}
		
		/**
		 * 抬起键盘事件监听
		 */
		@Override
		public void keyReleased(KeyEvent e) {
			
			int key = e.getKeyCode();
			
			switch (key) {
			case KeyEvent.VK_LEFT:
				left = false;
				break;
			case KeyEvent.VK_RIGHT:
				right = false;
				break;
			case KeyEvent.VK_UP:
				up = false;
				break;
			case KeyEvent.VK_DOWN:
				down = false;
				break;

			default:
				break;
			}
			
			setClientTankDir();
			
		}

		private void setClientTankDir() {
			
			if (left) dir = Direction.LEFT;
			if (right) dir = Direction.RIGHT;
			if (up) dir = Direction.UP;
			if (down) dir = Direction.DOWN;
			
		}
		
	}
	
	
	
}
