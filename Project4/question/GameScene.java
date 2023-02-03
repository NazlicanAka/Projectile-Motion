
package question;

import java.util.ArrayList;

public class GameScene {

	// Data Fields
	private ArrayList<Obstacle> obstacles = new ArrayList<Obstacle>();
	private Ball ball;
	

	private int targetX;
	private int targetY = 0;

	private static final int MAX_ANGLE = 90;
	private static final int MAX_VELOCITY = 100;
	private static final int MIN_VELOCITY = 20;
	
	private double t = 0;
	//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE
	
	// Constructor 
	public GameScene(ArrayList<Obstacle> obstacles, Ball ball, int targetX) {
		super();
		this.obstacles = obstacles;
		this.ball = ball;
		this.targetX = targetX;
		
	}
	
	// Setter method for x, we can change the x coordinate
	public void setTargetX(int targetX) {
		this.targetX = targetX;
	}



	//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE

	public double findVelocity(double angle) {

		//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE
		double ballVx = ball.getVelocity() * Math.cos(Math.toRadians(angle));
		
		boolean a = true;
		while(a) {
		    System.out.println("while la girdi");
			double Xt = ball.getX() + ball.getVelocity() * Math.cos(Math.toRadians(angle)) * t;
			double Yt = ball.getY() + ball.getVelocity() * Math.sin(Math.toRadians(angle)) * t - (1/2)*9.81*Math.pow(t,2);
			
			
			for(int i=0; i<obstacles.size(); i++) {
				t = obstacles.get(i).getX() - Xt;
				if(Yt <= obstacles.get(i).getHeight()) {
					
					a = false;
					return -1;
					
				}
			
			}
			
			if(obstacles.size() == 0) {
				break;
			}
		}
		return ball.getVelocity();
		
		
		


		//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE
	}

	
}



//Xt is the position of ball
//		double Xt = ball.getX() + ball.getVelocity() * Math.cos(Math.toRadians(angle)) * t;
//		double Yt = ball.getY() + ball.getVelocity() * Math.sin(Math.toRadians(angle)) * t - (1/2)*9.81*Math.pow(t,2);



