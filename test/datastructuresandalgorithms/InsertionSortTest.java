/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructuresandalgorithms;

import java.util.Arrays;
import java.util.Random;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Wasif Altaf
 */
public class InsertionSortTest {

    public InsertionSortTest() {
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

    /**
     * Test of sort method, of class InsertionSort.
     */
    @Test
    public void testSort() {
        System.out.println("sort");
        int[] array = {6, 3, 7, 9, 4, 1, 3, 7, 0};
        int[] expResult = {0, 1, 3, 3, 4, 6, 7, 7, 9};

        int[] result = new InsertionSort().sort(array);

        assertArrayEquals(expResult, result);
        
        array = new int[10000];
        for (int i = 0; i < array.length; i++) {
            array[i] = new Random().nextInt(Integer.MAX_VALUE);
        }
        expResult = Arrays.copyOf(array, array.length);
        Arrays.sort(expResult);
        
        result = new InsertionSort().sort(array);

        assertArrayEquals(expResult, result);
    }
}
