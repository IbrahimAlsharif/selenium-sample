import org.testng.Assert;
import org.testng.annotations.Test;
import pita.Calculations;

public class SampleTest {

   @Test (priority = 2)
    public void testFactorial() {
       Calculations calculator= new Calculations();
       Assert.assertEquals(calculator.factorial(5), 120);
   }
   @Test(priority = 1)
    public void testFactorial2() {
       Calculations calculator= new Calculations();
       Assert.assertEquals(calculator.factorial(4), 24);
   }

}
