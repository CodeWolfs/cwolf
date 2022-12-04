package com.wz.cwolf.temp;

import java.util.Scanner;

/**
 * @className experiment1
 * @description 实验1:入门 Java程序编辑、编译、运行、调试，输入，输出，用多种方法求平均值
 * @date 2022/12/2 16:18
 */


public class experiment1 {
    public static void main(String[] args) {
        //输入多个数字，并求其和与平均值，每输一个数用空格确认
        System.out.println("输入多个数字，并求其和与平均值，每输一个数用空格确认,输入非数字进行计算");
        Scanner scanner = new Scanner(System.in);

        //和
        double sum = 0;
        //计算输了多少个数字
        int m=0;
        //通过循环判断是否还有输入，并在里面对每一次进行求和统计
        while (scanner.hasNextDouble()){
            double x = scanner.nextDouble();
            m++;
            sum=sum+x;
            System.out.println("你输入了第"+m+"个数据，当前数据的sum="+sum );
        }
        System.out.println(m+"个数和为："+sum);
        System.out.println(m+"个数的平均数为："+(sum/m));
        scanner.close();
    }
}
