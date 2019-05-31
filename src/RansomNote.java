import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class RansomNote {

    // Complete the checkMagazine function below.
    static void checkMagazine(String[] magazine, String[] note) {
        Map<String, Integer> wordCountMap = new HashMap();

        Arrays.stream(magazine).forEach(word -> {
            if (wordCountMap.containsKey(word)) {
                int m_count = wordCountMap.get(word);
                wordCountMap.put(word, ++m_count);
            }else{
                wordCountMap.put(word, 1);
            }
        });

        for(String n_word : note){

            if (wordCountMap.containsKey(n_word)) {
                int n_count = wordCountMap.get(n_word);

                if(n_count > 0){
                    wordCountMap.put(n_word,--n_count);
                }else{
                    System.out.println("No");
                    return;
                }
            }else{
                System.out.println("No");
                return;
            }
        }

        System.out.println("Yes");
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] mn = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mn[0]);

        int n = Integer.parseInt(mn[1]);

        String[] magazine = new String[m];

        String[] magazineItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            String magazineItem = magazineItems[i];
            magazine[i] = magazineItem;
        }

        String[] note = new String[n];

        String[] noteItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            String noteItem = noteItems[i];
            note[i] = noteItem;
        }

        checkMagazine(magazine, note);

        scanner.close();
    }
}
