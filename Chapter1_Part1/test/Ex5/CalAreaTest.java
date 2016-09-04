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
public class CalAreaTest {

    Rectangle rectangle;

    @Test
    public void testCalArea1() {
        rectangle = new Rectangle(new Point(0,0), new Point(1, 1));
        double ex = 1;
        double ac = rectangle.calArea();
        assertEquals(ex, ac, 0.001);
    }

    @Test
    public void testCalArea2() {
        rectangle = new Rectangle(new Point(0,0), new Point(0, 0));
        double ex = 0;
        double ac = rectangle.calArea();
        assertEquals(ex, ac, 0.001);
    }

    @Test
    public void testCalArea3() {
        rectangle = new Rectangle(new Point(0,0), new Point(2, 3));
        double ex = 6;
        double ac = rectangle.calArea();
        assertEquals(ex, ac, 0.001);
    }

    @Test
    public void testCalArea4() {
        rectangle = new Rectangle(new Point(0,0), new Point(2, 2));
        double ex = 4;
        double ac = rectangle.calArea();
        assertEquals(ex, ac, 0.001);
    }

    @Test
    public void testCalArea5() {
        rectangle = new Rectangle(new Point(0,0), new Point(3, 1));
        double ex = 3;
        double ac = rectangle.calArea();
        assertEquals(ex, ac, 0.001);
    }

    @Test
    public void testCalArea6() {
        rectangle = new Rectangle(new Point(0,0), new Point(1, 1));
        double ex = 2;
        double ac = rectangle.calArea();
        assertNotEquals(ex, ac, 0.001);
    }

    @Test
    public void testCalArea7() {
        rectangle = new Rectangle(new Point(0,0), new Point(1, 2));
        double ex = 4;
        double ac = rectangle.calArea();
        assertNotEquals(ex, ac, 0.001);
    }

    @Test
    public void testCalArea8() {
        rectangle = new Rectangle(new Point(0,0), new Point(2, 3));
        double ex = 8;
        double ac = rectangle.calArea();
        assertNotEquals(ex, ac, 0.001);
    }

    @Test
    public void testCalArea9() {
        rectangle = new Rectangle(new Point(0,0), new Point(3, 2));
        double ex = 5;
        double ac = rectangle.calArea();
        assertNotEquals(ex, ac, 0.001);
    }

    @Test
    public void testCalArea10() {
        rectangle = new Rectangle(new Point(0,0), new Point(0, 0));
        double ex = 1;
        double ac = rectangle.calArea();
        assertNotEquals(ex, ac, 0.001);
    }
}
