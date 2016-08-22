/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex5;

import Ex3.Point;
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

    Rectangle rectangle;

    @Test
    public void testCalCircumference1() {
        rectangle = new Rectangle(new Point(0,0), new Point(1, 1));
        double ex = 4;
        double ac = rectangle.calPerimeter();
        assertEquals(ex, ac, 0.001);
    }

    @Test
    public void testCalCircumference2() {
        rectangle = new Rectangle(new Point(0,0), new Point(0, 0));
        double ex = 0;
        double ac = rectangle.calPerimeter();
        assertEquals(ex, ac, 0.001);
    }

    @Test
    public void testCalCircumference3() {
        rectangle = new Rectangle(new Point(0,0), new Point(2, 3));
        double ex = 10;
        double ac = rectangle.calPerimeter();
        assertEquals(ex, ac, 0.001);
    }

    @Test
    public void testCalCircumference4() {
        rectangle = new Rectangle(new Point(0,0), new Point(2, 2));
        double ex = 8;
        double ac = rectangle.calPerimeter();
        assertEquals(ex, ac, 0.001);
    }

    @Test
    public void testCalCircumference5() {
        rectangle = new Rectangle(new Point(0,0), new Point(3, 1));
        double ex = 8;
        double ac = rectangle.calPerimeter();
        assertEquals(ex, ac, 0.001);
    }

    @Test
    public void testCalCircumference6() {
        rectangle = new Rectangle(new Point(0,0), new Point(1, 1));
        double ex = 2;
        double ac = rectangle.calPerimeter();
        assertNotEquals(ex, ac, 0.001);
    }

    @Test
    public void testCalCircumference7() {
        rectangle = new Rectangle(new Point(0,0), new Point(1, 2));
        double ex = 4;
        double ac = rectangle.calPerimeter();
        assertNotEquals(ex, ac, 0.001);
    }

    @Test
    public void testCalCircumference8() {
        rectangle = new Rectangle(new Point(0,0), new Point(2, 3));
        double ex = 8;
        double ac = rectangle.calPerimeter();
        assertNotEquals(ex, ac, 0.001);
    }

    @Test
    public void testCalCircumference9() {
        rectangle = new Rectangle(new Point(0,0), new Point(3, 2));
        double ex = 5;
        double ac = rectangle.calPerimeter();
        assertNotEquals(ex, ac, 0.001);
    }

    @Test
    public void testCalCircumference10() {
        rectangle = new Rectangle(new Point(0,0), new Point(0, 0));
        double ex = 1;
        double ac = rectangle.calPerimeter();
        assertNotEquals(ex, ac, 0.001);
    }
}
