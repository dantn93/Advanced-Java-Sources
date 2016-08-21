/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex4;

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
public class CalPerimeterTest {

    Circle circle;

    @Test
    public void testCalCircumference1() {
        circle = new Circle(0);
        double ex = 0;
        double ac = circle.calPerimeter();
        assertEquals(ex, ac, 0.01);
    }

    @Test
    public void testCalCircumference2() {
        circle = new Circle(1);
        double ex = 6.283;
        double ac = circle.calPerimeter();
        assertEquals(ex, ac, 0.01);
    }

    @Test
    public void testCalCircumference3() {
        circle = new Circle(2);
        double ex = 12.566;
        double ac = circle.calPerimeter();
        assertEquals(ex, ac, 0.01);
    }

    @Test
    public void testCalCircumference4() {
        circle = new Circle(2.5);
        double ex = 15.7075;
        double ac = circle.calPerimeter();
        assertEquals(ex, ac, 0.01);
    }

    @Test
    public void testCalCircumference5() {
        circle = new Circle(1.2);
        double ex = 7.5396;
        double ac = circle.calPerimeter();
        assertEquals(ex, ac, 0.01);
    }

    @Test
    public void testCalCircumference6() {
        circle = new Circle(1.2);
        double ex = 7.5;
        double ac = circle.calPerimeter();
        assertNotEquals(ex, ac, 0.01);
    }

    @Test
    public void testCalCircumference7() {
        circle = new Circle(1);
        double ex = 3.14;
        double ac = circle.calPerimeter();
        assertNotEquals(ex, ac, 0.01);
    }

    @Test
    public void testCalCircumference8() {
        circle = new Circle(2);
        double ex = 12.5;
        double ac = circle.calPerimeter();
        assertNotEquals(ex, ac, 0.01);
    }

    @Test
    public void testCalCircumference9() {
        circle = new Circle(0);
        double ex = -1;
        double ac = circle.calPerimeter();
        assertNotEquals(ex, ac, 0.01);
    }

    @Test
    public void testCalCircumference10() {
        circle = new Circle(9);
        double ex = 9;
        double ac = circle.calPerimeter();
        assertNotEquals(ex, ac, 0.01);
    }

}
