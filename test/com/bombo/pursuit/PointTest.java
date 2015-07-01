package com.bombo.pursuit;

import static org.junit.Assert.*;

import org.junit.Test;

public class PointTest {

	@Test
	public void testMove() {
		Point p = new Point(0, 0, 1, null);
		Point p2 = new Point(0, 100, 1, p);
		System.out.println(p2.move());
		assertEquals(0, p2.getX(), 0);
		assertEquals(99, p2.getY(), 0);
		

		p = new Point(0, 0, 1, null);
		p2 = new Point(0, 100, 1, p);
		System.out.println(p2.move());
		assertEquals(0, p2.getX(), 0);
		assertEquals(99, p2.getY(), 0);
		

		p = new Point(0, 0, 1, null);
		p2 = new Point(100, 0, 1, p);
		System.out.println(p2.move());
		assertEquals(99, p2.getX(), 0);
		assertEquals(0, p2.getY(), 0);
	}

}
