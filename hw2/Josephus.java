package hw2;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 17-683 Data Structures for Application Programmers.
 * Homework Assignment 2 Solve Josephus problem using different data structures
 * and different algorithms and compare running times.
 * Analysis - On comparing the time taken by 3 methods, I found that LinkedList as List performs the best.
 * So, I would choose this method over other 2 methods. This is because the method using LinkedList as List
 * has the lowest time complexity as compared to other 2 methods. The method playWIthAD has a time complexity
 * of O(size*rotation) and playWithLL also has a time complexity of O(size * rotation), whereas playWithLLAt
 * has a time complexity of O(size).
 * Also, on comparing between playWithAD and playWithLL, I find that playWithAD performs better as it uses
 * the ArrayDeque data structure. It can be due to the fact in ArrayDeque, the elements are close to each
 * other in continguous memory whereas in LInkedList elements can be anywhere, linkedlist also requires
 * extra storage space to store the references to the next element. So, arrayDeque seems like a more
 * efficient data structure as compared to linkedlist.
 * Andrew ID:prernasi
 * @author Prerna Singh
 */
public class Josephus {

    /**
     * Uses ArrayDeque class as Queue/Deque to find the survivor's position.
     * Time complexity - O(size *  rotation)
     *
     * @param size Number of people in the circle that is bigger than 0
     * @param rotation Elimination order in the circle. The value has to be greater than 0
     * @return The position value of the survivor
     */
    public int playWithAD(int size, int rotation) {
        // TODO your implementation here
        if (rotation <= 0) {
            throw new RuntimeException("Invalid rotation");
        }
        if (size <= 0) {
            throw new RuntimeException("Invalid size");
        }
        ArrayDeque<Integer> dq = new ArrayDeque<Integer>();
        //adding elements to the arrayDeque
        for (int i = 1; i <= size; i++) {
            dq.addLast(i);
        }
        while (dq.size() > 1) {
            //calculating move
            int move = (rotation % dq.size());
            if (move == 0) {
                move = dq.size();
            }
            //deleting elements from front and adding to the end
            for (int k = 0; k < (move - 1); k++) {
                int temp = dq.pop();
                dq.addLast(temp);
            }
            //deleting/killing element at the top
            dq.pop();
        }
        return dq.peek();
    }

    /**
     * Uses LinkedList class as Queue/Deque to find the survivor's position.
     * Time complexity - O(size * rotation)
     *
     * @param size Number of people in the circle that is bigger than 0
     * @param rotation Elimination order in the circle. The value has to be greater than 0
     * @return The position value of the survivor
     */
    public int playWithLL(int size, int rotation) {
        // TODO your implementation here
        if (rotation <= 0) {
            throw new RuntimeException("Invalid rotation");
        }
        if (size <= 0) {
            throw new RuntimeException("Invalid size");
        }
        Queue<Integer> dq = new LinkedList<Integer>();
        //adding elements to LInkedList
        for (int i = 1; i <= size; i++) {
            dq.add(i);
        }
        while (dq.size() > 1) {
            //calculating move
            int move = (rotation % dq.size());
            if (move == 0) {
                move = dq.size();
            }
            // removing elements from front and adding them to the last
            for (int k = 0; k < (move - 1); k++) {
                int temp = dq.poll();
                dq.add(temp);
            }
            // killing the person at the top position
            dq.poll();
        }
        return dq.peek();
    }
    /**
     * Uses LinkedList class to find the survivor's position.
     *
     * However, do NOT use the LinkedList as Queue/Deque
     * Instead, use the LinkedList as "List"
     * That means, it uses index value to find and remove a person to be executed in the circle
     *
     * Note: Think carefully about this method!!
     * When in doubt, please visit one of the office hours!!
     * Time COmplexity - O(size)
     *
     * @param size Number of people in the circle that is bigger than 0
     * @param rotation Elimination order in the circle. The value has to be greater than 0
     * @return The position value of the survivor
     */
    public int playWithLLAt(int size, int rotation) {
        // TODO your implementation here
        if (rotation <= 0) {
            throw new RuntimeException("Invalid rotation");
        }
        if (size <= 0) {
            throw new RuntimeException("Invalid size");
        }
        List<Integer> ll = new LinkedList<Integer>();
        int temp = -1;
        // adding elements to Linkedlist
        for (int i = 1; i <= size; i++) {
            ll.add(i);
        }
        int move = 0;
        int sum = 0;
        int k = 0;
        while (true) {
            //calculating move
            move = (rotation % ll.size());
            if (move == 0) {
                move = ll.size();
            }
            sum = temp + move;
            temp = sum % ll.size();
            //killing the person at temp location
            ll.remove(temp);
            temp = temp - 1;
            if (ll.size() == 1) {
                break;
            }
        }
        return ll.get(0);
    }
}
