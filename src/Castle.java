/*
 *
 * @author 123msn
 * @since 2019-05-29
 */
// TODO
import sun.jvm.hotspot.debugger.linux.sparc.LinuxSPARCThreadContext;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Castle {
    // Complete the minimumMoves function below.
    static int minimumMoves(String[] grid, int startX, int startY, int goalX, int goalY) {
        int currentX = startX;
        int currentY = startY;
        int count = 0;
        int beforeX = startX;
        int beforeY = startY;
        int[][] flag = {{0,1},{1,0}, {1,1},{0,0}};
        List<List<Integer>> isUsed = new ArrayList<>(10);
        for(int p = 0; p < isUsed.size(); p++){
            isUsed.get(p).addAll(new ArrayList<>(10));
        }

        while(startX != goalX && startY != goalY){
            beforeX = currentX;
            beforeY = currentY;
            int i = flag.length;
            while(i > 0){
                if(flag[i][0] > 0 && flag[i][1] > 0){
                    for(int j = currentX; j > 0 ; j--){
                        currentX = j;
                        if(isUsed.get(currentX).get(currentY) == 1) {
                            currentX = beforeX;
                            break;
                        }
                        if(grid[currentX].charAt(currentY) == 'X') {
                            currentX = beforeX;
                            break;
                        }
                        isUsed.get(currentX).set(currentY, 1);
                    }
                }else if(flag[i][0] == 0 && flag[i][1] == 0){
                    for(int j = currentX; j < grid.length ; j++){
                        currentX = j;
                        if(isUsed.get(currentX).get(currentY) == 1) {
                            currentX = beforeX;
                            break;
                        }
                        if(grid[currentX].charAt(currentY) == 'X') {
                            currentX = beforeX;
                            break;
                        }
                        isUsed.get(currentX).set(currentY, 1);
                    }
                }else if(flag[i][0] > 0 && flag[i][1] == 0){
                    for(int j = currentY; j < grid.length ; j++){
                        currentY = j;
                        if(isUsed.get(currentX).get(currentY) == 1) {
                            currentX = beforeX;
                            break;
                        }
                        if(grid[currentX].charAt(currentY) == 'X') {
                            currentX = beforeX;
                            break;
                        }
                        isUsed.get(currentX).set(currentY, 1);
                    }
                }else{
                    for(int j = currentY; j > 0 ; j--){
                        currentY = j;
                        if(isUsed.get(currentX).get(currentY) == 1) {
                            currentX = beforeX;
                            break;
                        }
                        if(grid[currentX].charAt(currentY) == 'X') {
                            currentX = beforeX;
                            break;
                        }
                        isUsed.get(currentX).set(currentY, 1);
                    }
                }

                if(currentX == beforeX && currentY == beforeY) {
                    i--;
                    continue;
                }
                else {
                    count++;
                    break;
                }
            }

        }

        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] grid = new String[n];

        for (int i = 0; i < n; i++) {
            String gridItem = scanner.nextLine();
            grid[i] = gridItem;
        }

        String[] startXStartY = scanner.nextLine().split(" ");

        int startX = Integer.parseInt(startXStartY[0]);

        int startY = Integer.parseInt(startXStartY[1]);

        int goalX = Integer.parseInt(startXStartY[2]);

        int goalY = Integer.parseInt(startXStartY[3]);

        int result = minimumMoves(grid, startX, startY, goalX, goalY);

        System.out.println(result);
        scanner.close();
    }
}
