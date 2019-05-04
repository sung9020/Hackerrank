import javax.xml.transform.Result;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class RepeatedString {

    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {
        int s_size = s.length();
        long result = 0;

        if(n >= s_size){
            for(int i = 0; i < s_size; i++){
                if(s.charAt(i) == 'a'){
                    long value = (n - i) / s_size;
                    long rest = (n - i) % s_size;
                    if(value != 1000000000000L && rest != 0){
                        result += value + 1;
                    }else{
                        result += value;
                    }

                }
            }
        }else{
            for(int i = 0; i < n; i++){
                if(s.charAt(i) == 'a'){
                    result++;
                }
            }
        }


        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String s = scanner.nextLine();

        long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = repeatedString(s, n);

        scanner.close();

        System.out.println(result);
    }
}
