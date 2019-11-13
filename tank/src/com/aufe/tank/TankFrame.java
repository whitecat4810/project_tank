package com.aufe.tank;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

public class TankFrame extends Frame{

	public static final int GAME_WIDTH = 800, GAME_HEIGHT = 600;	//设置游戏窗口大小
	List<Bullet> bullets = new ArrayList<>();	//创建子弹容器
	List<Tank> enemies = new ArrayList<>();	//创建敌方坦克容器
	Tank myTank = new Tank(300, 400, Direction.UP, this);	//创建我方坦克
	
	public TankFrame() {
		
		setVisible(true);	//设置窗口可见
		setResizable(false);	//设置不可改变窗口大小
		setSize(GAME_WIDTH, GAME_HEIGHT);	//设置窗口宽度800px 长度600px
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
		
		Color color = g.getColor();
		g.setColor(Color.WHITE);
		g.drawString("子弹数量" + bullets.size(), 10, 60);
		g.drawString("敌方坦克数量" + enemies.size(), 10, 80);
		g.setColor(color);
		
		myTank.paint(g);	//画己方坦克
		for (int i = 0; i < bullets.size(); i++) {
			bullets.get(i).paint(g);	//画子弹
		}
		
		for (int i = 0; i < enemies.size(); i++) {
			enemies.get(i).paint(g);	//画敌方坦克
		}
		
		for (int i = 0; i < bullets.size(); i++) {
			for (int j = 0; j < enemies.size(); j++) {
				bullets.get(i).crash(enemies.get(j));
			}
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
			case KeyEvent.VK_X:		//按下X键打出一颗子弹
				myTank.fire();
				break;

			default:
				break;
			}
			
			setClientTankDir();
			
		}

		private void setClientTankDir() {
			
			if (!left && !right && !up && !down) myTank.setMoving(false);	//没有按下方向键，坦克静止
			else {
				myTank.setMoving(true);	//按下方向键，坦克移动
				if (left) myTank.setDir(Direction.LEFT);
				if (right) myTank.setDir(Direction.RIGHT);
				if (up) myTank.setDir(Direction.UP);
				if (down) myTank.setDir(Direction.DOWN);
			}
			
		}
		
	}
	
	/**
	 * 双缓冲解决闪屏
	 */
	Image offScreenImage = null;
	@Override
	public void update(Graphics g) {
		
		if (offScreenImage == null) {
			offScreenImage = this.createImage(GAME_WIDTH,GAME_HEIGHT);
		}
		
		Graphics gOffScreen = offScreenImage.getGraphics();
		Color c = gOffScreen.getColor();
		gOffScreen.setColor(Color.BLACK);
		gOffScreen.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
		gOffScreen.setColor(c);
		paint(gOffScreen);
		g.drawImage(offScreenImage, 0, 0, null);
		
	}
	
	
}
