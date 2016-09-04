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
public class CalTotalRefBookPrice_Test {
    
    public CalTotalRefBookPrice_Test() {
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
     public void calTotalRefBookPrice_Test1(){
         ReferenceBook rf1 = new ReferenceBook(0.05, "123", "ABC", "1/1/1993", 30000, 20, "Doan Van Quang");
         ReferenceBook rf2 = new ReferenceBook(0.05, "123", "ABC", "1/1/1993", 30000, 10, "Doan Van Quang");
         BookCollection cl = new BookCollection();
         cl.addRefBook(rf1);
         cl.addRefBook(rf2);
         double ex = 945000;
         double ac = cl.calTotalRefBookPrice();
         assertEquals(ex, ac, 0.001);
     }
     
     @Test
     public void calTotalRefBookPrice_Test2(){
         BookCollection cl = new BookCollection();
         double ex = 0;
         double ac = cl.calTotalRefBookPrice();
         assertEquals(ex, ac, 0.001);
     }
}
