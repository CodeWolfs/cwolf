package com.wz.cwolf.temp;

/**
 * @className experiment1
 * @description 实验6:异常处理 数据处理中的异常处理
 * @date 2022/12/2 16:18
 */
public class experiment6 {
    public static void main(String[] args) {
        System.out.println("try 前");
        try {
            System.out.println("异常 前");
            int i = 1 / 0;
            System.out.println("异常 后");

        } catch (ArithmeticException e) {
            e.printStackTrace();
        } finally {
            System.out.println("finally 最终执行");
        }
        System.out.println("try 后");
    }
}
