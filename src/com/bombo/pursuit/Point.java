package com.bombo.pursuit;

public class Point {

	private double x;
	private double y;

	private double speed;

	private Point prey;

	public Point() {
		super();
	}

	public Point(double x, double y, double speed, Point prey) {
		super();
		this.x = x;
		this.y = y;
		this.speed = speed;
		this.prey = prey;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public Point getPrey() {
		return prey;
	}

	public void setPrey(Point prey) {
		this.prey = prey;
	}
	
	public boolean move() {
		if(Math.abs(x - prey.getX()) <= 20 && Math.abs(y - prey.getY()) <= 20) {
			return false;
		}
		double vx = prey.getX() - x;
		double vy = prey.getY() - y;
		double n = Math.sqrt(vx*vx + vy*vy);
		x += vx/n * speed;
		y += vy/n * speed;
		return true; 
	}

}
