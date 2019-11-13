package com.aufe.tank;

import java.awt.Color;
import java.awt.Graphics;

public class Tank {
	
	private int x, y;	//坦克位置
	private Direction dir = Direction.UP;	//坦克方向
	private static final int SPEED = 5;	//坦克速度
	private boolean moving = false;	//坦克是否移动
	private	TankFrame frame;	//创建坦克的引用(组合模式)
	public static final int WIDTH = 
			ResourceManager.tankD.getWidth(), 
			HEIGHT = ResourceManager.tankD.getHeight();
	
	
	/**
	 * 构造坦克
	 * @param g
	 */
	public void paint(Graphics g) {
		
		switch (dir) {
		case LEFT:
			g.drawImage(ResourceManager.tankL, x, y, null);
			break;
		case RIGHT:
			g.drawImage(ResourceManager.tankR, x, y, null);
			break;
		case UP:
			g.drawImage(ResourceManager.tankU, x, y, null);
			break;
		case DOWN:
			g.drawImage(ResourceManager.tankD, x, y, null);
			break;

		default:
			break;
		}
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
		
		int bulletX = this.x + Tank.WIDTH/2 + 5 - Bullet.WIDTH;
		int bulletY = this.y + Tank.HEIGHT/2 + 8 - Bullet.HEIGHT;
		
		frame.bullets.add(new Bullet(bulletX, bulletY, this.dir, frame));
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
