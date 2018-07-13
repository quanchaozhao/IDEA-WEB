package com.zqc;

import java.io.*;
import java.util.Scanner;

/**
 * Created by Interllij IDEA
 * User:Zqc
 * Data:2018/5/17
 * Time:17:24
 * Email:quanchaozhao@yeah.net
 * To change this template use File | Settings | File Templates.
 */
public class Test {
    public static void main(String[] args) {
        String[] agg = {"Test2.txt", "Name : 中文", "Age : 26", "occupation : Student"};
        System.out.println(agg[10]);
        //        new Test().writeStringByOutputStreamWriter(agg);
//        System.out.println("Start");
////        new Test().writeString(agg);
//        System.out.println("Over");
        System.out.println("请输入数据：（按Q或q结束！）");
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String string = scanner.nextLine();
            if(!string.equalsIgnoreCase("q"))
                System.out.println("数据为：" + string);
            else
                break;
            System.out.println("请输入数据：（按Q或q结束！）");
        }
//        Console console = System.console();
//        String userName = console.readLine("User Name：");
//        char[] passwd = console.readPassword("Password:");
//        System.out.println(passwd);
    }

    int s1, s2;

    public Test(int s1) {
        this.s1 = s1;
    }

    public Test() {
    }

    public void writeStringByOutputStreamWriter(String... args) {
        File file = new File(args[0]);
        FileOutputStream fileOutputStream = null;
        FileWriter fileWriter = null;
        OutputStreamWriter writer = null;
        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = new BufferedWriter(writer);
            fileOutputStream = new FileOutputStream(file);
            writer = new OutputStreamWriter(fileOutputStream, "UTF-8");
            fileWriter = new FileWriter(file);
            for (String arg : args) {
                fileWriter.write(arg);
                fileWriter.append("\n");
                writer.write(arg);
                writer.append("\n");
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                writer.close();
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void writeString(String... args) {
        OutputStream outputStream = null;
        File file = new File(args[0]);
        FileOutputStream fileOutputStream = null;
        OutputStreamWriter outputStreamWriter = null;
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileOutputStream = new FileOutputStream(file);
//           bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            outputStreamWriter = new OutputStreamWriter(fileOutputStream);
            bufferedWriter = new BufferedWriter(outputStreamWriter);
            for (int i = 1; i < args.length; i++) {
                bufferedWriter.write(args[i]);
                bufferedWriter.newLine();
            }
            bufferedWriter.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedWriter.close();
                outputStreamWriter.close();
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
