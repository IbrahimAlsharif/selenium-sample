import org.testng.Assert;
import org.testng.annotations.Test;
import pita.Calculations;

public class AdvancedCalculatorTest {

   @Test (priority = 2)
    public void testAdvancedFactorial() {
       Calculations calculator= new Calculations();
       Assert.assertEquals(calculator.factorial(5), 120);
   }
   @Test(priority = 1)
    public void testAdvancedFactorial2() {
       Calculations calculator= new Calculations();
       Assert.assertEquals(calculator.factorial(4), 23);
   }

}
