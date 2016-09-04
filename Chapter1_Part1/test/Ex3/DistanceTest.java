/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex3;

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
public class DistanceTest {

    Point pointA;
    Point pointB;

    @Test
    public void testCalDistance1() {
        pointA = new Point(0, 0);
        pointB = new Point(0, 0);
        Distance d = new Distance(pointA, pointB);
        double ex = 0;
        double ac = d.calDistance();
        assertEquals(ex, ac, 0.001);
    }

    @Test
    public void testCalDistance2() {
        pointA = new Point(1, 3);
        pointB = new Point(2, 4);

        Distance d = new Distance(pointA, pointB);

        double ex = 1.4142;
        double ac = d.calDistance();
        assertEquals(ex, ac, 0.001);
    }

    @Test
    public void testCalDistance3() {
        pointA = new Point(4, 5);
        pointB = new Point(8, 9);

        Distance d = new Distance(pointA, pointB);

        double ex = 5.657;
        double ac = d.calDistance();
        assertEquals(ex, ac, 0.001);
    }

    @Test
    public void testCalDistance4() {
        pointA = new Point(-1, -1);
        pointB = new Point(-3, -3);

        Distance d = new Distance(pointA, pointB);

        double ex = 2.828;
        double ac = d.calDistance();
        assertEquals(ex, ac, 0.001);
    }

    @Test
    public void testCalDistance5() {
        pointA = new Point(-1, -1);
        pointB = new Point(3, 3);

        Distance d = new Distance(pointA, pointB);

        double ex = 5.657;
        double ac = d.calDistance();
        assertEquals(ex, ac, 0.001);
    }

    @Test
    public void testCalDistance6() {
        pointA = new Point(0, 0);
        pointB = new Point(0, 0);

        Distance d = new Distance(pointA, pointB);

        double ex = -1;
        double ac = d.calDistance();
        assertNotEquals(ex, ac, 0.001);
    }

    @Test
    public void testCalDistance7() {
        pointA = new Point(1, -1);
        pointB = new Point(-3, 3);

        Distance d = new Distance(pointA, pointB);

        double ex = 32;
        double ac = d.calDistance();
        assertNotEquals(ex, ac, 0.001);
    }

    @Test
    public void testCalDistance8() {
        pointA = new Point(1, 3);
        pointB = new Point(1, 3);

        Distance d = new Distance(pointA, pointB);

        double ex = 1;
        double ac = d.calDistance();
        assertNotEquals(ex, ac, 0.001);
    }

    @Test
    public void testCalDistance9() {
        pointA = new Point(1, 1);
        pointB = new Point(2, 2);

        Distance d = new Distance(pointA, pointB);

        double ex = 1;
        double ac = d.calDistance();
        assertNotEquals(ex, ac, 0.001);
    }

    @Test
    public void testCalDistance10() {
        pointA = new Point(1, 3);
        pointB = new Point(2, 4);

        Distance d = new Distance(pointA, pointB);

        double ex = 1.4;
        double ac = d.calDistance();
        assertNotEquals(ex, ac, 0.001);
    }
}
