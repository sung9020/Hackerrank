import javax.xml.transform.Result;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/*
 *
 * @author 123msn
 * @since 2019-05-06
 */
public class MarkAndToys {
    // Complete the maximumToys function below.
    static int maximumToys(int[] prices, int k) {

        int count = 0;
        int priceSize = prices.length;
        quickSort(prices, 0, priceSize-1);

        for(int p = 0; p < priceSize; p++){
            k = k - prices[p];

            if(k > 0){
                count++;
            }else{
                break;
            }
        }

        return count;
    }

    // TODO quick sort 반드시 알아두기
    static void quickSort(int[] list, int left, int right){ //left = right = index
        if(left >= right) return;

        int mid = left + ((right - left) / 2);
        int pivot = list[mid];

        int i = left;
        int j = right;

        while(i<=j){
            while(list[i] < pivot){
                i++;
            }
            while(list[j] > pivot){
                j--;
            }

            if(i <= j){
                int temp = list[i];
                list[i] = list[j];
                list[j] = temp;
                i++;
                j--;
            }
        }

        if(left < j){
            quickSort(list, left, j);
        }

        if(right > i){
            quickSort(list, i, right);
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] prices = new int[n];

        String[] pricesItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int pricesItem = Integer.parseInt(pricesItems[i]);
            prices[i] = pricesItem;
        }

        int result = maximumToys(prices, k);
        scanner.close();
        System.out.println(result);
    }
}


