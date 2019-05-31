/*
 *
 * @author 123msn
 * @since 2019-05-30
 */
import com.sun.xml.internal.bind.v2.model.core.ID;
import sun.security.util.Length;

import javax.xml.transform.Result;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.stream.Collectors;

public class TripleSum {
    // Complete the triplets function below.
    static long triplets(int[] a, int[] b, int[] c) {
        Set<String> checked = new TreeSet<>();
        long count = 0;

        List<Integer> sort_a = Arrays.stream(a).boxed().distinct().collect(Collectors.toList());
        Collections.sort(sort_a);
        Set<Integer> set_b = Arrays.stream(b).boxed().collect(Collectors.toSet());
        List<Integer> sort_c = Arrays.stream(c).boxed().distinct().collect(Collectors.toList());
        Collections.sort(sort_c);

        for(Integer num_b : set_b){
            long count_a = 0;
            long count_c = 0;
            count_a = binary(sort_a, num_b);
            count_c = binary(sort_c, num_b);
            count += (count_a) * (count_c);
        }

        return count;
    }

    static int binary(List<Integer> arr, int k){

        int left = 0;
        int right = arr.size() - 1;
        int count = 0;


        while(true){
            int mid = (left + right) / 2;

            if(mid == arr.size() - 1) {
                if (arr.get(mid) <= k) {
                    return arr.size();
                }else{
                    return 0;
                }
            }

            if(mid == 0){
                if (arr.get(mid) <= k) {
                    return 1;
                }else{
                    return 0;
                }
            }

            if(arr.get(mid) <= k && arr.get(mid + 1) > k){
                count = mid + 1;
                break;
            }else{
                if(arr.get(mid + 1) <= k){
                    left = mid + 1;
                }else{
                    right = mid;
                }
            }

        }

        return count;
    }
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String[] lenaLenbLenc = scanner.nextLine().split(" ");

        int lena = Integer.parseInt(lenaLenbLenc[0]);

        int lenb = Integer.parseInt(lenaLenbLenc[1]);

        int lenc = Integer.parseInt(lenaLenbLenc[2]);

        int[] arra = new int[lena];

        String[] arraItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < lena; i++) {
            int arraItem = Integer.parseInt(arraItems[i]);
            arra[i] = arraItem;
        }

        int[] arrb = new int[lenb];

        String[] arrbItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < lenb; i++) {
            int arrbItem = Integer.parseInt(arrbItems[i]);
            arrb[i] = arrbItem;
        }

        int[] arrc = new int[lenc];

        String[] arrcItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < lenc; i++) {
            int arrcItem = Integer.parseInt(arrcItems[i]);
            arrc[i] = arrcItem;
        }

        long ans = triplets(arra, arrb, arrc);

        System.out.println(ans);
        scanner.close();
    }
}
