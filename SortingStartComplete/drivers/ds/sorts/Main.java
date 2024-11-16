package ds.sorts;

import java.util.ArrayList;
import java.util.Collections;

import ds.sorts.Sorts;
import ds.sorts.Sorts.Sort;



public class Main {

	public static void main(String[] args) {

		ArrayList<Integer> sortMe = new ArrayList<>(); 
		int itemsPerLine = 10;
		
		for (int i = 0; i < 10; i++) {
			
			sortMe.add(i);
		} 
		
		//sortTest("Library Sort", sortMe, itemsPerLine, (Sort<Integer>)Sorts::<Integer>librarySort);
		//sortTest("Library Sort Reverse", sortMe, itemsPerLine, (Sort<Integer>)Sorts::<Integer>librarySortReverse);
//		
//		sortTest("Bubble Sort", sortMe, itemsPerLine, (Sort<Integer>)Sorter::<Integer>bubbleSort);
//		sortTest("Bubble Sort Reverse", sortMe, itemsPerLine, (Sort<Integer>)Sorter::<Integer>bubbleSortReverse);
//		
//		sortTest("Insertion Sort", sortMe, itemsPerLine, (Sort<Integer>)Sorter::<Integer>insertionSort);
//		sortTest("Insertion Sort Reverse", sortMe, itemsPerLine, (Sort<Integer>)Sorter::<Integer>insertionSortReverse);
//		
//		sortTest("Selection Sort", sortMe, itemsPerLine, (Sort<Integer>)Sorter::<Integer>selectionSort);
//		sortTest("Selection Sort Reverse", sortMe, itemsPerLine, (Sort<Integer>)Sorter::<Integer>selectionSortReverse);
		
		sortTest("Quick Sort", sortMe, itemsPerLine, (Sort<Integer>)Sorts::<Integer>quickSort);
//		sortTest("Quick Sort Reverse", sortMe, itemsPerLine, (Sort<Integer>)Sorter::<Integer>quickSortReverse);
	}

	public static void sortTest(String sortName, ArrayList<Integer> listTosort, int itemsPerLine, Sort<Integer> sortMethod )
	{
		
		System.out.println(sortName);
		Collections.shuffle(listTosort);	
		
		//System.out.println("Before Sorting");
		//printList(listTosort,itemsPerLine);
		//System.out.println();
		
		sortMethod.sortList(listTosort);
		
		System.out.println("After Sorting");
		printList(listTosort,itemsPerLine);
		//System.out.println();
		
	}
	// warm up
	// fix the error in this method
	// by moving one line of code (do not add or remove any code)
	public static void printList(ArrayList<Integer> print, int itemsPerLine)
	{
		
		int count = itemsPerLine;
		for (int i = 0; i < print.size() ; i++) {
			
			System.out.format("%4d", print.get(i));
			
			if (count == 0)
			{
				System.out.println();
				count = itemsPerLine;
			}
			count--;
		}
		System.out.println();
	}
}
