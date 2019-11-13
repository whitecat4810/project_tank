package com.aufe.tank;

import java.awt.Graphics;
import java.awt.Rectangle;

/**
 * 子弹类
 * @author whitecat
 *
 */
public class Bullet {
	
	private int x, y;	//子弹位置
	private boolean alive = true;	//子弹是否出界/爆炸,true为未出界
	private static final int SPEED = 10; //子弹速度
	public static final int WIDTH = 
			ResourceManager.bulletD.getWidth(), 
			HEIGHT = ResourceManager.bulletD.getHeight(); //子弹高度宽度
	private Direction dir;	//子弹方向
	private Team team = Team.HOS_FORCES;	//子弹默认为敌军子弹
	private MainFrame frame = null;	//主框架的引用
	
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
				x > MainFrame.GAME_WIDTH || y > MainFrame.GAME_HEIGHT) {
			alive = false;
		}
		
	}

	/**
	 * 子弹与坦克的碰撞检测
	 * @param tank
	 */
	public void crash(Tank tank) {
		
		if (this.team == tank.getTeam()) return;	//判断是否为友军，如果是，不必检测
		
		Rectangle rectB = new Rectangle(this.x, this.y, WIDTH, HEIGHT);	//构造矩形辅助类，用于碰撞检测
		Rectangle rectT = new Rectangle(tank.getX(), tank.getY(), Tank.WIDTH, Tank.HEIGHT);
		
		if (rectB.intersects(rectT)) {	//判断两图片是否相交
			
			tank.die();
			this.explode();
			
			int explosionX = tank.getX() + Tank.WIDTH/2  - Explosion.WIDTH/2;	//计算子弹位置，将子弹放在坦克中心
			int explosionY = tank.getY() + Tank.HEIGHT/2 - Explosion.HEIGHT/2;
			
			
			frame.explosions.add(new Explosion(explosionX, explosionY, frame));
			
		}
	}
	
	/**
	 * 子弹爆炸
	 */
	private void explode() {
		this.alive = false;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public Bullet(int x, int y, Direction dir, Team team, MainFrame frame) {
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.team = team;
		this.frame = frame;
	}

}
