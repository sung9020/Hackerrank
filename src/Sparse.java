import javafx.print.PrintColor;

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
 * @since 2019-05-29
 */
public class Sparse {

    // Complete the matchingStrings function below.
    static int[] matchingStrings(String[] strings, String[] queries) {
        Map<String, Integer> map = new LinkedHashMap<>();
        int[] result = new int[queries.length];
        Arrays.stream(queries).forEach(s ->{
            map.put(s, 0);
        });

        for(String str : strings){
            if(map.containsKey(str)){
                map.put(str, map.get(str) + 1);
            }
        }

        for(int i = 0; i < queries.length; i++){
            if(map.containsKey(queries[i])){
                result[i] = map.get(queries[i]);
            }else{
                result[i] = 0;
            }
        }

        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int stringsCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] strings = new String[stringsCount];

        for (int i = 0; i < stringsCount; i++) {
            String stringsItem = scanner.nextLine();
            strings[i] = stringsItem;
        }

        int queriesCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] queries = new String[queriesCount];

        for (int i = 0; i < queriesCount; i++) {
            String queriesItem = scanner.nextLine();
            queries[i] = queriesItem;
        }

        int[] res = matchingStrings(strings, queries);

        for (int i = 0; i < res.length; i++) {
            System.out.println(String.valueOf(res[i]));
        }

        scanner.close();
    }
}
