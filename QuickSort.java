/*
 * Lela Root 11/7/2023 Sorting
 * QuickSort - Sorting method that uses the divide and conquer technique to split up the array into sorted partitions
 */


public class QuickSort<E extends Comparable<E>> implements Sorter<E> {
	
	/*
	 * Helper method - swaps two elements
	 * Input: the array, the first index and the second index
	 */
	public void swap(E[]array, int index1, int index2) {
		E temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}
	
	/*
	 * Helper method - sorts the partition based on the pivot and then returns the new index of the pivot
	 * Input: The array and the index bounds p and q of the partition, where q becomes the pivot
	 */
	public int partition(E[] array, int p, int q) {
		E pivot = array[q];
		int i = p;
		int j = q-1;
		
		while(i <= j) {
			while(i <= j && array[i].compareTo(pivot) < 0) {
				i++;
			}
			while(i <= j && array[j].compareTo(pivot) > 0) {
				j--;
			}
			if (i <= j) {
				swap(array, i, j);
				i++;
				j--;
			}
			
		}
		
		swap(array, i, q);
		return i;
	}
	
	/*
	 * Helper method - recursively creates new partitions with new pivots until the partition becomes one element because the pivot is in the right spot and the array is sorted
	 * Input: The array of size n, and partition bounds p & q
	 */
	public void quickSort(E[] array, int n, int p, int q) {
		
		if (p < q) {
			int r = partition(array, p, q);
			
		
			quickSort(array, n, p, r-1);
			
			quickSort(array, n, r+1, q);
		}
		
	}
	
	/**
	 * Perform QuickSort 
	 * @param array - Array to sort 
	 * 			E is a generic, but comparable type. 
	 */	
	public void sort(E[] array) {
		/* TCJ
		 * In the worst case, you start with a bad pivot that is a relatively large or small number, making n partitions requiring n comparisons.
		 * In the expected time, a more reasonable pivot will make approximately log n partitions requiring n comparisons.
		 */

		quickSort(array, array.length, 0, array.length - 1);

	}
}
