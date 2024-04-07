/*
 * Lela Root 11/7/23 Sorting
 * InPlaceSelectionSort - Sorting method involving searching through the array for the smallest value, moving it to the front, and repeating
 */

public class InPlaceSelectionSort<E extends Comparable<E>> implements Sorter<E> {

	/*
	 * Helper method - swaps two elements
	 * Input: the array, the first index and the second index
	 */
	public void swap(E[]array, int index1, int index2) {
		E temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}
	
	/**
	 * Perform In-place selection sort
	 * @param array - Array to sort
	 * 			K is a generic but comparable type. 
	 */
	public void sort(E[] array) {
		/* TCJ
		 * Worst case and best case are no different. Algorithm compares n elements n times, costing O(n^2)
		 */

		for (int i = 0; i < array.length - 1; i++) {
			int minIndex = i;
			
			for (int j = i + 1; j < array.length; j++) {
				if (array[j].compareTo(array[minIndex]) < 0) {
					minIndex = j;
				}
			}
			
			if (minIndex != i) {
				swap(array, i, minIndex);
			}
		}

	}

}
