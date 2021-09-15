package com.abn.dsalgos.glc;

import java.util.HashMap;
import java.util.Map;

/*
There is a robot starting at the position (0, 0), the origin, on a 2D plane. Given a sequence of its moves, judge if this robot ends up at (0, 0) after it completes its moves.

You are given a string moves that represents the move sequence of the robot where moves[i] represents its ith move. Valid moves are 'R' (right), 'L' (left), 'U' (up), and 'D' (down).

Return true if the robot returns to the origin after it finishes all of its moves, or false otherwise.

Note: The way that the robot is "facing" is irrelevant. 'R' will always make the robot move to the right once, 'L' will always make it move left, etc. Also, assume that the magnitude of the
robot's movement is the same for each move.

Input: moves = "UD"
Output: true

Input: moves = "LDRRLRUULR"
Output: false

Input: moves = "LL"
Output: false
 */
public class RobotMovement {

    public boolean judgeCircle(String moves) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < moves.length(); i++) {
            char ch = moves.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int countUp = 0;
        int countDown = 0;
        int countLeft = 0;
        int countRight = 0;
        boolean status = true;

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {

            if (map.containsKey('U')) {
                countUp = map.get('U');
            }

            if (map.containsKey('D')) {
                countDown = map.get('D');
            }

            if (map.containsKey('R')) {
                countRight = map.get('R');
            }

            if (map.containsKey('L')) {
                countLeft = map.get('L');
            }
        }

        if (countUp != countDown) {
            return false;
        }
        if (countRight != countLeft) {
            return false;
        }

        return true;

    }

    public static void main(String[] args) {

        RobotMovement robotMovement = new RobotMovement();
        System.out.println(robotMovement.judgeCircle("LDRRLRUULR"));
    }
}
