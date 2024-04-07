/*
 * Lela Root 11/7/2023 Sorting
 * InPlaceInsertionSort - A sorting method that inserts each consecutive element into a sorted section of the array
 */

public class InPlaceInsertionSort<E extends Comparable<E>> implements Sorter<E> {

	/**
	 * Perform In-place insertion sort
	 * @param array - Array to sort
	 * 	 		K is a generic but comparable type.  
	*/
	
	public void sort(E[] array) {
		/* TCJ
		 * Worst case would require the algorithm to look through the entire sorted section for each insert, costing O(n^2)    
		 */

		for (int i = 1; i < array.length; i++) {
			E temp = array[i];
			int j = i - 1;
			
			while (j >= 0 && array[j].compareTo(temp) > 0) {
				array[j+1] = array[j];
				j--;
			}
			
			array[j+1] = temp;
		}
	}

}
