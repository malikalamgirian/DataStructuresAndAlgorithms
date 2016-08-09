/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructuresandalgorithms;

/**
 *
 * @author Wasif Altaf
 */
public class InsertionSort implements Sortable {

    public InsertionSort() {
    }

    public int[] sort(int[] array) {
        try {
            // key where swap is required
            int k;            
            for (int i = 0; i < array.length - 1; i++) {
                k = i;
                for (int j = k + 1; k >= 0 && array[k] > array[j]; j--, k--) {
                    // swap values using temp
                    int temp = array[j];
                    array[j] = array[k];
                    array[k] = temp;
                }
            }
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        return array;
    }
}
