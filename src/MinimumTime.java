/*
 *
 * @author 123msn
 * @since 2019-05-31
 */
import com.sun.org.apache.bcel.internal.generic.NEW;
import jdk.nashorn.internal.ir.WhileNode;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.stream.Collectors;


public class MinimumTime {

    // Complete the minTime function below.
    static long minTime(long[] machines, long goal) {
        Map<Long, Long> keys = new TreeMap<>();

        long min = 0;
        long max = machines[machines.length - 1] * goal;
        long count = 0;
        long days = 0;
        while(min < max){
            long mid = (min + max) / 2;
            count = 0;

            for(long a : machines){
                count += mid / a;
            }

            if(count < goal) {
                min = mid + 1;
            }else{
                days = mid;
                max = mid;
            }
        }



        return days;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String[] nGoal = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nGoal[0]);

        long goal = Long.parseLong(nGoal[1]);

        long[] machines = new long[n];

        String[] machinesItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            long machinesItem = Long.parseLong(machinesItems[i]);
            machines[i] = machinesItem;
        }

        long ans = minTime(machines, goal);

        System.out.println(ans);
        scanner.close();
    }
}
