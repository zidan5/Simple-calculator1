import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {
    @Test
    public void TestAdd(){
        Assert.assertEquals(Calculator.add(1,1),2);
    }
    @Test
    public void TestMultiply(){
        Assert.assertEquals(Calculator.multiply(2,2,2),8);
    }
    @Test
    public void TestInnerInputValidation(){
        Assert.assertEquals(Calculator.InnerInputValidation("y"),"y");
    }
    @Test
    public void TestInputValidation(){
        Assert.assertEquals(Calculator.ValidateInput("5"),true);
    }
}
