package ds.stockspan;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;



/**
 * @author Robert Ward
 *
 */
public class Main {

	/**
	 * @param args
	 */
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
//		Step 1 Add your stack class to the project
//
//		Step 2 Complete the Stock Span Code Analysis work sheet 
//
//		Step 3 Implement brute force span method and Pass all basic unit tests
//
//		Step 4 Implement stack based span method and Pass all basic unit tests
//
//		Step 5 Update main to read, print to the screen and write files for just first file�
//
//		Step 6 Uncomment files to try all three


			
	 
		ArrayList<String> files = new ArrayList<String>();
		
		
		// Daily Stock Prices 100, 80, 60, 70, 60, 75, 85
		//Stock Span for those days 1, 1, 1, 2, 1, 4, 6
		files.add("TestDailyStockPrice.txt");
	//	files.add("PeletonDailyStockPrice.txt");
	//	files.add("AmazonDailyStockPrice.txt");
	//	files.add("GoogleDailyStockPrice.txt");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");
		for (String fileName : files) {
			StockSpan sp = new StockSpan();
			//fill in code to get list of prices
			
			
			//fill in code to print spans to console
		
			
			//fill in code to write to new file		
	
		}
		 
		

		 
	}

	
	public static void readFile(String fileName,StockSpan sp,DateTimeFormatter formatter )
	{
				
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			String line = "";

			while ((line = br.readLine()) != null) {

				String[] fields = line.split(",");
				sp.addPrice(Double.parseDouble(fields[1]), LocalDate.parse(fields[0],formatter) );
			
			}
		} catch (FileNotFoundException e) {
			System.out.print(fileName + " File Not found");

		} catch (IOException e) {
			e.printStackTrace();

		}
		
	}
	public static void writeSpans(String fileName, StockSpan sp, DateTimeFormatter formatter)
	{
		
		try(BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))){
			
			for (int i = 0;  i < sp.numberofDays(); i++) {
				 writer.write(String.format("%s,%d",sp.getDate(i).format(formatter) , sp.getSpan(i))); 
			    //Test line
				// System.out.println(String.format("%s,%d", sp.getDate(i).format(formatter), sp.getSpan(i)));
				 writer.newLine();
			}
		   
		}
		catch(IOException e){
		    // handle the exception
			e.printStackTrace();

		}
	}
}
