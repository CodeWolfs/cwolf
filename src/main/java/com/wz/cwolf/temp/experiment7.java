package com.wz.cwolf.temp;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @className experiment7
 * @description 实验7:集合框架 成绩处理的ArrayList版本
 * @date 2022/12/2 16:18
 */
public class experiment7 {
    public static void main(String[] args) {
        System.out.println("请输入多个成绩以空格分开，以非数字字符作为结尾标志");
        Scanner scanner = new Scanner(System.in);
        ArrayList<Double> scoreList = new ArrayList<>();

        while (scanner.hasNextDouble()){
            double score = scanner.nextDouble();
            scoreList.add(score);
        }
        double sumScore = scoreList.stream().mapToDouble(Double::doubleValue).sum();   //总分
        double aveScore = scoreList.stream().mapToDouble(Double::doubleValue).average().getAsDouble();   //平均分
        double maxScore = Collections.max(scoreList);    //最高分
        double minScore = Collections.min(scoreList);    //最低分
        double sumPeople = scoreList.size();  //总考试人数
        long excellentPeople = scoreList.stream().filter(score -> score >= 90).count(); //优秀人数score>=90
        long goodPeople = scoreList.stream().filter(score -> score < 90 && score >= 70).count(); //良好人数90>score>=70
        long passPeople = scoreList.stream().filter(score -> score < 70 && score >= 60).count(); //及格人数70>score>=60
        long failPeople = scoreList.stream().filter(score -> score < 60 ).count(); //不及格人数60>score
        System.out.println("平均分:" + aveScore);
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
