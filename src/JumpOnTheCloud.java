import sun.util.resources.cldr.et.CurrencyNames_et;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class JumpOnTheCloud {

    public static void main(String[] args) {

        final Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] c = new int[n];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int result = jumpingOnClouds(c);

        scanner.close();

        System.out.println(result);
    }

    // Complete the jumpingOnClouds function below.
    static int jumpingOnClouds(int[] c) {
        int min = 0;
        int current = 0;
        int i = 0;
        int j = 0;
        Set<Integer> jump = new HashSet<>();
        while(true){
            j = i; // 이전값 저장

            if(i+2 <= c.length -1 && !jump.contains(i+2)){
                if(c[i+2] == 0){
                    jump.add(i+2);
                    i += 2;
                    current++; // jump
                }else{
                    jump.add(i+2);
                }

            }else if(i+1 <= c.length - 1 && !jump.contains(i+1)){
                if(c[i+1] == 0){
                    jump.add(i+1);
                    i += 1;
                    current++; // jump
                }else{
                    jump.add(i+1);
                }
            }else{
                min = 0;
                break;
            }

            if(i == c.length -1){
                min = current;
                break;
            }else{
                continue;
            }
        }

        return min;
    }
}
