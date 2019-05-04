import java.io.*;
import java.lang.reflect.Array;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.stream.Stream;

public class Array_2D {

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
        int[][] row = {{0,0},{0,1},{0,2},{1,1},{2,0},{2,1},{2,2}};
        int max = 0;
        int[] sum_list = new int[16];
        int i = 0;
        for(int y = 0; y < 4; y++){
            for(int x =0; x < 4; x++){
                int sum = 0;

                for(int[] point : row){
                    int temp_y = y + point[0];
                    int temp_x = x + point[1];
                    sum += arr[temp_y][temp_x];
                }
                sum_list[i] = sum;
                i++;

                if((x==0 && y==0) || max < sum){
                    max = sum;
                }
            }
        }


        return max;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);

        scanner.close();

        System.out.println(result);
    }
}
