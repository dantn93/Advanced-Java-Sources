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
public class AvgProducingRevenue_Test {
    
    public AvgProducingRevenue_Test() {
    }
    
    
    @Test
     public void avgTradingRevenue_Test1(){
         Producer pd1 = new Producer(2000, "ABC", 1.2, 2, 1200000);
         Producer pd2 = new Producer(3000, "ABC", 1.2, 2, 1200000);
         Producer pd3 = new Producer(3500, "ABC", 1.2, 2, 1200000);
         Company cpn = new Company();
         cpn.addProducer(pd1);
         cpn.addProducer(pd2);
         cpn.addProducer(pd3);
         double ex = 2712091.666;
         double ac = cpn.avgProducingRevenue();
         assertEquals(ex, ac, 0.001);
     }
     
     @Test
     public void avgTradingRevenue_Test2(){
         Company cpn = new Company();
         double ex = 0;
         double ac = cpn.avgProducingRevenue();
         assertEquals(ex, ac, 0.001);
     }
}
