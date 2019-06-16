/*
 *
 * @author 123msn
 * @since 2019-06-08
 */
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class ArrayManipulation {
    // 진짜 신박한 문제.....
    // 배열로 꺾은선 그래프도 그릴 수 있다. 생각의 한계는 없다.

    // Complete the arrayManipulation function below.
    static long arrayManipulation(int n, int[][] queries) {
        long[] array = new long[n];
        long max = 0;
        int querySize = queries.length;

        for(int[] query : queries){
            int a = query[0];
            int b = query[1];
            int k = query[2];

            array[a-1] += k;
            if(b < n){
                array[b] -= k;
            }
        }
        long diff = 0;
        for(long i : array){
            diff += i;
            if(max < diff){
                max = diff;
            }
        }

        return max;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[][] queries = new int[m][3];

        for (int i = 0; i < m; i++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int queriesItem = Integer.parseInt(queriesRowItems[j]);
                queries[i][j] = queriesItem;
            }
        }

        long result = arrayManipulation(n, queries);
        System.out.println(result);

        scanner.close();
    }
}
