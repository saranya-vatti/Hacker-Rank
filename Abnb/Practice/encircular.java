// You are working on a computer simulation of a mobile robot. The robot moves on an infinite plane, starting from position (0, 0). Its movements are described by a command string consisting of one or more of the following three letters:
// G instructs the robot to move forward one step.
// L instructs the robot to turn left.
// R instructs the robot to turn right.
 
// The robot performs the instructions in a command and repeats them for an infinite time. You want to know whether or not there exists some circle whose radius is a positive real number such that the robot always moves within the circle and never leaves it

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the function below.
     */
    static String[] doesCircleExist(String[] commands) {
        String[] result = new String[commands.length];
        for(int t=0;t<commands.length;t++) {
            char[] arr = commands[t].toCharArray();
            // We initially take the co-ordinates to be zero
            int x = 0;
            int y = 0;
            char direction = 'U'; // Up, Right, Left, Down
            for(int j=0;j<4;j++) {
                // And then we calculate the direction and co ordinates
                // for 4 rounds
                for(int i=0;i<arr.length;i++) {
                    if(arr[i] == 'G') {
                        if (direction == 'U') {
                            y++;
                        } else if(direction == 'D') {
                            y--;
                        } else if (direction =='L') {
                            x--;
                        } else {
                            x++;
                        }
                    } else if (arr[i] == 'L') {
                        if (direction == 'U') {
                            direction = 'L';
                        } else if(direction == 'D') {
                            direction = 'R';
                        } else if (direction =='L') {
                            direction = 'D';
                        } else {
                            direction ='L';
                        }
                    } else {
                        if (direction == 'U') {
                            direction = 'R';
                        } else if(direction == 'D') {
                            direction = 'L';
                        } else if (direction =='L') {
                            direction = 'U';
                        } else {
                            direction ='D';
                        }
                    }
                }
            }
            System.out.println(x);
            System.out.println(y);
            System.out.println(direction);
            if(x == 0 && y== 0) {
                result[t] = "YES";
            } else {
                result[t] = "NO";
            }
        }
        return result;
    }
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        final String fileName = System.getenv("OUTPUT_PATH");
        BufferedWriter bw = null;
        if (fileName != null) {
            bw = new BufferedWriter(new FileWriter(fileName));
        }
        else {
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }

        String[] res;
        int commands_size = 0;
        commands_size = Integer.parseInt(in.nextLine().trim());

        String[] commands = new String[commands_size];
        for(int i = 0; i < commands_size; i++) {
            String commands_item;
            try {
                commands_item = in.nextLine();
            } catch (Exception e) {
                commands_item = null;
            }
            commands[i] = commands_item;
        }

        res = doesCircleExist(commands);
        for(int res_i = 0; res_i < res.length; res_i++) {
            bw.write(String.valueOf(res[res_i]));
            bw.newLine();
        }

        bw.close();
    }
}
