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
        int[] sortedArray = {};
        int[] arrayA, arrayB;
        try {
            if (array.length < 2) {
                return array;
            } else if (array.length % 2 == 0) {
                arrayA = Arrays.copyOfRange(array, 0, array.length / 2);
                arrayB = Arrays.copyOfRange(array, (array.length / 2), array.length);

            } else {
                arrayA = Arrays.copyOfRange(array, 0, (array.length - 1) / 2);
                arrayB = Arrays.copyOfRange(array, (array.length - 1) / 2, array.length);
            }

            arrayA = sort(arrayA);
            arrayB = sort(arrayB);
            sortedArray = merge(arrayA, arrayB);
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        return sortedArray;
    }

    public int[] merge(int[] arrayA, int[] arrayB) {
        int[] sortedArray = new int[arrayA.length + arrayB.length];

        try {
            int keyA = 0, keyB = 0;
            int pos = 0;

            while (pos < sortedArray.length) {
                // if keyA is valid element
                if (keyA <= arrayA.length - 1) {
                    // keyB is also valid and value at keyB is smaller
                    if (keyB <= arrayB.length - 1 && arrayA[keyA] > arrayB[keyB]) {
                        sortedArray[pos] = arrayB[keyB];
                        ++keyB;
                        ++pos;
                    } // keyB is also valid and value at keyA is less than or equal to value at keyB
                    else if (keyB <= arrayB.length - 1 && arrayA[keyA] <= arrayB[keyB]) {
                        // append keyA
                        sortedArray[pos] = arrayA[keyA];
                        ++keyA;
                        ++pos;
                    } else {
                        // append keyA because keyB is not valid
                        sortedArray[pos] = arrayA[keyA];
                        ++keyA;
                        ++pos;
                    }
                } // else if keyB is valid element
                else if (keyB <= arrayB.length - 1) {
                    // append kayB
                    sortedArray[pos] = arrayB[keyB];
                    ++keyB;
                    ++pos;
                }
            }
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        return sortedArray;
    }
}
