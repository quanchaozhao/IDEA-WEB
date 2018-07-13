package com.pattern.Singleton;

/**
 * Created by Interllij IDEA
 * User:Zqc
 * Data:2018/6/15
 * Time:10:43
 * Email:quanchaozhao@yeah.net
 * To change this template use File | Settings | File Templates.
 */
public class Demo {

    public static void main(String[] args) {
        SingleObject singleObject = SingleObject.getInstance();
        singleObject.showMessage();

        SingleObjectSynchronize singleObjectSynchronize = SingleObjectSynchronize.getInstance();
        singleObjectSynchronize.showMessage();


        SingleObjectClassLoad singleObjectClassLoad = SingleObjectClassLoad.getInstance();
        singleObjectClassLoad.showMessage();

        SingleObjectDCL singleObjectDCL = SingleObjectDCL.getSingleObjectDCL();
        singleObjectDCL.showMessage();

        SingleStaticInnerClass singleStaticInnerClass = SingleStaticInnerClass.getInstance();
        singleStaticInnerClass.showMessage();

        SingleEnum s = SingleEnum.DOSOMETHING;
        SingleEnum[] enums = {SingleEnum.INSTANCE, SingleEnum.DOSOMETHING};
        System.out.println(enums[0].name());
        s.showMessage();
    }
}

//懒汉式，不支持多线程，缓初始化
class SingleObject {
    private SingleObject() {
    }

    private static SingleObject instance;

    public static SingleObject getInstance() {
        if(instance == null) {
            instance = new SingleObject();
        }
        return instance;
    }

    public void showMessage() {
        System.out.println("Hello world");
    }
}

//懒汉式，使用synchronize，支持多线程，缓初始化
class SingleObjectSynchronize {
    private static SingleObjectSynchronize instance;

    private SingleObjectSynchronize() {
    }

    public static synchronized SingleObjectSynchronize getInstance() {
        if (instance == null) {
            instance = new SingleObjectSynchronize();
        }
        return instance;
    }

    public void showMessage() {
        System.out.println("Hello world,synchronized");
    }
}

//饿汉式，支持多线程，直接初始化，使用classload机制
class SingleObjectClassLoad {
    private static SingleObjectClassLoad instance = new SingleObjectClassLoad();

    public SingleObjectClassLoad() {
    }

    public static SingleObjectClassLoad getInstance() {
        return instance;
    }


    public void showMessage() {
        System.out.println("Hello world,class load.");
    }
}

//双重校验锁*(DCL)，缓初始化，支持多线程,使用volatile，synchronize
//volatile 保证可见性和有序性（禁止指令重排序）
class SingleObjectDCL {
    private volatile static SingleObjectDCL singleObjectDCL;

    private SingleObjectDCL() {
    }

    public static SingleObjectDCL getSingleObjectDCL() {
        if (singleObjectDCL == null) {
            synchronized (SingleObjectDCL.class) {
                if (singleObjectDCL == null) {
                    singleObjectDCL = new SingleObjectDCL();
                }
            }
        }
        return singleObjectDCL;
    }

    public void showMessage() {
        System.out.println("Hello world,volatile synchronized");
    }
}

//静态内部类，缓初始化，支持多线程，使用类加载机制。
class SingleStaticInnerClass {
    private static class SingleHoler {
        private static final SingleStaticInnerClass INSTANCE = new SingleStaticInnerClass();
    }

    private SingleStaticInnerClass() {
    }

    public static final SingleStaticInnerClass getInstance() {
        return SingleHoler.INSTANCE;
    }

    public void showMessage() {
        System.out.println("Hello world, static inner class (final)");
    }
}

//枚举，直接初始化，支持多线程，使用枚举类型

enum SingleEnum {
    INSTANCE, DOSOMETHING;

    //    private SingleEnum(){}
    public void showMessage() {
        System.out.println("Hello world, in Enum ");
    }
}