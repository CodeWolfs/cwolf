package com.wz.cwolf.temp;

/**
 * @className experiment5
 * @description 实验5:接口 各种形状的面积与周长计算
 * @date 2022/12/2 16:18
 */
public class experiment5 {
    public static void main(String[] args) {
        //测试矩形
        Rectangle rectangle=new Rectangle(3, 8);
        System.out.println("长为3，宽是8的矩形的周长是： "+rectangle.getGirth());
        System.out.println("长为3，宽是8的矩形的面积是： "+rectangle.getArea());
        //测试圆形类，求圆形的周长和面积
        Circle circle=new Circle(9);
        System.out.println("\n半径是9的圆的周长是： "+circle.getGirth());
        System.out.println("半径是9的圆的面积是： "+circle.getArea());
        //测试三角形类，求三角形的周长和面积
        Triangle triangle=new Triangle(3,4,5);
        System.out.println("\n边长为3,4,5的三角形的周长是： "+triangle.getGirth());
        System.out.println("边长为3,4,5的三角形的面积是： "+triangle.getArea());
    }
}

/**
 * 形状2D接口
 */
interface Shape2D {
    Double getArea();
    Double getGirth();
}

/**
 * 圆
 */
class Circle implements Shape2D {

    private final double r; //圆的半径

    public Circle(double r) {
        this.r = r;
    }

    @Override
    public Double getArea() {
        return Math.PI*r*r;
    }

    @Override
    public Double getGirth() {
        return 2*Math.PI*r;
    }

}

/**
 * 三角形
 */
class Triangle implements Shape2D {

    private final double a;
    private final double b;
    private final double c;

    public Triangle(double a, double b, double c) {
        this.a=a;
        this.b=b;
        this.c=c;
    }


    @Override
    public Double getArea() {
        double p = (a+b+c)/2.0;
        return Math.sqrt(p*(p-a)*(p-b)*(p-c));
    }

    @Override
    public Double getGirth() {
        return a+b+c;
    }

}

/**
 * 矩形
 */
class Rectangle implements Shape2D {

    private final double  a;
    private final double  b;

    public Rectangle(double a,double b) {
        this.a=a;
        this.b=b;
    }

    public Double getArea() {
        return a*b;
    }
    public Double getGirth() {
        return 2*(a+b);
    }

}