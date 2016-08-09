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
public class MergeSortTest {

    public MergeSortTest() {
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
     * Test of sort method, of class MergeSort.
     */
    @Test
    public void testSort() {
        System.out.println("sort");
        int[] array = {6, 3, 7, 9, 4, 1, 3, 7, 1};
        int[] expResult = Arrays.copyOf(array, array.length);
        Arrays.sort(expResult);
        
        int[] result = new MergeSort().sort(array);

        assertArrayEquals(expResult, result);

        array = new int[10000];
        for (int i = 0; i < array.length; i++) {
            array[i] = new Random().nextInt(Integer.MAX_VALUE);
        }
        expResult = Arrays.copyOf(array, array.length);
        Arrays.sort(expResult);

        result = new MergeSort().sort(array);

        assertArrayEquals(expResult, result);
    }

    /**
     * Test of merge method, of class MergeSort.
     */
    @Test
    public void testMerge() {
        System.out.println("merge");
        int[] arrayA = {1, 3};
        int[] arrayB = {0, 2};
        MergeSort instance = new MergeSort();
        int[] expResult = {0,1,2,3};
        
        int[] result = instance.merge(arrayA, arrayB);
        
        assertArrayEquals(expResult, result);
        
        arrayA = new int[10222];
        arrayB = new int[10011];
        for (int i = 0; i < arrayA.length; i++) {
            arrayA[i] = new Random().nextInt(Integer.MAX_VALUE);
        }
        System.out.println(Arrays.toString(arrayA));
        for (int i = 0; i < arrayB.length; i++) {
            arrayB[i] = new Random().nextInt(Integer.MAX_VALUE);
        }
        System.out.println(Arrays.toString(arrayB));
        
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);
        
        expResult = Arrays.copyOf(arrayA, arrayA.length + arrayB.length);
        System.arraycopy(arrayB, 0, expResult, arrayA.length, arrayB.length);
        Arrays.sort(expResult);
        
        result = instance.merge(arrayA, arrayB);

        assertArrayEquals(expResult, result);
    }

   
}