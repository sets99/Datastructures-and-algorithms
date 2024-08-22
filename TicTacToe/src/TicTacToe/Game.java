package TicTacToe;

public class Game {
	String[][] arr;

    public Game(String[][] gameArr){
        arr = gameArr;
    }


    public void printGame(){
        for(int i = 0; i <= 2; i++){
            for(int j = 0; j <= 2; j++){
                System.out.print(this.arr[i][j] + " ");
            }

            System.out.println();
        }
    }

    public void move(int i, int j, String mark){
        this.arr[i-1][j-1] = mark;
    }  


    public String checkWin(){
        if(this.arr[0][0].equals(this.arr[1][1]) && this.arr[1][1].equals(this.arr[2][2])){ //main diagonal
            return this.arr[1][1];
        }

        else if(this.arr[0][2].equals(this.arr[1][1]) && this.arr[1][1].equals(this.arr[2][0])){ //non-main diagonal
            return this.arr[1][1];
        }

        for(int i = 0; i <= 2; i++){
            if((this.arr[i][0].equals(this.arr[i][1]) && this.arr[i][1].equals(this.arr[i][2]))){ //rows 
                return this.arr[i][0];
            }
        }

        for(int j = 0; j <= 2; j++){
            if((this.arr[0][j].equals(this.arr[1][j]) && this.arr[1][j].equals(this.arr[2][j]))){ //columns
                return this.arr[0][j];
            }
        }

        return("No");
    }

    public String checkDraw(){
        for(int i = 0; i <= 2; i++){
            for(int j = 0; j <= 2; j++){
                if(this.arr[i][j] != "X" && this.arr[i][j] != "O"){
                    return("No");
                }
            }
        }

        if(this.checkWin().equals("No")){
            return("Yes");
        }

        return("No");

    }
}
