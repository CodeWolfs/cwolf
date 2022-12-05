package com.wz.cwolf.temp;

import java.text.NumberFormat;
import java.util.Scanner;

/**
 * @className experiment2
 * @description 实验2:控制流程 输入多个成绩，统计平均分、最高分、最低分、总考试人数、各级别人数、各级别人数占总考试人数的百分比
 * @date 2022/12/2 16:18
 */
public class experiment2 {
    public static void main(String[] args) {
        System.out.println("请输入多个成绩以空格分开，以非数字字符作为结尾标志");
        Scanner scanner = new Scanner(System.in);
        double sumScore = 0;   //总分
        double aveScore = 0;   //平均分
        double maxScore = 0;    //最高分
        Double minScore = null;    //最低分
        double sumPeople = 0d;  //总考试人数
        int excellentPeople = 0; //优秀人数score>=90
        int goodPeople = 0; //良好人数90>score>=70
        int passPeople = 0; //及格人数70>score>=60
        int failPeople = 0; //不及格人数60>score

        while (scanner.hasNextDouble()){
            double score = scanner.nextDouble();
            sumScore += score;
            if(maxScore < score) {
                maxScore = score;
            }
            if (minScore == null || minScore > score) {
                minScore = score;
            }
            sumPeople++;
            if(score >= 90) {
                excellentPeople++;
            } else if(score >= 70) {
                goodPeople++;
            } else if(score >= 60) {
                passPeople++;
            } else {
                failPeople++;
            }
        }
        System.out.println("平均分:" + sumScore/sumPeople);
        System.out.println("最高分:" + maxScore);
        System.out.println("最低分:" + minScore);
        System.out.println("总考试人数:" + (int)sumPeople);
        System.out.println("各级别人数及占比情况---start---");
        NumberFormat percentInstance = NumberFormat.getPercentInstance();
        percentInstance.setMinimumFractionDigits(2);
        System.out.println("优秀人数:" + excellentPeople + ",占比:" + percentInstance.format(excellentPeople/sumPeople));
        System.out.println("良好人数:" + goodPeople + ",占比:" + percentInstance.format(goodPeople/sumPeople));
        System.out.println("及格人数:" + passPeople + ",占比:" + percentInstance.format(passPeople/sumPeople));
        System.out.println("不及格人数:" + failPeople + ",占比:" + percentInstance.format(failPeople/sumPeople));
        System.out.println("各级别人数及占比情况---end---");

    }
}
