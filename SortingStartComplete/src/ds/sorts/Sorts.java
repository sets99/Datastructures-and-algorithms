package ds.sorts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Sorts {
	@FunctionalInterface
	interface Sort<Item extends Comparable<Item>> {

	    public void sortList(ArrayList<Item> sortMe);
	}
	@FunctionalInterface
	interface SortCompare<Item> {

	    public void sortList(ArrayList<Item> sortMe, Comparator<Item> comparator);
	}
	// add code to sort list using insertion sort
	// use comparator.compare(item1, item2) for comparisons
	// Collections.swap(list, index1, index2); may be helpful to move items in the
	// list
	public static <Item> void librarySort(ArrayList<Item> sort, Comparator<Item> comparator) {
		Collections.sort(sort, comparator);
	}

	// No need to change this - No Touchy
	public static <Item extends Comparable<Item>> void librarySort(ArrayList<Item> sort) {
		Sorts.<Item>librarySort(sort, (Item item1, Item item2) -> {
			return item1.compareTo(item2);
		});
	}

	// No need to change this - No Touchy
	public static <Item extends Comparable<Item>> void librarySortReverse(ArrayList<Item> sort) {
		Sorts.<Item>librarySort(sort, (Item item1, Item item2) -> {
			return item2.compareTo(item1);
		});
	}

	// add code to sort list using bubble sort
	// use comparator.compare(item1, item2) for comparisons
	// Collections.swap(list, index1, index2); may be helpful to move items in the
	// list
	public static <Item> void bubbleSortCompare(ArrayList<Item> sort, Comparator<Item> comparator) {
		for(int i = 1; i <= sort.size()-1; i++) {
			boolean didweswap = false;
			for(int j = 1; j <= sort.size() - i - 1; j++) {
				if(sort.get(j).compareTo(sort.get(j+1)) > 0) {
					Item temp = sort.get(j);
					sort.set(j, sort.get(j+1));
					sort.set(j+1, temp);
				}
			}
			
			if(!didweswap) {
				break;
			}
	}
	}

	// No need to change this - No Touchy
	public static <Item extends Comparable<Item>> void bubbleSort(ArrayList<Item> sort) {
		Sorts.<Item>bubbleSortCompare(sort, (Item item1, Item item2) -> {
			return item1.compareTo(item2);
		});
	}

	// No need to change this - No Touchy
	public static <Item extends Comparable<Item>> void bubbleSortReverse(ArrayList<Item> sort) {
		Sorts.<Item>bubbleSortCompare(sort, (Item item1, Item item2) -> {
			return item2.compareTo(item1);
		});
	}

	// add code to sort list using insertion sort
	// use comparator.compare(item1, item2) for comparisons
	// Collections.swap(list, index1, index2); may be helpful to move items in the
	// list
	public static <Item> void insertionSortCompare(ArrayList<Item> sort, Comparator<Item> comparator) {
		int pivot = sort.size()-1;
		ArrayList<Item> left = new ArrayList<Item>();
		ArrayList<Item> right = new ArrayList<Item>();
		for(int i = 0; i < pivot; i++) {
			if(sort.get(i).compareTo(pivot) < 0) {
				left.add(sort.get(i));
			}
			
			else {
				right.add(sort.get(i));
			}
		}
		insertionSortCompare(left);
		insertionSortCompare(right);
		
		for(int i = 0; i < left.size(); i++) {
			sort.set(i, left.get(i));
		}
		
		sort.set(left.size(), sort.get(pivot));
		
		for(int i = left.size()+1; i < left.size() + right.size(); i++) {
			sort.set(i,  right.get(i));
		}
	}

	// No need to change this - No Touchy
	public static <Item extends Comparable<Item>> void insertionSort(ArrayList<Item> sort) {
		Sorts.<Item>insertionSortCompare(sort, (Item item1, Item item2) -> {
			return item1.compareTo(item2);
		});
	}

	// No need to change this - No Touchy
	public static <Item extends Comparable<Item>> void insertionSortReverse(ArrayList<Item> sort) {
		Sorts.<Item>insertionSortCompare(sort, (Item item1, Item item2) -> {
			return item2.compareTo(item1);
		});
	}

	// add code to sort list using selection sort
	// use comparator.compare(item1, item2) for comparisons
	// Collections.swap(list, index1, index2); may be helpful to move items in the
	// list
	public static <Item> void selectionSortCompare(ArrayList<Item> sort, Comparator<Item> comparator) {
		Item min = sort.get(0);
		int index;
		for(int i = 0; i < sort.size(); i++) {
			if(sort.get(i).compareTo(min) < 0) {
				min = sort.get(i);
				index = i;
			}
		}
		
		sort.set(index, sort.get(0));
		sort.set(0, min);
		
		ArrayList<Item> sortedarr = new ArrayList<Item>();
		sortedarr.set(0, sort.get(0));
		ArrayList<Item> unsortedarr = new ArrayList<Item>();
		unsortedarr = sort;
		
		min = unsortedarr.get(0);
		for(int i = 0; i < unsortedarr.size(); i++) {
			if(sort.get(i).compareTo(min) < 0) {
				min = sort.get(i);
				index = i;
			}
		}
		
		sortedarr.add(min);
		
		sort = sortedarr;
		
	}

	// No need to change this - No Touchy
	public static <Item extends Comparable<Item>> void selectionSort(ArrayList<Item> sort) {
		Sorts.<Item>selectionSortCompare(sort, (Item item1, Item item2) -> {
			return item1.compareTo(item2);
		});
	}

	// No need to change this - No Touchy
	public static <Item extends Comparable<Item>> void selectionSortReverse(ArrayList<Item> sort) {
		Sorts.<Item>selectionSortCompare(sort, (Item item1, Item item2) -> {
			return item2.compareTo(item1);
		});
	}

	// add code to sort list using bubble sort
	// use comparator.compare(item1, item2) for comparisons
	// Collections.swap(list, index1, index2); may be helpful to move items in the
	// list
	public static <Item> void quickSortCompare(ArrayList<Item> sort, Comparator<Item> comparator) {
		quickSort(sort, comparator, 0, sort.size() - 1);
	}

	// No need to change this - No Touchy
	public static <Item extends Comparable<Item>> void quickSort(ArrayList<Item> sort) {
		Sorts.<Item>quickSortCompare(sort, (Item item1, Item item2) -> {
			return item1.compareTo(item2);
		});
	}

	// No need to change this - No Touchy
	public static <Item extends Comparable<Item>> void quickSortReverse(ArrayList<Item> sort) {
		Sorts.<Item>quickSortCompare(sort, (Item item1, Item item2) -> {
			return item2.compareTo(item1);
		});
	}

	private static <Item> void quickSort(ArrayList<Item> sort, Comparator<Item> comparator, int begin, int end) {
		if (begin < end) {
			int partitionIndex = partition(sort, comparator, begin, end);	
			
			quickSort(sort, comparator, begin, partitionIndex - 1);
			quickSort(sort, comparator, partitionIndex + 1, end);
		}
	}

	private static <Item> void printPartition(ArrayList<Item> sort, int begin, int end, int pivot)
	{
		for (int i = 0; i < sort.size(); i++) {
			if(i == begin)
			{
				System.out.print("**");
			}
			if(i == pivot)
			{
				System.out.printf(" [%3d] ", sort.get(i));
			}
			else
			{
				System.out.printf("|%3d|", sort.get(i));
			}
			 if(i == end)
				{
					System.out.print("**");
				}
		}
		System.out.println();
	}
	
	private static <Item> int partition(ArrayList<Item> sort, Comparator<Item> comparator, int begin, int end) {
		System.out.print("Before Partition: ");
		//printPartition(sort, begin, end,begin); 
		
		
		
		//System.out.print("After  Partition: ");
		//printPartition(sort, begin, end, j); 
		return 0;
	}
	
	
}