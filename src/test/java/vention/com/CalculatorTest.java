package vention.com;

import org.testng.annotations.*;
import static org.testng.Assert.assertEquals;

public class CalculatorTest {
  private Calculator calc;

  @BeforeClass
  public void beforeClass() {
    System.out.println("Initializing Calculator instance.");
    calc = new Calculator();
  }
  @AfterClass
  public void afterClass() {
    System.out.println("Finished all tests.");
  }
  @BeforeMethod
  public void beforeMethod(){
    System.out.println("Starting a test...");
  }
  @AfterMethod
  public void afterMethod(){
    System.out.println("Test completed.");
  }
  @DataProvider(name = "addData")
  public Object[][] createData() {
    return new Object[][] {
      {1,2,3},
      {-1,-1,-2},
      {0,0,0},
      {350,450,800},
    };
  }

  @Test(dataProvider = "addData")
  public void testAdd(int a, int b, int expected) {
    assertEquals(calc.add(a, b), expected);
  }

  @Test
  public void testSubtract() {
    assertEquals(calc.subtract(10, 5), 5);
  }

  @Test
  public void testMultiply() {
    assertEquals(calc.multiply(5, 2), 10);
  }

  @Test(dependsOnMethods = { "testMultiply" })
  public void testDivide() {
    assertEquals(calc.divide(10, 2), 5);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDivideByZero() {
    calc.divide(5,0);
  }
}
