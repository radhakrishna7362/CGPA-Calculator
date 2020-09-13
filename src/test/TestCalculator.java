package test;
import org.junit.*;
import skill.CGPA;
public class TestCalculator {
	
	CGPA c=new CGPA();
	@Before
	public void addCourseTest() {
		c.addCourse("Java",5.0,91);
	}
	
//	@SuppressWarnings("deprecation")
	@Test
	public void TestCal() {
		double expresult=10.0;
		double actresult=c.TestCGPACalulator();
		Assert.assertEquals(expresult, actresult, 0.0);
	}
	
}
