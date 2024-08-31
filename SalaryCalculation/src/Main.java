import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		ArrayList<Employee> arr = new ArrayList<Employee>();
		
		try (BufferedReader br = new BufferedReader(new FileReader("PayRollData.csv"))) {
			String line;
			br.readLine();
			while ((line = br.readLine()) != null) {

				String[] employeeInfo = line.split(",");

				Types emptype = Types.valueOf(employeeInfo[0]);

				Employee emp;

				switch(emptype){
					case CobraCommander:
						emp = new CobraCommander(Integer.parseInt(line.split(",")[3]), line.split(",")[1], (int) Double.parseDouble(line.split(",")[2]));
						arr.add(emp);
						break;

					case CobraTrooper:
						emp = new CobraTrooper(Integer.parseInt(line.split(",")[3]), line.split(",")[1], (int) Double.parseDouble(line.split(",")[2]));
						arr.add(emp);
						break;

					case CrimsonGuard:
						emp = new CrimsonGuard(Integer.parseInt(line.split(",")[3]), line.split(",")[1], (int) Double.parseDouble(line.split(",")[2]));
						arr.add(emp);
						break;
					
					case HighCommand:
						emp = new HighCommand(Integer.parseInt(line.split(",")[3]), line.split(",")[1], (int) Double.parseDouble(line.split(",")[2]));
						arr.add(emp);
						break;
				}
			}
			
		}
		
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		catch (IOException e) {
			e.printStackTrace();
		}
		
		int payroll = 0;

		try (BufferedWriter wr = new BufferedWriter(new FileWriter("employeeprint.txt"))) {
			for(int i = 0; i < arr.size(); i++) {
				if(arr.get(i) instanceof CobraCommander){
					wr.write(CobraCommander.toString(arr.get(i)));
				}

				else if(arr.get(i) instanceof CobraTrooper){
					wr.write(CobraTrooper.toString(arr.get(i)));
				}

				else if(arr.get(i) instanceof CrimsonGuard){
					wr.write(CrimsonGuard.toString(arr.get(i)));
				}

				else if(arr.get(i) instanceof HighCommand){
					wr.write(HighCommand.toString(arr.get(i)));
				}

				payroll += (int) arr.get(i).weeklyPay();

				wr.newLine();
			}
			
			wr.write("Total Payroll: " + payroll);
			wr.close();
			
		}
		
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		catch (IOException e) {
			e.printStackTrace();
		}

	}

}
