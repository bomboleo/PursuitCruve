package com.bombo.pursuit;
 
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
 
public class Main extends Application {
    
	public static void main(String[] args) {
        launch(args);
    }
 
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Drawing Operations Test");
        Group root = new Group();
        int canvaWidth = 700;
        Canvas canvas = new Canvas(canvaWidth, canvaWidth);
        
        GraphicsContext gc = canvas.getGraphicsContext2D();
        
        root.getChildren().add(canvas);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
        
    private void strokeHexagon(GraphicsContext gc, int x, int y) {
   		gc.setFill(Color.BLACK);
    	gc.setLineWidth(5);
    	double[] xPoints = new double[6];
    	double[] yPoints = new double[6];
    	double newX = -Math.cos(Math.PI/6)*(x);
    	double newY = -Math.sin(Math.PI/6)*(x) + y;
    	for(int i = 0; i < 6; i++) {
    		xPoints[i] = 2 * Math.cos(2*Math.PI*i/6) + newX*2*2;
    		yPoints[i] = 2 * Math.sin(2*Math.PI*i/6) + newY*2*2;
    	}
   		gc.fillPolygon(xPoints, yPoints, 6);
    	
	    gc.setFill(Color.BLACK);
	    //gc.fillText("");
	   	gc.strokePolygon(xPoints, yPoints, 6);
    }
    
}