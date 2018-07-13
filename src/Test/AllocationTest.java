package Test;
//import java.util.Arra

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Vector;

/**
 * Created by Interllij IDEA
 * User:Zqc
 * Data:2018/6/19
 * Time:16:48
 * Email:quanchaozhao@yeah.net
 * To change this template use File | Settings | File Templates.
 */
public class AllocationTest {
    private static final int _1MB = 1024 * 1024;

    /*
     *     -Xms20M -Xmx20M -Xmn10M
        -XX:SurvivorRatio=8
        -XX:+PrintGCDetails
        -XX:+UseSerialGC
        -XX:+HandlePromotionFailure
     * */

    public static void testHandlePromotion() {
        byte[] allocation1, allocation2, allocation3, allocation4, allocation5, allocation6, allocation7,
                allocation8;
        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];
        allocation1 = null;
        allocation4 = new byte[2 * _1MB];
        allocation5 = new byte[2 * _1MB];
        allocation6 = new byte[2 * _1MB];
//        allocation4 = null;
//        allocation5 = null;
//        allocation6 = null;
//        allocation7 = new byte[2 * _1MB];
//        allocation8 = new byte[1 * _1MB];
//        System.gc();
    }

    public static void main(String[] args) {
//        testHandlePromotion();
        ArrayList <String> s = new ArrayList();
        s.add("ddd");
        switch (s.get(0)){
            case "d":
                System.out.println("dd");
                break;
            case "D":
                System.out.println("DD");
                break;
                default:
                    System.out.println("DEFAULT");
        }
        Object o = null;
        AllocationTest t = new AllocationTest();
        LinkedList lk = new LinkedList();
        lk.add("1");
        lk.add("2");
        lk.offerFirst("D");
        lk.addFirst("first");
        Vector vector = new Vector();
        Stack stack = new Stack();
        stack.push("me");
        stack.push("you");
        Object ss = stack.peek();
        System.out.println("stack.peek():" + ss.toString());
        ss = stack.pop();
        System.out.println("stack.pop():" +ss.toString());
        for (Object str:stack
             ) {
            System.out.println(str.toString());
        }

    }
}
