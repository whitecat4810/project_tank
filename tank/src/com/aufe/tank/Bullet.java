package com.aufe.tank;

import java.awt.Graphics;
import java.awt.Rectangle;

public class Bullet {
	
	private int x, y;	//子弹位置
	private boolean alive = true;	//子弹是否出界/爆炸,true为未出界
	private static final int SPEED = 10; //子弹速度
	public static final int WIDTH = 
			ResourceManager.bulletD.getWidth(), 
			HEIGHT = ResourceManager.bulletD.getHeight(); //子弹高度宽度
	private Direction dir;	//子弹方向
	private TankFrame frame;	//主框架的引用
	
	/**
	 * 创建子弹
	 * @param g
	 */
	public void paint(Graphics g) {
		
		if (!alive) 
			frame.bullets.remove(this);
		
		switch (dir) {
			case LEFT:
				g.drawImage(ResourceManager.bulletL, x, y, null);
				break;
			case RIGHT:
				g.drawImage(ResourceManager.bulletR, x, y, null);
				break;
			case UP:
				g.drawImage(ResourceManager.bulletU, x, y, null);
				break;
			case DOWN:
				g.drawImage(ResourceManager.bulletD, x, y, null);
				break;
	
			default:
				break;
		}
		//g.drawImage(ResourceManager.bulletD, x, y, null);
		
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
		
		if (x < 0 || y < 0 || 
				x > TankFrame.GAME_WIDTH || y > TankFrame.GAME_HEIGHT) {
			alive = false;
		}
		
	}

	/**
	 * 碰撞检测
	 * @param tank
	 */
	public void crash(Tank tank) {
		
		Rectangle rectB = new Rectangle(this.x, this.y, WIDTH, HEIGHT);	//构造矩形辅助类，用于碰撞检测
		Rectangle rectT = new Rectangle(tank.getX(), tank.getY(), Tank.WIDTH, Tank.HEIGHT);
		
		if (rectB.intersects(rectT)) {	//判断两图片是否相交
			tank.die();
			this.explode();
		}
	}
	
	/**
	 * 子弹爆炸
	 */
	private void explode() {
		this.alive = false;
	}

	public Bullet(int x, int y, Direction dir, TankFrame frame) {
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.frame = frame;
	}

}
