package com.wz.cwolf.temp;

import java.util.ArrayList;
import java.util.List;

/**
 * @className experiment9
 * @description 实验9:多线程编程 火车票购票
 * @date 2022/12/2 16:18
 */
public class experiment9 {
    public static void main(String[] args) {
//票库
        List<Ticket> tickets = new ArrayList<>();
        for (int i = 1; i <= 20 ; i++) {
            Ticket ticket = new Ticket(i,"G2022","郑州","重庆");
            tickets.add(ticket);
        }

        Ticker t1 = new Ticker();
        t1.setName("小红");
        Ticker t2 = new Ticker();
        t2.setName("小丽");
        //设置同一个票库
        t1.setTickets(tickets);
        t2.setTickets(tickets);
        //开始购票
        t1.start();
        t2.start();

    }
}
/**
 * 车票
 */
class Ticket {
    private Integer ticketNum; //票号
    private String trainNum; //车次
    private String Origin; //始发地
    private String destination; //目的地

    @Override
    public String toString() {
        return "票号=" + ticketNum +
                ", 车次=" + trainNum +
                "," + Origin +" ---> " + destination;
    }

    public Ticket() {
    }

    public Ticket(Integer ticketNum, String trainNum, String origin, String destination) {
        this.ticketNum = ticketNum;
        this.trainNum = trainNum;
        Origin = origin;
        this.destination = destination;
    }

    public Integer getTicketNum() {
        return ticketNum;
    }

    public void setTicketNum(Integer ticketNum) {
        this.ticketNum = ticketNum;
    }

    public String getTrainNum() {
        return trainNum;
    }

    public void setTrainNum(String trainNum) {
        this.trainNum = trainNum;
    }

    public String getOrigin() {
        return Origin;
    }

    public void setOrigin(String origin) {
        Origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
}

/**
 * 购票线程
 *  目的：多个人同时购票
 */
class Ticker extends Thread{
    private List<Ticket> tickets; //票库（多个人购买同一个票库）


    //购票方法（从集合中删除一张票）
    public void sellingTickets(){
        //从票库删除一张票
        Ticket ticket = this.tickets.remove(0);
        System.out.println(this.getName()+"买了一张："+ticket);
    }

    @Override
    public void run() {
        //实现多线程购票，“买完为止”
        while(true){
            synchronized (this.tickets){
                //如果剩余有票，则调用购票方法
                if(this.tickets.size()>0){
                    sellingTickets();//调用购票方法
                }else{
                    //否则，票已售完
                    System.out.println(this.getName()+":票已售罄！");
                    break;
                }
            }
        }
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }
}


