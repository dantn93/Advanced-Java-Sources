package Ex4_Test;

import Ex4.Employee;
import Ex4.StaffManagementDemo;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Tran Ngoc Dan
 * @since 19/09/2016
 * @version 1.0
 */
public class calAverageAgeTest {

    public calAverageAgeTest() {
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

    //calculate average age of all of employee
    @Test
    public void calAverageAge1() {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee("employee1", 25, 30000));
        list.add(new Employee("employee1", 32, 30000));
        list.add(new Employee("employee1", 30, 30000));
        list.add(new Employee("employee1", 50, 30000));
        double ex = StaffManagementDemo.calAverageAge(list);
        double ac = 34.25;
        assertEquals(ex, ac, 0.01);

    }

    //calculate average age of all of employee
    @Test
    public void calAverageAge2() {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee("employee1", 25, 30000));
        double ex = StaffManagementDemo.calAverageAge(list);
        double ac = 25.0;
        assertEquals(ex, ac, 0.01);

    }

    //calculate average age of all of employee
    @Test
    public void calAverageAge3() {
        List<Employee> list = new ArrayList<>();
        double ex = StaffManagementDemo.calAverageAge(list);
        double ac = 0;
        assertEquals(ex, ac, 0.01);

    }

    //calculate average age of all of employee
    @Test
    public void calAverageAge4() {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee("employee1", 25, 30000));
        list.add(new Employee("employee1", 32, 30000));
        list.add(new Employee("employee1", 30, 30000));
        list.add(new Employee("employee1", 50, 30000));
        list.add(new Employee("employee1", 39, 30000));
        list.add(new Employee("employee1", 50, 30000));
        list.add(new Employee("employee1", 35, 30000));
        list.add(new Employee("employee1", 27, 30000));
        list.add(new Employee("employee1", 46, 30000));
        double ex = StaffManagementDemo.calAverageAge(list);
        double ac = 37.11;
        assertEquals(ex, ac, 0.01);

    }

    //calculate average age of all of employee
    @Test
    public void calAverageAge5() {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee("employee1", 25, 30000));
        list.add(new Employee("employee1", 32, 30000));
        list.add(new Employee("employee1", 30, 30000));
        list.add(new Employee("employee1", 50, 30000));
        double ex = StaffManagementDemo.calAverageAge(list);
        double ac = 34.25;
        assertEquals(ex, ac, 0.01);

    }

    //calculate average age of all of employee
    @Test
    public void calAverageAge6() {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee("employee1", 25, 30000));
        list.add(new Employee("employee1", 25, 30000));
        list.add(new Employee("employee1", 25, 30000));
        list.add(new Employee("employee1", 25, 30000));
        double ex = StaffManagementDemo.calAverageAge(list);
        double ac = 25;
        assertEquals(ex, ac, 0.01);

    }
}
