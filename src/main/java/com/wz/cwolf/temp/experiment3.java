package com.wz.cwolf.temp;

import io.lettuce.core.ScanArgs;

import java.util.Calendar;
import java.util.Scanner;

/**
 * @author WangZhe
 * @version 1.0
 * @className experiment3
 * @description
 * @date 2022/12/7 10:01
 */

public class experiment3 {
    public static void main(String[] args) {
        Student Xiaoming = new Student("小明", "19", "男");
        System.out.println(Xiaoming);
        Student XiaoPeng = new Student();
        XiaoPeng.setName("小鹏");
        XiaoPeng.setAge("20");
        XiaoPeng.setSex(("男"));
        System.out.println(XiaoPeng);
    }
}

/**
 * 学生类封装
 */
class Student {
    private String name;
    private String age;
    private String sex;

    public Student() {
    }

    public Student(String name, String age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}

/**
 * 储蓄账户存取款模拟
 */
class bank {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double money = 10000;
        while (true) {
            System.out.println("******当前余额: " + money + "**********");
            System.out.println("*****银行操作界面:1.存钱，2取钱，0退出*********");
            int operator = scanner.nextInt();
            switch (operator) {
                case 1:
                    System.out.println("请输入存取金额");
                    double saveMoney = scanner.nextDouble();
                    money += saveMoney;
                    System.out.println("存钱成功");
                    break;
                case 2:
                    System.out.println("请输入存取金额");
                    double takeMoney = scanner.nextDouble();
                    if (money < takeMoney) {
                        System.out.println("取钱失败，余额不足");
                        break;
                    }
                    money -= takeMoney;
                    System.out.println("取钱成功");
                    break;
                case 0:
                    System.out.println("退出银行");
                    break;
                default:
                    System.out.println("输入错误,回到主页");
            }
            if(operator == 0) {
                break;
            }
        }
    }

}