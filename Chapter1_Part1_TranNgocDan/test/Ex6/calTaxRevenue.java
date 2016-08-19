/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex6;

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
public class calTaxRevenue {

    double subRevenue = 9000000;
    double base = 3600000;

    @Test
    public void testCalPersonalTaxes1() {
        Employee employee = new Employee("A", 2.67, 1, 12000000);

        double ex = employee.calRevenue() - subRevenue - employee.getSub_num() * base;
        double ac = employee.calTaxRevenue();
        assertEquals(ex, ac, 0);
    }

    @Test
    public void testCalPersonalTaxes2() {
        Employee employee = new Employee("A", 5, 2, 15000000);
        double ex = employee.calRevenue() - subRevenue - employee.getSub_num() * base;
        double ac = employee.calTaxRevenue();
        assertEquals(ex, ac, 0);
    }

    //
    @Test
    public void testCalPersonalTaxes3() {
        Employee employee = new Employee("A", 7, 2, 12000000);
        double ac = employee.calTaxRevenue();

        double ex = employee.calRevenue() - subRevenue - employee.getSub_num() * base;
        assertEquals(ex, ac, 0);
    }

    @Test
    public void testCalPersonalTaxes4() {
        Employee employee = new Employee("A", 4.5, 3, 15000000);
        double ac = employee.calTaxRevenue();

        double ex = employee.calRevenue() - subRevenue - employee.getSub_num() * base;
        assertEquals(ex, ac, 0);
    }

    @Test
    public void testCalPersonalTaxes5() {
        Employee employee = new Employee("A", 5, 3, 20000000);
        double ac = employee.calTaxRevenue();

        double ex = employee.calRevenue() - subRevenue - employee.getSub_num() * base;
        assertEquals(ex, ac, 0);
    }

    @Test
    public void testCalPersonalTaxes6() {
        Employee employee = new Employee("A", 0, 2, 13000000);
        double ac = employee.calTaxRevenue();

        double ex = employee.calRevenue() - subRevenue - employee.getSub_num() * base;
        assertNotEquals(ex, ac, 0);
    }

    @Test
    public void testCalPersonalTaxes7() {
        Employee employee = new Employee("A", 2.3, 0, 1000000);
        double ac = employee.calTaxRevenue();

        double ex = employee.calRevenue() - subRevenue - employee.getSub_num() * base;
        assertNotEquals(ex, ac, 0);
    }

    @Test
    public void testCalPersonalTaxes8() {
        Employee employee = new Employee("A", 3, 2, 1000000);
        double ac = employee.calTaxRevenue();

        double ex = employee.calRevenue() - subRevenue - employee.getSub_num() * base;
        assertNotEquals(ex, ac, 0);
    }

    @Test
    public void testCalPersonalTaxes9() {
        Employee employee = new Employee("A", 4, 1, 1000000);
        double ac = employee.calTaxRevenue();

        double ex = employee.calRevenue() - subRevenue - employee.getSub_num() * base;
        assertNotEquals(ex, ac, 0);
    }

    @Test
    public void testCalPersonalTaxes10() {
        Employee employee = new Employee("A", 1.2, 7, 10000000);
        double ac = employee.calTaxRevenue();

        double ex = employee.calRevenue() - subRevenue - employee.getSub_num() * base;
        assertNotEquals(ex, ac, 0);
    }
}
