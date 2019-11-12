package com.aufe.tank;

import java.awt.Color;
import java.awt.Graphics;

public class Bullet {
	
	private static final int SPEED = 10; //子弹速度
	private static final int WIDTH = 10, HEIGHT = 10; //子弹速度
	private int x, y;	//子弹位置
	private Direction dir;	//子弹方向
	
	/**
	 * 创建子弹
	 * @param g
	 */
	public void paint(Graphics g) {
		
		Color color = g.getColor();
		
		g.setColor(Color.RED);
		g.fillOval(x, y, WIDTH, HEIGHT);
		g.setColor(color);
		move();
		
	}
	
	/**
	 * 子弹移动
	 */
	private void move() {
		
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

	public Bullet(int x, int y, Direction dir) {
		this.x = x;
		this.y = y;
		this.dir = dir;
	}
	
}
