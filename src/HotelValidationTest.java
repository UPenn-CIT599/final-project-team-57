//import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Validation tests for team project
 * Ensure your answers are stored in a file called answers.txt
 * See the provided .txt document for example formatting
 * @author vipin
 *
 */

public class HotelValidationTest {

	static ArrayList<String> answers;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		answers = new ArrayList<>();
		File inputFile = new File("answers.txt");

		// Reads in the answers from answers.txt
		try( Scanner in = new Scanner(inputFile) ){

			while(in.hasNextLine()) {
				answers.add(in.nextLine());
			}

		} catch (IOException e ) {
			e.printStackTrace();
			System.out.println("Check that your file is being written properly!");
		}

	}

//	@Test
//	public void allQuestionsAnsweredTest() {
//		assertEquals( 1, answers.size(),  "Check that you are answering all the questions!" );
//	}

	
	
	
	
}
