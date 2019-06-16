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
// 중요! - 특정 배열의 회전 인덱스 구하기 (i + n - d) % n
public class Rotation {
    private static final Scanner scanner = new Scanner(System.in);

    public static int[] rotate(int d, int[] a){

        int[] result = new int[a.length];

        int n = a.length;

        for(int i=0; i < a.length; i++){
            result[(i+n-d)%n] = a[i];
        }

        return result;
    }

    public static void main(String[] args) {
        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }
        int[] result = new int[a.length];

        for(int i=0; i < a.length; i++){
            result[(i+n-d)%n] = a[i];
        }

        for(int j =0; j < result.length; j++){
            System.out.print(result[j] + " ");
        }
        scanner.close();
    }
}
