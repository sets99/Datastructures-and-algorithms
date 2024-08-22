package TicTacToe;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int x = 1;
	       int i;
	       int j;
	       String[][] gameArr = new String[3][3];

	       for(int a = 0; a <= 2; a++){
	        for(int b = 0; b <= 2; b++){
	            gameArr[a][b] = "0";
	        }
	       }

	       Game game = new Game(gameArr);
	       String mark;

	       Scanner reader = new Scanner(System.in);

	       while(true){
	            if(x % 2 == 1){
	                mark = "X";
	                System.out.println("Player 1: Which row do you want to place your X in?");
	                i = reader.nextInt();
	                System.out.println("Player 1: Which column do you want to place your X in?");
	                j = reader.nextInt();
	            }

	            else{
	                mark = "O";
	                System.out.println("Player 2: Which row do you want to place your O in?");
	                i = reader.nextInt();
	                System.out.println("Player 2: Which column do you want to place your O in?");
	                j = reader.nextInt();
	            }

	            if(i <= 0 || i >= 4){
	                System.out.println("This move is not allowed. ");
	                continue;
	            }

	            if(j <= 0 || j >= 4){
	                System.out.println("This move is not allowed. ");
	                continue;
	            }

	            if(game.arr[i-1][j-1].equals("X") || game.arr[i-1][j-1].equals("O")){
	                System.out.println("This move is not allowed. ");
	                continue;
	            }

	            if(mark != "X" && mark != "O"){
	                System.out.println("This move is not allowed. ");
	                continue;
	            }




	            game.move(i, j, mark);

	            if(game.checkWin().equals("X")){
	                System.out.println("Player 1, with mark X, wins!");
	                break;
	            }

	            if(game.checkWin().equals("O")){
	                System.out.println("Player 2, with mark O, wins!");
	                break;
	            }

	            if(game.checkDraw().equals("Yes")){
	                System.out.println("The game has ended with a draw.");
	                break;
	            }

	            game.printGame();

	            x++;
	       }

	       reader.close();

	}

}
