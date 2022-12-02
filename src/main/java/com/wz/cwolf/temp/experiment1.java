package com.wz.cwolf.temp;

import java.util.Scanner;

/**
 * @author WangZhe
 * @version 1.0
 * @className experiment1
 * @description
 * @date 2022/12/2 16:18
 */


public class experiment1 {
    public static void main(String[] args) {
        System.out.println("请输入一组数字回车提交，输入/n 结束输入");
        Scanner scanner = new Scanner(System.in);

        String tempStr = "/n";
        do {
            tempStr = scanner.nextLine();
            double v = Double.parseDouble(tempStr);
            System.out.println(v);

        }while (!tempStr.equals("/n"));
    }

}
