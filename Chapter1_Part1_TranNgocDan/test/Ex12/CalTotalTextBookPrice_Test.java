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
public class CalTotalTextBookPrice_Test {
    
    public CalTotalTextBookPrice_Test() {
    }
    
    
    //add 2 Textbook into collection
     @Test
     public void calTotalTextBookPrice_Test1(){
         TextBook tb1 = new TextBook("new", "123", "SGK", "1/1/1990", 25000, 10, "Nguyen Nhat Anh");
         TextBook tb2 = new TextBook("new", "123", "SGK", "1/1/1990", 12000, 10, "Nguyen Nhat Anh");
         BookCollection cl = new BookCollection();
         cl.addTextBook(tb1);
         cl.addTextBook(tb2);
         double ex = 370000;
         double ac = cl.calTotalTextBookPrice();
         assertEquals(ex, ac, 0.001);
     }
     
     //Dont add anything
     @Test
     public void calTotalTextBookPrice_Test2(){
         BookCollection cl = new BookCollection();
         double ex = 0;
         double ac = cl.calTotalTextBookPrice();
         assertEquals(ex, ac, 0.001);
     }
}
