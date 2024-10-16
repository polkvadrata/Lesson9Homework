package app;

import java.util.Arrays;
import java.util.Random;

public class mainProgram {

    public static void main(String[] args) {

        Random rnd = new Random();
        int[][] array = new int[4][4];

        //for checking second part
//            int[][] array =
//            {
//                    {1,2,3,4},
//                    {4,3,2,1},
//                    {4,3,2,1},
//                    {1,2,3,4}
//            };

        int sumOfOddRows = 0;
        int sumOfEvenRows = 0;
        long productOfOddCols = 1;
        long productOfEvenCols = 1;

        int sumOfRightDiagonal = 0;
        int sumOfLeftDiagonal = 0;
        int[] arrayOfRowSums = new int[array.length];
        int[] arrayOfColSums = new int[array.length];

        for (int i = 0; i < array.length; i++){
            for (int j = 0 ; j < array[i].length; j++){
                array[i][j] = rnd.nextInt(50)+1;
            }
        }

// first part ----------------------------------------------------

        for (int i = 0; i< array.length; i++){
            for (int j = 0; j < array[i].length; j++) {

                if (i % 2 == 0) {
                    sumOfOddRows +=array[i][j];
                }
                else sumOfEvenRows +=array[i][j];

                if (j % 2 == 0){
                    productOfOddCols *= array[i][j];
                }
                else productOfEvenCols *= array[i][j];
            }
        }

        System.out.println("Матриця 4x4:");
        for (int[] arr : array){
            System.out.println(Arrays.toString(arr));
        }

        System.out.printf("%nСума елементів у парних рядках (рядок 0, 2): %d",sumOfEvenRows);
        System.out.printf("%nСума елементів у непарних рядках (рядок 1, 3): %d",sumOfOddRows);
        System.out.printf("%nДобуток елементів у парних стовпцях (стовпець 0, 2): %d",productOfEvenCols);
        System.out.printf("%nДобуток елементів у непарних стовпцях (стовпець 1, 3): %d%n%n",productOfOddCols);

// second part ----------------------------------------------------

        for (int i = 0; i < array.length; i++) {

            for (int j = 0; j < array[i].length; j++) {

                if (i == j){
                    sumOfLeftDiagonal +=array[i][j];
                }
                if(i == array[i].length - 1 - j){
                    sumOfRightDiagonal +=array[i][j];
                }

                arrayOfRowSums[i] +=array[i][j];
                arrayOfColSums[j] +=array[i][j];
            }
        }

        Arrays.sort(arrayOfRowSums);
        Arrays.sort(arrayOfColSums);

        if (
                arrayOfRowSums[0] == arrayOfRowSums[arrayOfRowSums.length-1] &&
                arrayOfColSums[0] == arrayOfColSums[arrayOfColSums.length-1] &&
                sumOfRightDiagonal == sumOfLeftDiagonal
        ){
            System.out.println("Матриця Є магічним квадратом.");
        }   else System.out.println("Матриця не є магічним квадратом.");

    }

}
