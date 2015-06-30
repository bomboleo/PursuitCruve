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
	
	public void move() {
		double dx = prey.getX() - x;
		double dy = prey.getY() - y;
		
		double ny = dy / (Math.sqrt(dx*dx + dy*dy)) + y;
		double nx = ((ny - y)*dx / dy) + x;
		
		x = nx * speed;
		y = ny * speed;
	}

}
