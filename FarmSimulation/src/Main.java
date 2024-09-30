import java.util.*;

public class Main {

	public static void main(String[] args) {
		Random rand = new Random();
		int[] fertarr = new int[6];
		int[] deliveryarr = new int[6];
		int[] dosearr = new int[6];
		String deliver, current, doses;
		
		for(int i = 0; i < 6; i++) {
			fertarr[i] = 0;
		}
		int day = 1;
		
		Corn corn1 = new Corn("Saksham", rand.nextInt(50, 99));
		Corn corn2 = new Corn("Alan", rand.nextInt(50, 99));
	
		Wheat wheat1 = new Wheat("Ansh", rand.nextInt(50, 99));
		Wheat wheat2 = new Wheat("Pranav", rand.nextInt(50, 99));

		Rice rice1 = new Rice("Jeremy", rand.nextInt(50, 99));
		Rice rice2 = new Rice("Troy", rand.nextInt(50, 99));
		
		Barley barley1 = new Barley("Avery", rand.nextInt(50, 99));
		Barley barley2 = new Barley("Yash", rand.nextInt(50, 99));
				
		Potato potato1 = new Potato("Sarah", rand.nextInt(50, 99));
		Potato potato2 = new Potato("Jett", rand.nextInt(50, 99));
		
		ArrayList<Plant> plants = new ArrayList<Plant>();
		plants.add(corn1);
		plants.add(corn2);
		plants.add(wheat1);
		plants.add(wheat2);
		plants.add(rice1);
		plants.add(rice2);
		plants.add(barley1);
		plants.add(barley2);
		plants.add(potato1);
		plants.add(potato2);
		ArrayList<Plant> unSortedPlants = new ArrayList<Plant>();
		for(int i = 0; i < plants.size(); i++){
			unSortedPlants.add(plants.get(i));
		}
		
		
		while(true){
			for(int i = 0; i < 6; i++) {
				deliveryarr[i] = rand.nextInt(0, 4);
				fertarr[i] += deliveryarr[i];
			}
			System.out.println("---------------------------------------------------------------------------------------------------");
			System.out.println("Day " + day);
			deliver = "Delivery:      ";
			current = "Current Stock: ";
			for(int i = 0; i < 6; i++) {
				deliver += Fertilizer.values()[i] + " " + String.valueOf(deliveryarr[i]) + "      ";
				current += Fertilizer.values()[i] + " " + String.valueOf(fertarr[i]) + "      ";
			}
			System.out.println(deliver);
			System.out.println(current);
			System.out.println("---------------------------------------------------------------------------------------------------");
			Collections.sort(plants, (a, b) -> Integer.compare(b.need, a.need));
			
	

			String[] fertStrArr = new String[10];
			String[] musicStrArr= new String[10];

			for(Plant currPlant: plants) {
				if(currPlant.music == Music.Pop){
					musicStrArr[unSortedPlants.indexOf(currPlant)] = currPlant.toString();
					continue;
				}

				if(fertarr[currPlant.primary.ordinal()] >= 1) {
					currPlant.fertilize(currPlant.primary);
					fertStrArr[unSortedPlants.indexOf(currPlant)] = currPlant.name + " fertilized with " + currPlant.primary +  " (primary)      "; 
					fertarr[currPlant.primary.ordinal()]--;
					dosearr[currPlant.primary.ordinal()]++;
				}
				
				else if(fertarr[currPlant.secondary.ordinal()] >= 1) {
					currPlant.fertilize(currPlant.secondary);
					fertStrArr[unSortedPlants.indexOf(currPlant)] = currPlant.name + " fertilized with " + currPlant.secondary + " (secondary)      ";
					fertarr[currPlant.secondary.ordinal()]--;
					dosearr[currPlant.secondary.ordinal()]++;
				}
				
				else {
					fertStrArr[unSortedPlants.indexOf(currPlant)] = currPlant.name + " was not fertilized!";
				}
				
				currPlant.updateMusic();
				musicStrArr[unSortedPlants.indexOf(currPlant)] = currPlant.toString();
				
			}
			
			for(int i = 0; i < plants.size(); i++) {
				if(fertStrArr[i] != null){
					System.out.println(fertStrArr[i]);
				}
				System.out.println(musicStrArr[i]);
			}
			
			for(int i = 0; i < plants.size(); i++){
				plants.get(i).need += rand.nextInt(1, 4);
			}

			
			if(corn1.music == Music.Pop && corn1.music == corn2.music && corn1.music == wheat1.music && corn1.music == wheat2.music && corn1.music == rice1.music && corn1.music == rice2.music && corn1.music == barley1.music && corn1.music == barley2.music && corn1.music == potato1.music && corn1.music == potato2.music) {
				break;
			}
			day++;
			
		}
		

		System.out.println("------------------------------------------------------------------------------------------------------");
		System.out.println("\nSIMULATION OVER");
		System.out.println("\nTotal Days: " + day);
		System.out.println(current);
		doses = "Doses Used:    ";
		for(int i = 0; i < 6; i++){
			doses += Fertilizer.values()[i] + " " + dosearr[i] + "      ";
		}
		System.out.println(doses);
	
		System.out.println("------------------------------------------------------------------------------------------------------");

		
	
	}

}