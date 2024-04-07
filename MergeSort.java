/*
 * Lela Root 11/7/2023 Sorting
 * MergeSort - Sorting method using the divide and conquer technique, where the array contents are split until only one element is left,
 * and then are merged back together into a sorted array
 */


import java.util.Arrays;

public class MergeSort<E extends Comparable<E>> implements Sorter<E> {
	
	/*
	 * Helper method - merges two sorted arrays together into one sorted array
	 * Input: array a1 with size n1, array a2 with size n2, and the finished array with size n
	 */
	public void merge(E[] a1, int n1, E[] a2, int n2, E[] array, int n) {
		
		int l = 0;
		int m = 0;
		
		for (int i = 0; i < n; i++) {
			if (m == n2 || (l < n1 && (a1[l].compareTo(a2[m]) <= 0))) {
				array[i] = a1[l];
				l++;
			} else {
				array[i] = a2[m];
				m++;
			}
		}
		
	}
	
	/**
	 * Perform MergeSort
	 * @param array - Array to sort
	 * 			K is a generic but comparable type. 
	 */
	public void sort(E[] array) {
		/* TCJ
		 * After dividing up the data, you must do n comparisons log n times to merge it back together sorted   
		 */

		int n = array.length;
		
		if (n < 2) { return; }
		
		int mid = n/2;
		E[] left = (E[]) new Comparable[mid];
		E[] right = (E[]) new Comparable[mid];
		
		left = Arrays.copyOfRange(array, 0, mid);
		right = Arrays.copyOfRange(array, mid, n);
		
		sort(left);
		sort(right);
		
		merge(left, left.length, right, right.length, array, array.length);

	}
}

