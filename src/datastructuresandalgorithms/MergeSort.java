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
            int keyA = 0, keyB = 0;
            int pos = 0;

            while (pos < sortedArray.length) {
                // if keyA and keyB are intermediate
                if (keyA < arrayA.length - 1 && keyB < arrayB.length - 1) {
                    if (arrayA[keyA] > arrayB[keyB]) {
                        System.out.println("Putting " + arrayB[keyB] + " at " + pos);
                        sortedArray[pos] = arrayB[keyB];

                        ++keyB;
                        ++pos;
                    } else if (arrayA[keyA] <= arrayB[keyB]) {
                        System.out.println("Putting " + arrayA[keyA] + " at " + pos);
                        sortedArray[pos] = arrayA[keyA];

                        ++keyA;
                        ++pos;
                    }
                } // else if i is last element
                else if (keyA == arrayA.length - 1) {
                    if (arrayA[keyA] > arrayB[keyB]) {
                        System.out.println("Putting " + arrayB[keyB] + " at " + pos);
                        sortedArray[pos] = arrayB[keyB];
                        ++keyB;
                        ++pos;                        
                    } else if (arrayA[keyA] <= arrayB[keyB]) {
                        // append i
                        System.out.println("Putting " + arrayA[keyA] + " at " + pos);
                        sortedArray[pos] = arrayA[keyA];
                        ++keyA;
                        ++pos;

                        // append all j
                        while (keyB < arrayB.length) {
                            System.out.println("Putting " + arrayB[keyB] + " at " + pos);
                            sortedArray[pos] = arrayB[keyB];
                            ++keyB;
                            ++pos;
                        }
                    }
                } // else if j is last element
                else if (keyB == arrayB.length - 1) {
                    if (arrayA[keyA] > arrayB[keyB]) {
                        // append j
                        System.out.println("Putting " + arrayB[keyB] + " at " + pos);
                        sortedArray[pos] = arrayB[keyB];
                        ++keyB;
                        ++pos;

                        // append all i
                        while (keyA < arrayA.length) {
                            System.out.println("Putting " + arrayA[keyA] + " at " + pos);
                            sortedArray[pos] = arrayA[keyA];
                            ++keyA;
                            ++pos;
                        }
                    } else if (arrayA[keyA] <= arrayB[keyB]) {
                        System.out.println("Putting " + arrayA[keyA] + " at " + pos);
                        sortedArray[pos] = arrayA[keyA];
                        ++keyA;
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