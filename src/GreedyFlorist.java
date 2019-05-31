import javax.xml.transform.Result;
import java.io.*;
import java.lang.reflect.Array;
import java.math.*;
        import java.security.*;
        import java.text.*;
        import java.util.*;
        import java.util.concurrent.*;
        import java.util.regex.*;

public class GreedyFlorist {

    // Complete the getMinimumCost function below.
    static int getMinimumCost(int k, int[] c) {
        int result = 0;
        quickSort(c, 0, c.length - 1);
        int repeat = 0;

        int j = 0;
        for(int i = c.length-1; i >= 0; i--){
                result += (repeat + 1) * c[i];
                j++;
                if(j == k){
                    repeat++;
                    j = 0;
                }
        }

        return result;
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

        int[] c = new int[n];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int minimumCost = getMinimumCost(k, c);

        System.out.println(minimumCost);

        scanner.close();
    }
}
