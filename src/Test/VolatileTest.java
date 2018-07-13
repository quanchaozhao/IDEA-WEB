package Test;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.net.URISyntaxException;
import java.util.HashSet;
import java.util.Set;

import sun.jvmstat.monitor.*;

/**
 * Created by Interllij IDEA
 * User:Zqc
 * Data:2018/7/10
 * Time:15:40
 * Email:quanchaozhao@yeah.net
 * To change this template use File | Settings | File Templates.
 */
public class VolatileTest {
    public static volatile int race = 0;

    public static void increase() {
        race++;
    }

    private static final int THREADS_COUN = 20;

    public static void main(String[] args) throws InterruptedException {
        System.out.println("current thread count: " + Thread.activeCount());
        try {

            MonitoredHost local = MonitoredHost.getMonitoredHost("localhost");
            Set<?> vmlist = new HashSet<Object>(local.activeVms());
            for (Object process : vmlist) {
                MonitoredVm vm = local.getMonitoredVm(new VmIdentifier("//" + process));
                String processname = MonitoredVmUtil.mainClass(vm, true);
                System.out.println(process + "------>" + processname);

            }
        } catch (MonitorException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
//        Thread[] threads = new Thread[THREADS_COUN];
//        for (int i = 0; i < THREADS_COUN; i++) {
//            threads[i] = new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    for (int i = 0; i < 1000; i++){
//                        increase();
//                    }
//                }
//            });
//            threads[i].start();
//        }
        while (Thread.activeCount() > 2) {
            Thread.yield();
        }
        System.out.println(race);
        Thread t = new Thread();
        System.out.println(t.getState());
//        Thread t2 = new Thread() {
//            @Override
//            public void run() {
//                for (int i = 0; i < Integer.MAX_VALUE; i++) {
//                    System.out.println(i);
//                }
//            }
//        };
//        t2.start();
//        System.out.println(t2.getState());


        final Object lock = new Object();
        Runnable run = new Runnable() {
            @Override
            public void run() {
                System.out.println("go");
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
//                for (int  i = 0; i < Integer.MAX_VALUE; i++){
//                    synchronized (lock){
//                        System.out.println(i);
//                    }
                }
//            }
        };
        Thread t3 = new Thread(run);
        t3.setName("t3");
        Thread t4 = new Thread(run);
        t4.setName("t4");

        t3.start();
        t4.start();
        System.out.println("t4:" + t4.getState() + ",t3:" + t3.getState());
    }
}
