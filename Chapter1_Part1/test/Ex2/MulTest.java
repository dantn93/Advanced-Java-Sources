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
public class MulTest {

    public MulTest() {
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
    public void mulTest0() {
        Equation obj = new Equation(0, 0, "*");
        double ac = obj.calculate();
        double ex = 0;
        assertEquals(ex, ac, 0.01);
    }

    @Test
    public void mulTest1() {
        Equation obj = new Equation(-1, -2, "*");
        double ac = obj.calculate();
        double ex = 2;
        assertEquals(ex, ac, 0.01);
    }

    @Test
    public void mulTest2() {
        Equation obj = new Equation(1, 2, "*");
        double ac = obj.calculate();
        double ex = 2;
        assertEquals(ex, ac, 0.01);
    }

    @Test
    public void mulTest3() {
        Equation obj = new Equation(3, -1, "*");
        double ac = obj.calculate();
        double ex = -3;
        assertEquals(ex, ac, 0.01);
    }

    @Test
    public void mulTest4() {
        Equation obj = new Equation(-1, 3, "*");
        double ac = obj.calculate();
        double ex = -3;
        assertEquals(ex, ac, 0.01);
    }

    @Test
    public void mulTest5() {
        Equation obj = new Equation(0, 0, "*");
        double ac = obj.calculate();
        double ex = -1;
        assertNotEquals(ex, ac, 0.01);
    }

    @Test
    public void mulTest6() {
        Equation obj = new Equation(2, -1, "*");
        double ac = obj.calculate();
        double ex = 2;
        assertNotEquals(ex, ac, 0.01);
    }

    @Test
    public void mulTest7() {
        Equation obj = new Equation(-2, 1, "*");
        double ac = obj.calculate();
        double ex = 2;
        assertNotEquals(ex, ac, 0.01);
    }

    @Test
    public void mulTest8() {
        Equation obj = new Equation(-3, -1, "*");
        double ac = obj.calculate();
        double ex = -3;
        assertNotEquals(ex, ac, 0.01);
    }

    @Test
    public void mulTest9() {
        Equation obj = new Equation(4, 6, "*");
        double ac = obj.calculate();
        double ex = 30;
        assertNotEquals(ex, ac, 0.01);
    }
}
