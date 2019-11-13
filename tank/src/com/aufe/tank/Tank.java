package com.aufe.tank;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

/**
 * 坦克类
 * @author whitecat
 *
 */
public class Tank {
	
	private int x, y;	//坦克位置
	private static final int SPEED = 10;	//坦克速度
	private boolean moving = true;	//坦克是否移动
	private boolean alive = true;	//坦克是否存活
	private Direction dir = Direction.UP;	//坦克方向
	private Team team = Team.HOS_FORCES;	//坦克默认为敌军
	private	MainFrame frame;	//创建坦克的引用(组合模式)
	private Random random = new Random();	//敌方tank随机数
	public static final int WIDTH = 
			ResourceManager.friendlyTankD.getWidth(), 
			HEIGHT = ResourceManager.friendlyTankD.getHeight();
	Rectangle rec = new Rectangle();	
	
	/**
	 * 构造坦克
	 * @param g
	 */
	public void paint(Graphics g) {
		
		if (!alive) {
			frame.enemies.remove(this);	//判断坦克是否存活,如果不存活，移除该坦克
		}
		
		switch (dir) {
		case LEFT:
			g.drawImage(this.team == Team.FRI_FORCES? 
					ResourceManager.friendlyTankL : ResourceManager.hostileTankL, x, y, null);
			break;
		case RIGHT:
			g.drawImage(this.team == Team.FRI_FORCES? 
					ResourceManager.friendlyTankR : ResourceManager.hostileTankR, x, y, null);
			break;
		case UP:
			g.drawImage(this.team == Team.FRI_FORCES? 
					ResourceManager.friendlyTankU : ResourceManager.hostileTankU, x, y, null);
			break;
		case DOWN:
			g.drawImage(this.team == Team.FRI_FORCES? 
					ResourceManager.friendlyTankD : ResourceManager.hostileTankD, x, y, null);
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
		
		if (this.team == Team.HOS_FORCES && random.nextInt(100) > 95) {
			this.fire();	//敌方随机开火
		}
		
		if (this.team == Team.HOS_FORCES && random.nextInt(100) > 96) {
			randomDir();
		}
		
		boundaryDet();
		
		rec.x = this.x;	//更新X的值
		rec.y = this.y;	//更新Y的值
		
	}

	/**
	 * 边界检测 (boundary detection)
	 */
	private void boundaryDet() {
		
		if (this.x < 2 ) {	//不设为0，留出一点边界，美观
			x = 2;
		}	
		if (this.y < 28) {
			y = 28;
		}
		if (this.x > MainFrame.GAME_WIDTH - Tank.WIDTH - 2) {
			x = MainFrame.GAME_WIDTH - Tank.WIDTH - 2;
		}
		if (this.y > MainFrame.GAME_HEIGHT - Tank.HEIGHT - 2) {
			y = MainFrame.GAME_HEIGHT - Tank.HEIGHT - 2;
		}
			
	}

	/**
	 * 敌方随机开火
	 */
	private void randomDir() {
		
		this.dir = Direction.values()[random.nextInt(4)];	
		
	}

	/**
	 * 坦克开火
	 */
	public void fire() {
		
		int bulletX = this.x + Tank.WIDTH/2 + 15 - Bullet.WIDTH;	//计算子弹位置，将子弹放在坦克中心
		int bulletY = this.y + Tank.HEIGHT/2 + 15 - Bullet.HEIGHT;
		
		frame.bullets.add(new Bullet(bulletX, bulletY, this.dir, this.team, frame));
		
//		new Thread(()->new Audio("audio/tank_fire.wav").play()).start();
		
	}
	
	/**
	 * 坦克死亡
	 */
	public void die() {
		this.alive = false;
	}
	
	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
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
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Tank(int x, int y, Direction dir, Team team, MainFrame frame) {
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.team = team;
		this.frame = frame;
		
		rec.x = this.x;
		rec.y = this.y;
		rec.height = this.HEIGHT;
		rec.width = this.WIDTH;
		
	}

}
