package Ex1;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Ex1.LinearEquation;
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
public class findSolutionTest {

    public findSolutionTest() {
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
    public void findSolutionTest0() {
        LinearEquation eq = new LinearEquation(0, 0); //infinite solutions
        double[] ex = new double[]{1, 1, 0};
        double[] ac = eq.findSolution();
        assertArrayEquals(ex, ac, 0.01);
    }

    public void findSolutionTest1() {
        LinearEquation eq = new LinearEquation(1, 1); //one solutions
        double[] ex = new double[]{1, 0, -1};
        double[] ac = eq.findSolution();
        assertArrayEquals(ex, ac, 0.01);
    }

    public void findSolutionTest2() {
        LinearEquation eq = new LinearEquation(0, 1); //no solutions
        double[] ex = new double[]{0, 0, 0};
        double[] ac = eq.findSolution();
        assertArrayEquals(ex, ac, 0.01);
    }

}
