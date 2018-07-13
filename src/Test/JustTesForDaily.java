package Test;

import java.util.Vector;

/**
 * Created by Interllij IDEA
 * User:Zqc
 * Data:2018/7/11
 * Time:9:53
 * Email:quanchaozhao@yeah.net
 * To change this template use File | Settings | File Templates.
 */
public class JustTesForDaily {
    private static Vector<Integer> vector = new Vector<>();

    public static void main(String[] args) {
        while (true) {
            for (int i = 0; i < 10; i++) {
                vector.add(i);
            }

            Thread removeThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    synchronized (vector) {
                        for (int i = 0; i < vector.size(); i++) {
                            try {
                                vector.remove(i);
                            } catch (ArrayIndexOutOfBoundsException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            });
            Thread printThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    synchronized (vector) {
                        for (int i = 0; i < vector.size(); i++) {
                            System.out.println(vector.get(i));

                        }
                    }
                }
            });

            removeThread.start();
            printThread.start();
            while (Thread.activeCount() > 20) ;

        }
    }
}
