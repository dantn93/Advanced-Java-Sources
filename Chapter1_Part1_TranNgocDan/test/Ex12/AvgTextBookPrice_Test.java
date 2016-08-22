/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex12;

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
public class AvgTextBookPrice_Test {
    
    public AvgTextBookPrice_Test() {
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
     public void avgTextBookPrice_Test1(){
         TextBook tb1 = new TextBook("new", "123", "SGK", "1/1/1990", 25000, 10, "Nguyen Nhat Anh");
         TextBook tb2 = new TextBook("new", "123", "SGK", "1/1/1990", 12000, 10, "Nguyen Nhat Anh");
         BookCollection cl = new BookCollection();
         cl.addTextBook(tb1);
         cl.addTextBook(tb2);
         double ex = 185000;
         double ac = cl.avgTextBookPrice();
         assertEquals(ex, ac, 0.001);
     }
     
     @Test
     public void avgTextBookPrice_Test2(){
         BookCollection cl = new BookCollection();
         double ex = 0;
         double ac = cl.avgTextBookPrice();
         assertEquals(ex, ac, 0.001);
     }
}
