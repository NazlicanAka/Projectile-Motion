package codes.teaching.testing.student;

import java.io.File;
import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import question.Ball;
import question.GameScene;
import question.Obstacle;



/* TODO: Import the classes you need for testing */

// Tests will be sorted in lexicographical order. Therefore start the names as "test1_TestName" 
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

//@RunWith(JUnit4.class)
public final class ExamJUnitCases extends ExamJUnit {

	//	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	//	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	//	private final PrintStream originalOut = System.out;
	//	private final PrintStream originalErr = System.err;

	public static String lineSeperator = System.lineSeparator();

	@Rule
	public TestName name = new TestName();

	@Test
	public void test1() {
		String inputForReport = "Two obstacles, which can be avoided.";
		String expectedAnswer = "31.30000000000016";

		ExamJUnit.testInitialization(1, name.getMethodName(), inputForReport, expectedAnswer);
		try {
			String answerStudent = "";
			
			Ball ball = new Ball(30);
			ArrayList<Obstacle> obstacles = new ArrayList<Obstacle>();
			Obstacle obstacle1 = new Obstacle(2,10,2);
			Obstacle obstacle2 = new Obstacle(1,5,25);
			obstacles.add(obstacle1);
			obstacles.add(obstacle2);
			
			GameScene scene = new GameScene(obstacles, ball, 100);
			double answer = scene.findVelocity(45.0);
			
			answerStudent = Double.toString(answer);
			ExamJUnit.testCheck(answerStudent);
		} catch (Exception e) {
			testFailedExecution(e);
		}
	}
}
