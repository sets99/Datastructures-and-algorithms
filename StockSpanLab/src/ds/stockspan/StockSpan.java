package ds.stockspan;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import ds.labs.StackArray;


public class StockSpan {
	
	private ArrayList<Double> prices = new ArrayList<Double>();
	private ArrayList<LocalDate> dates  = new ArrayList<LocalDate>();
	private ArrayList<Integer> spans  = new ArrayList<Integer>();
	private boolean updateSpansNeeded = false;
	public StockSpan() {
		super();
		
	}

	
	public int numberofDays()
	{
		return prices.size();
	}
	
	/*
	 * Fill the spans arrayList with the span for the day or the same index in prices.
	 * Use Brute Force.
	 */
	private void calculateSpansBruteForce()
	{
		for(int i = 0; i < dates.size(); i++) {
			int count = 0;
			for(int j = i; j >= 0; j--) {
				if(prices.get(i) >= prices.get(j)) {
					count++;
				}
				
				else {
					break;
				}
			}
			
			spans.add(count);
			count = 0;
		}
	}
	/*
	 * Fill the spans arrayList with the span for the day or the same index in prices.
	 * Use better algorithm.
	 */
	@SuppressWarnings("unused")
	private void calculateSpans()
	{
		StackArray<Integer> stack = new StackArray<Integer> ();
		int[] spans = new int[prices.size()];
		spans[0] = 1;
		
		for(int i = 1; i < spans.length; i++) {
			int span = 0;
			
			for(int j = 0; j < i; i++) {
				stack.push(j);
			}
			
			for(int j = 0; j < i; j++) {
				int popped;
				
				if(prices.get(stack.peek()) <= prices.get(j)) {
					popped = stack.pop();
					span++;
				}
				
				else {
					spans[i] = span;
					continue;
				}
				
			}
			
			spans[i] = span;
		}
		
		
		
	}
	
	public void addPrice(double price, LocalDate date)
	{
			
		updateSpansNeeded = true;
		dates.add(date);
		prices.add(price);
		
	}

	public void print()
	{
		if(updateSpansNeeded)
		{
			calculateSpansBruteForce();
			updateSpansNeeded = false;
			//calculateSpans();
		}
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");
		for (int i = 0; i < spans.size(); i++)
		{
			System.out.println(String.format("%s spans %d days",this.getDate(i).format(formatter) , this.getSpan(i)));
			
		}
		System.out.println();
	}
	
	public int getSpan(int day)
	{
		if(day >= prices.size())
		{
			throw new IndexOutOfBoundsException();
		}
		if(updateSpansNeeded)
		{
			//calculateSpansBruteForce();
			calculateSpans();
			updateSpansNeeded = false;
		}
		
		return spans.get(day);
	}
	public LocalDate getDate(int day)
	{   		
		
		if(day >= dates.size())
		{
			 throw new IndexOutOfBoundsException();
		}
		return dates.get(day);
	}
}
