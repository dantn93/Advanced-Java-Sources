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
 * @author Tran Ngoc Dan
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

    @Test
    public void findSolutionTest1() {
        LinearEquation eq = new LinearEquation(1, 1); //one solutions
        double[] ex = new double[]{1, 0, -1};
        double[] ac = eq.findSolution();
        assertArrayEquals(ex, ac, 0.01);
    }

    @Test
    public void findSolutionTest2() {
        LinearEquation eq = new LinearEquation(0, 1); //no solutions
        double[] ex = new double[]{0, 0, 0};
        double[] ac = eq.findSolution();
        assertArrayEquals(ex, ac, 0.01);
    }

    @Test
    public void findSolutionTest3() {
        LinearEquation eq = new LinearEquation(3, 1); 
        double[] ex = new double[]{1, 0, -0.33};
        double[] ac = eq.findSolution();
        assertArrayEquals(ex, ac, 0.01);
    }

    @Test
    public void findSolutionTest4() {
        LinearEquation eq = new LinearEquation(2, 6); 
        double[] ex = new double[]{1, 0, -3};
        double[] ac = eq.findSolution();
        assertArrayEquals(ex, ac, 0.01);
    }

    @Test
    public void findSolutionTest5() {
        LinearEquation eq = new LinearEquation(1, 4); 
        double[] ex = new double[]{1, 0, -4};
        double[] ac = eq.findSolution();
        assertArrayEquals(ex, ac, 0.01);
    }

    @Test
    public void findSolutionTest6() {
        LinearEquation eq = new LinearEquation(3, -1); 
        double[] ex = new double[]{1, 0, 0.33};
        double[] ac = eq.findSolution();
        assertArrayEquals(ex, ac, 0.01);
    }

    @Test
    public void findSolutionTest7() {
        LinearEquation eq = new LinearEquation(5, 7); 
        double[] ex = new double[]{1, 0, -1.4};
        double[] ac = eq.findSolution();
        assertArrayEquals(ex, ac, 0.01);
    }

    @Test
    public void findSolutionTest8() {
        LinearEquation eq = new LinearEquation(0, 2); 
        double[] ex = new double[]{0, 0, 0};
        double[] ac = eq.findSolution();
        assertArrayEquals(ex, ac, 0.01);
    }

    @Test
    public void findSolutionTest9() {
        LinearEquation eq = new LinearEquation(1, 3); 
        double[] ex = new double[]{1, 0, -3};
        double[] ac = eq.findSolution();
        assertArrayEquals(ex, ac, 0.01);
    }

}
