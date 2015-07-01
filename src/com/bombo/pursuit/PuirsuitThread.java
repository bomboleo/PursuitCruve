package com.bombo.pursuit;

import java.util.LinkedList;
import java.util.List;
import java.util.Observable;


public class PuirsuitThread extends Observable implements Runnable {
	
	private List<Point> points;
	private boolean running = true;
	
	public PuirsuitThread(double[][] points, int size, double speed) {
		this.points = new LinkedList<>();
		Point lastPoint = null;
		for( int i = 0 ; i < size; i++) {
			Point p = new Point(points[0][i], points[1][i], speed, lastPoint);
			this.points.add(p);
			lastPoint = p;
		}
		this.points.get(0).setPrey(lastPoint);
	}

	@Override
	public void run() {
		while(running) {
			for(Point p : points) {
				if(!p.move()) {
					running = false;
				}
			}
			notifyObservers(points);
			this.setChanged();
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void stop() {
		running = false;
	}
}
