package SSArray;

public class snakes {
    public static void main(String[] args) {
        int[][] matrix = new int[5][5];
		fillSnakePattern(matrix);
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                System.out.print(matrix[i][j] + " ");
            }

            System.out.println();
        }
    }


    public static int[] reverseArray(int[] arr){
        int[] reversedArr = new int[arr.length];
        int temp;
        for(int i = 0; i <= (arr.length - 1)/2; i++){
            temp = arr[i];
            reversedArr[i] = arr[arr.length - i - 1];
            reversedArr[arr.length - i - 1] = temp;
        }
        return reversedArr;
    }

    public static void fillSnakePattern(int[][] matrix) {
        for(int i = 0; i <= matrix.length-1; i++){
            for(int j = 0; j <= matrix[0].length-1; j++){
                matrix[i][j] = (i)*5 + 1 + j;
            }
        }

        int[] temp = new int[matrix.length];

        for(int i = 0; i <= (matrix.length - 1)/2; i++){
            temp = matrix[i];
            matrix[i] = matrix[matrix.length - i - 1];
            matrix[matrix.length - i - 1] = temp;
        }

        for(int i = 0; i <= matrix.length-1; i++){
            if(i % 2 == (matrix.length - 1) % 2){
                matrix[i] = reverseArray(matrix[i]);
            }
        }

	}

    public static void fillSnailPattern(int[][] matrix){

    }

}
