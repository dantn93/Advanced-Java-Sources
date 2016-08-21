/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex2;

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
public class SubTest {
    
    public SubTest() {
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
    public void subTest() {
        Equation obj = new Equation(0, 0, "-");
        double ac = obj.calculate();
        double ex = 0;
        assertEquals(ex, ac, 0.01);
    }

    @Test
    public void addTest1() {
        Equation obj = new Equation(-1, -2, "-");
        double ac = obj.calculate();
        double ex = 1;
        assertEquals(ex, ac, 0.01);
    }

    @Test
    public void addTest2() {
        Equation obj = new Equation(1, 2, "-");
        double ac = obj.calculate();
        double ex = -1;
        assertEquals(ex, ac, 0.01);
    }

    @Test
    public void addTest3() {
        Equation obj = new Equation(3, -1, "-");
        double ac = obj.calculate();
        double ex = 4;
        assertEquals(ex, ac, 0.01);
    }

    @Test
    public void addTest4() {
        Equation obj = new Equation(-1, 3, "-");
        double ac = obj.calculate();
        double ex = -4;
        assertEquals(ex, ac, 0.01);
    }

    @Test
    public void addTest5() {
        Equation obj = new Equation(0, 0, "-");
        double ac = obj.calculate();
        double ex = -1;
        assertNotEquals(ex, ac, 0.01);
    }

    @Test
    public void addTest6() {
        Equation obj = new Equation(2, -1, "-");
        double ac = obj.calculate();
        double ex = 1;
        assertNotEquals(ex, ac, 0.01);
    }

    @Test
    public void addTest7() {
        Equation obj = new Equation(-2, 1, "-");
        double ac = obj.calculate();
        double ex = -1;
        assertNotEquals(ex, ac, 0.01);
    }

    @Test
    public void addTest8() {
        Equation obj = new Equation(-3, -1, "-");
        double ac = obj.calculate();
        double ex = -4;
        assertNotEquals(ex, ac, 0.01);
    }

    @Test
    public void addTest9() {
        Equation obj = new Equation(4, 6, "-");
        double ac = obj.calculate();
        double ex = 2;
        assertNotEquals(ex, ac, 0.01);
    }
}
