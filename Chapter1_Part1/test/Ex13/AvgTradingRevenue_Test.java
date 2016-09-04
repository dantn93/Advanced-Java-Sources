/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex13;

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
public class AvgTradingRevenue_Test {
    
    public AvgTradingRevenue_Test() {
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
     public void avgTradingRevenue_Test1(){
         Trader trd1 = new Trader(12000000, 1.2, "ABC", 1.2, 2, 10000000);
         Trader trd2 = new Trader(90000000, 1.2, "ABC", 1.2, 2, 10000000);
         Trader trd3 = new Trader(10000000, 1.2, "ABC", 1.2, 2, 10000000);
         Company cpn = new Company();
         cpn.addTrader(trd1);
         cpn.addTrader(trd2);
         cpn.addTrader(trd3);
         double ex = Math.pow(10,7)*5.6312;
         double ac = cpn.avgTradingRevenue();
         assertEquals(ex, ac, 0.001);
     }
     
     @Test
     public void avgTradingRevenue_Test2(){
         Company cpn = new Company();
         double ex = 0;
         double ac = cpn.avgTradingRevenue();
         assertEquals(ex, ac, 0.001);
     }
}
