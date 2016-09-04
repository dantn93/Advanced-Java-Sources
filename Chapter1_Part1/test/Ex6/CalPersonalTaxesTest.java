/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex6;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author snow
 */
public class CalPersonalTaxesTest {

    public CalPersonalTaxesTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    
    @Test
    public void testCalPersonalTaxes1() {
        Employee employee = new Employee("A",2.67,1,12000000);

        double ex = 138210;
        double ac = employee.calPersonalRevenueTax();
        assertEquals(ex, ac, 0);
    }

    @Test
    public void testCalPersonalTaxes2() {
        Employee employee = new Employee("A",5,2,15000000);
        double ex = 260000;
        double ac = employee.calPersonalRevenueTax();
        assertEquals(ex, ac, 0);
    }

    @Test
    public void testCalPersonalTaxes3() {
        Employee employee = new Employee("A",7,2,12000000);
        double ac = employee.calPersonalRevenueTax();

        double ex = 231000;
        assertEquals(ex, ac, 0);
    }

    @Test
    public void testCalPersonalTaxes4() {
        Employee employee = new Employee("A",4.5,3,15000000);
        double ac = employee.calPersonalRevenueTax();

        double ex = 43500;
        assertEquals(ex, ac, 0);
    }

    @Test
    public void testCalPersonalTaxes5() {
        Employee employee = new Employee("A",5,3,20000000);
        double ac = employee.calPersonalRevenueTax();

        double ex = 400000;
        assertEquals(ex, ac, 0);
    }

    @Test
    public void testCalPersonalTaxes6() {
        Employee employee = new Employee("A",0,2,13000000);
        double ac = employee.calPersonalRevenueTax();

        double ex = 10;
        assertNotEquals(ex, ac, 0);
    }

    @Test
    public void testCalPersonalTaxes7() {
        Employee employee = new Employee("A",2.3,0,10000000);
        double ac = employee.calPersonalRevenueTax();


        double ex = 12800000;
        assertNotEquals(ex, ac, 0);
    }

    @Test
    public void testCalPersonalTaxes8() {
        Employee employee = new Employee("A",3,2,1000000);
        double ac = employee.calPersonalRevenueTax();

        double ex = 3000000;
        assertNotEquals(ex, ac, 0);
    }

    @Test
    public void testCalPersonalTaxes9() {
        Employee employee = new Employee("A",4,1,10000000);
        double ac = employee.calPersonalRevenueTax();

        double ex = 15000000;
        assertNotEquals(ex, ac, 0);
    }

    @Test
    public void testCalPersonalTaxes10() {
        Employee employee = new Employee("A",1.2,7,10000000);
        double ac = employee.calPersonalRevenueTax();

        double ex = 11510000;
        assertNotEquals(ex, ac, 0);
    }
}
