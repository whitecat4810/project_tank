package com.aufe.tank;

import java.awt.Graphics;

public class Tank {
	
	private int x, y;	//坦克位置
	private Direction dir = Direction.DOWN;	//坦克方向
	private static final int SPEED = 10;	//坦克速度
	private boolean moving = false;	//坦克是否移动
	
	/**
	 * 构造坦克
	 * @param g
	 */
	public void paint(Graphics g) {
		
		g.fillRect(x, y, 50, 50);
		
		move();
		
	}
	
	/**
	 * 坦克移动
	 */
	private void move() {
		
		if (!moving) return;
		
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

	public Direction getDir() {
		return dir;
	}

	public void setDir(Direction dir) {
		this.dir = dir;
	}

	public boolean isMoving() {
		return moving;
	}

	public void setMoving(boolean moving) {
		this.moving = moving;
	}
	
	public Tank(int x, int y, Direction dir) {
		super();
		this.x = x;
		this.y = y;
		this.dir = dir;
	}
	
}
