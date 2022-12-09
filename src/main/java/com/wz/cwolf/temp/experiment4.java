package com.wz.cwolf.temp;

/**
 * @className experiment4
 * @description 实验4：薪酬计算
 * @date 2022/12/7 10:01
 */

public class experiment4 {
    public static void main(String[] args) {
        Worker worker = new Teacher(1000,2);
        System.out.println("教师工资：" + worker.getSalary());
        worker = new Engineer(500, 3);
        System.out.println("工程师工资：" + worker.getSalary());

    }
}

interface Worker {
    double getSalary();
}

class Teacher implements Worker {
    private double base;
    private double x;

    public Teacher(double base, double x) {
        this.base = base;
        this.x = x;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    @Override
    public double getSalary() {
        return base*x*2;
    }
}

class Engineer implements Worker {
    private double base;
    private double x;

    public Engineer(double base, double x) {
        this.base = base;
        this.x = x;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    @Override
    public double getSalary() {
        return base*x*1;
    }
}