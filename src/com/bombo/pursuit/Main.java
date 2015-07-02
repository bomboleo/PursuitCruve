package com.bombo.pursuit;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Main extends Application implements Observer {

	private GraphicsContext gc;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		Parameters parameters = getParameters();
		List<String> args = parameters.getRaw();
		int size = 4;
		if (args.size() > 0) {
			try {
				size = Integer.parseInt(args.get(0));
			} catch (NumberFormatException e) {
				System.err.println("The first argument must be an integer.");
			}
		}

		primaryStage.setTitle("Drawing Operations Test");
		Group root = new Group();
		int canvaWidth = 900;
		Canvas canvas = new Canvas(canvaWidth, canvaWidth);

		gc = canvas.getGraphicsContext2D();
		double[][] points = strokePolygon(gc, canvaWidth/2, canvaWidth/2, size, canvaWidth/2);

		root.getChildren().add(canvas);
		primaryStage.setScene(new Scene(root));
		primaryStage.show();

		PuirsuitThread pt = new PuirsuitThread(points, size, 64, false);
		pt.addObserver(this);
		new Thread(pt).start();

		primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			@Override
			public void handle(WindowEvent event) {
				pt.stop();
			}
		});
	}

	private double[][] strokePolygon(GraphicsContext gc, int x, int y, int point, double width) {
		gc.setFill(Color.BLACK);
		gc.setStroke(Color.BLACK);
		gc.setLineWidth(2);
		double[] xPoints = new double[point];
		double[] yPoints = new double[point];
		for (int i = 0; i < point; i++) {
			xPoints[i] = width * Math.cos(2 * Math.PI * i / point) + x;
			yPoints[i] = width * Math.sin(2 * Math.PI * i / point) + y;
		}
		gc.strokePolygon(xPoints, yPoints, point);
		return new double[][] { xPoints, yPoints };
	}

	@Override
	public void update(Observable o, Object arg) {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				double[][] pointCoords = (double[][]) arg;
				double[] lastPoint = null;
				for (int i = 0; i < pointCoords.length; i++) {
					gc.setFill(Color.GREEN);
					double x = pointCoords[i][0];
					double y = pointCoords[i][1];
					gc.fillOval(x - 2.5, y - 2.5, 5, 5);
					if (lastPoint != null) {
						gc.strokeLine(lastPoint[0], lastPoint[1], x, y);
					}
					lastPoint = new double[] { x, y };
				}
				gc.strokeLine(lastPoint[0], lastPoint[1], pointCoords[0][0], pointCoords[0][1]);
			}
		});
	}

}