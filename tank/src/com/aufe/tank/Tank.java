package com.aufe.tank;

import java.awt.Color;
import java.awt.Graphics;

public class Tank {
	
	private int x, y;	//坦克位置
	private Direction dir = Direction.DOWN;	//坦克方向
	private static final int SPEED = 5;	//坦克速度
	private boolean moving = false;	//坦克是否移动
	private	TankFrame frame;	//创建坦克的引用(组合模式)
	
	/**
	 * 构造坦克
	 * @param g
	 */
	public void paint(Graphics g) {
		
		Color color = g.getColor();
		g.setColor(Color.GREEN);
		g.fillRect(x, y, 50, 50);
		g.setColor(color);
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

	/**
	 * 坦克开火
	 */
	public void fire() {
		frame.bullets.add(new Bullet(this.x, this.y, this.dir, frame));
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
	
	public Tank(int x, int y, Direction dir, TankFrame frame) {
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.frame = frame;
	}

}
