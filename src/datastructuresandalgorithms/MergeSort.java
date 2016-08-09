/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructuresandalgorithms;

import java.util.Arrays;

/**
 *
 * @author Wasif Altaf
 */
public class MergeSort implements Sortable {

    public MergeSort() {
    }

    @Override
    public int[] sort(int[] array) {
        int[] sortedArray;

        try {
            if (array.length < 2) {
                return array;
            } else if (array.length % 2 == 0) {
                int[] arrayA = Arrays.copyOfRange(array, 0, array.length / 2);
                int[] arrayB = Arrays.copyOfRange(array, (array.length / 2), array.length);

                System.out.println(Arrays.toString(arrayA));
                System.out.println(Arrays.toString(arrayB));

                arrayA = sort(arrayA);
                arrayB = sort(arrayB);

                System.out.println(Arrays.toString(arrayA));
                System.out.println(Arrays.toString(arrayB));
                sortedArray = merge(arrayA, arrayB);
            } else {
                int[] arrayA = Arrays.copyOfRange(array, 0, (array.length - 1) / 2);
                int[] arrayB = Arrays.copyOfRange(array, (array.length - 1) / 2, array.length);

                System.out.println(Arrays.toString(arrayA));
                System.out.println(Arrays.toString(arrayB));

                arrayA = sort(arrayA);
                arrayB = sort(arrayB);

                sortedArray = merge(arrayA, arrayB);
            }
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        return array;
    }

    public int[] merge(int[] arrayA, int[] arrayB) {
        int[] sortedArray = new int[arrayA.length + arrayB.length];

        try {
            int i = 0, j = 0;
            int pos = 0;

            while (pos < sortedArray.length) {
                // if i and j are intermediate
                if (i < arrayA.length - 1 && j < arrayB.length - 1) {
                    if (arrayA[i] > arrayB[j]) {
                        System.out.println("Putting " + arrayB[j] + " at " + pos);
                        sortedArray[pos] = arrayB[j];

                        ++j;
                        ++pos;
                    } else if (arrayA[i] <= arrayB[j]) {
                        System.out.println("Putting " + arrayA[i] + " at " + pos);
                        sortedArray[pos] = arrayA[i];

                        ++i;
                        ++pos;
                    }
                } // else if i is last element
                else if (i == arrayA.length - 1) {
                    if (arrayA[i] > arrayB[j]) {
                        System.out.println("Putting " + arrayB[j] + " at " + pos);
                        sortedArray[pos] = arrayB[j];
                        ++j;
                        ++pos;                        
                    } else if (arrayA[i] <= arrayB[j]) {
                        // append i
                        System.out.println("Putting " + arrayA[i] + " at " + pos);
                        sortedArray[pos] = arrayA[i];
                        ++i;
                        ++pos;

                        // append all j
                        while (j < arrayB.length) {
                            System.out.println("Putting " + arrayB[j] + " at " + pos);
                            sortedArray[pos] = arrayB[j];
                            ++j;
                            ++pos;
                        }
                    }
                } // else if j is last element
                else if (j == arrayB.length - 1) {
                    if (arrayA[i] > arrayB[j]) {
                        // append j
                        System.out.println("Putting " + arrayB[j] + " at " + pos);
                        sortedArray[pos] = arrayB[j];
                        ++j;
                        ++pos;

                        // append all i
                        while (i < arrayA.length) {
                            System.out.println("Putting " + arrayA[i] + " at " + pos);
                            sortedArray[pos] = arrayA[i];
                            ++i;
                            ++pos;
                        }
                    } else if (arrayA[i] <= arrayB[j]) {
                        System.out.println("Putting " + arrayA[i] + " at " + pos);
                        sortedArray[pos] = arrayA[i];
                        ++i;
                        ++pos;
                    }
                }
            }
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        return sortedArray;
    }
}