package Snail;

public class snails {
	public static void main(String[] args) {
        int[][] matrix = new int[5][5];
		fillSnailPattern(matrix);
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                System.out.print(matrix[i][j] + " ");
            }

            System.out.println();
        }
    }

    public static void fillSnailPattern(int[][] matrix){
        int x = 0;
        int y = 0;
        matrix[x][y] = 1;
        String direction = "r";

        for(int i = 2; i <= matrix.length * matrix.length; i++){

            if(direction == "r"){
                y++;
                matrix[x][y] = i;

                if(y == 4){
                    direction = "d";
                    continue;
                }
                
                else if(matrix[x][y+1] != 0){
                    direction = "d";
                    continue;
                }

                continue;
            }


            else if(direction ==  "l"){
                y--;
                matrix[x][y] = i;

                if(y == 0){
                    direction = "u";
                    continue;
                }

                else if(matrix[x][y-1] != 0){
                    direction = "u";
                    continue;
                }
 
                continue;
                
            }

            else if(direction == "d"){
                x++;
                matrix[x][y] = i;

                if(x == 4){
                    direction = "l";
                    continue;
                }
                
                else if(matrix[x+1][y] != 0){
                    direction = "l";
                    continue;
                }

                continue;
            }


            else if(direction == "u"){
                x--;
                matrix[x][y] = i;

                if(x == 0){
                    direction = "r";
                    continue;
                }
                
                else if(matrix[x-1][y] != 0){
                    direction = "r";
                    continue;
                }

                continue;
            }

        }
    }
}
