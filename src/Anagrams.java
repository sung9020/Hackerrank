import java.io.*;
import java.lang.reflect.Array;
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
public class Anagrams {// Complete the makeAnagram function below.
    static int makeAnagram(String a, String b) {
        int result = 0;
        char[] sortedA = reverseStr(a);
        char[] sortedB = reverseStr(b);
        int count = 0;
        int preIndex = 0;

        for(int i = 0; i < sortedA.length; i++){
            for(int j =0; j < sortedB.length; j++){
                if(sortedA[i] == sortedB[j]){
                    if(i != j){
                        count += j - preIndex;
                        preIndex = j+1;
                        sortedA[i] = 0;
                        sortedB[j] = 0;
                    }else{
                        preIndex = j+1;
                        sortedA[i] = 0;
                        sortedB[j] = 0;
                    }
                }
            }

            if(sortedA[i] != 0){
                count++;
                sortedA[i] = 0;
            }
        }


        return count;
    }

    static char[] reverseStr(String str){
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        Collections.reverse(Arrays.asList(chars));

        return chars;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String a = scanner.nextLine();

        String b = scanner.nextLine();

        int res = makeAnagram(a, b);
        scanner.close();

        System.out.println(res);
    }
}