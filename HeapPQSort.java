/*
 * Lela Root 11/7/2023 Sorting
 * HeapPQSort - Sorting an array using a heap priority queue
 */


public class HeapPQSort<E extends Comparable<E>> implements Sorter<E> {

	/**
	 * sort - Perform a PriorityQueue Sort using the heap implementation of PQ.
	 * @param array - Array to sort
	 * 			K is a generic but comparable type. 
	 */
	
	HeapAPQ<E, Integer> pq = new HeapAPQ<E, Integer>();
	
	public void sort(E[] array) {
		/* TCJ
		 * Inserting to heap APQ costs (amortized) log n each time, and we must do this n times, therefore O(n log n)
		 */


		for (int i = 0; i < array.length; i++) {
			pq.insert(array[i], null);
		}
		
		for (int i = 0; i < array.length; i++) {
			array[i] = pq.removeMin().getKey();
		}

	}

}
