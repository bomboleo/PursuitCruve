package com.bombo.pursuit;

public class Point {

	private double x;
	private double y;

	private double speed;

	private Point prey;
	
	private boolean linearSpeed;

	public Point() {
		super();
	}

	public Point(double x, double y, double speed, Point prey, boolean linearSpeed) {
		super();
		this.x = x;
		this.y = y;
		this.speed = speed;
		this.prey = prey;
		this.linearSpeed = linearSpeed;
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
	
	public boolean isLinearSpeed() {
		return linearSpeed;
	}

	public void setLinearSpeed(boolean linearSpeed) {
		this.linearSpeed = linearSpeed;
	}

	public boolean move() {
		boolean close = !(Math.abs(x - prey.getX()) <= 7 && Math.abs(y - prey.getY()) <= 7);
		double vx = prey.getX() - x;
		double vy = prey.getY() - y;
		double n = Math.sqrt(vx*vx + vy*vy);
		if(linearSpeed) {
			x += vx/n * speed;
			y += vy/n * speed;
		} else {
			x += vx * 1/speed;
			y += vy * 1/speed;
			close = true;
		}
		return close; 
	}

}
