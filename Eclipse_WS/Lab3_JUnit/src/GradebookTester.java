import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class GradebookTester {
	private GradeBook g1;
	private GradeBook g2;

	@BeforeEach
	void setUp() throws Exception {
		g1 = new GradeBook(5);
		g1.addScore(50);
		g1.addScore(75);
	}

	@AfterEach
	void tearDown() throws Exception {
		g1 = null;
		g2 = null;
	}

	@Test
	void testGetScoreSize() {
		assertEquals(2, g1.getScoreSize());
	}

	@Test
	void testToString() {
		assertTrue((g1.toString()).equals("50.0 75.0 "));
	}
	
	@Test
	void testSum() {
		assertEquals(125, g1.sum(),.0001);
	}
	@Test
	void testMinimum() {
		assertEquals(50, g1.minimum(),.001);
	}
	@Test
	void addScoreTest() {
		System.out.println("toString Start:");
		System.out.println(g1.toString());
		System.out.println("toString End");
		assertTrue((g1.toString()).equals("50.0 75.0 "));
	}
	@Test
	void finslScoreTest() {
		assertEquals(75, g1.finalScore(), .001);
	}
}
