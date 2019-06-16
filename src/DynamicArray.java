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
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class DynamicArray {
    // Complete the dynamicArray function below.
    static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
        int lastAnswer = 0;
        Map<Integer, List<Integer>> dic = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        for(List<Integer> query : queries){
            int q = query.get(0);
            int x = query.get(1);
            int y = query.get(2);
            int temp = (x ^ lastAnswer) % n;
            if(q == 1){
                if(!dic.containsKey(temp)){
                    List<Integer> seqList = new ArrayList<>();
                    seqList.add(y);
                    dic.put(temp, seqList);
                }else{
                    List<Integer> seqList = dic.get(temp);
                    seqList.add(y);
                }
            }else{
                List<Integer> seqList = dic.get(temp);
                int index = y % seqList.size();
                lastAnswer = seqList.get(index);
                result.add(lastAnswer);
            }
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] nq = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nq[0]);

        int q = Integer.parseInt(nq[1]);

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, q).forEach(i -> {
            try {
                queries.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> result = dynamicArray(n, queries);

        System.out.println(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
    }

}
