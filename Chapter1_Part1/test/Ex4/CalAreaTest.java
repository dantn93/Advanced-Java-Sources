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
public class CalAreaTest {

    Circle circle;

    @Test
    public void testCalArea1() {
        circle = new Circle(0);
        double ex = 0;
        double ac = circle.calArea();
        assertEquals(ex, ac, 0.001);
    }

    @Test
    public void testCalArea2() {
        circle = new Circle(1);
        double ex = 3.1415;
        double ac = circle.calArea();
        assertEquals(ex, ac, 0.01);
    }

    @Test
    public void testCalArea3() {
        circle = new Circle(2);
        double ex = 12.566;
        double ac = circle.calArea();
        assertEquals(ex, ac, 0.01);
    }

    @Test
    public void testCalArea4() {
        circle = new Circle(2.5);
        double ex = 19.634;
        double ac = circle.calArea();
        assertEquals(ex, ac, 0.01);
    }

    @Test
    public void testCalArea5() {
        circle = new Circle(1.2);
        double ex = 4.52376;
        double ac = circle.calArea();
        assertEquals(ex, ac, 0.01);
    }

    @Test
    public void testCalArea6() {
        circle = new Circle(1.2);
        double ex = 7.5;
        double ac = circle.calArea();
        assertNotEquals(ex, ac, 0.01);
    }

    @Test
    public void testCalArea7() {
        circle = new Circle(1);
        double ex = 3.2;
        double ac = circle.calArea();
        assertNotEquals(ex, ac, 0.01);
    }

    @Test
    public void testCalArea8() {
        circle = new Circle(2);
        double ex = 12.5;
        double ac = circle.calArea();
        assertNotEquals(ex, ac, 0.01);
    }

    @Test
    public void testCalArea9() {
        circle = new Circle(0);
        double ex = -1;
        double ac = circle.calArea();
        assertNotEquals(ex, ac, 0.01);
    }

    @Test
    public void testCalArea10() {
        circle = new Circle(9);
        double ex = 9;
        double ac = circle.calArea();
        assertNotEquals(ex, ac, 0.01);
    }
}
