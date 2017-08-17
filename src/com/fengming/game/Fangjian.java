package com.fengming.game;

import java.util.Scanner;

public class Fangjian {
    /*
    属性 记分牌 游戏玩家 道具 房间号 房间名称 房间的密码
    方法 开始游戏 初始化 显示菜单 选择任务 判断输赢（可以定义在裁判类中）
     */
    private Renlei wanjia1 = null;
    private ComePlayer wanjia2 = null;
    //玩家
    private long fangjianid;
    //房间号
    private String fangjianname;
    //房间名称
    private String fangjianpass;
    //房间密码
    public Fangjian(String fangjianname ,String fangjianpass){
        if (!("酷安游戏总部".equals(fangjianname)&&"12345".equals(fangjianpass))){
            System.out.println("房间密码错误，强制退出");
            return;
        }
        this.setFangjianname(fangjianname);
        chuGame();
        kaiGame();
        jieGame();


    }
public void chuGame(){
    //初始化游戏


    //1：实例化玩家对象

    wanjia1 = new Renlei();
    wanjia2 = new ComePlayer();
//初始化其他属性
    //游戏动画
    for (int i = 0 ; i <100;i++){
        System.out.print("*")
        ;
        try {
            Thread.sleep(50);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("游戏加载成功,祝你玩的愉快");

    }


}

public void kaiGame(){
    xianCaidan();
    xuanRenwu();
    gameing();
}
/*
游戏的大循环
 */
    private void gameing() {
        while (true) {

            System.out.println(wanjia1.getName() + "请出拳:");
            Scanner input = new Scanner(System.in);
            wanjia1.setQuan(input.nextInt());
            int quan1 = wanjia1.getQuan();

            wanjia2.getQuan();
            int quan2 = wanjia2.getQuan();


            int result = panGame(quan1, quan2);
            if (result == -1) {
                System.out.println("《吉泳老师》：" + wanjia1.getName() + "胜利");
                wanjia1.sendMessage(Renlei.MessageTypeYing);
                wanjia2.sendMessage(ComePlayer.MessageTypeShu);
            } else if (result == 0) {
                System.out.println("双方打平");

                wanjia1.sendMessage(Renlei.MessageTypeQuan);
                wanjia2.sendMessage(ComePlayer.MessageTypeQuan);

            } else {
                System.out.println("《吉泳老师》：" + wanjia2.getName() + "胜利");
                wanjia2.sendMessage(ComePlayer.MessageTypeYing);
                wanjia1.sendMessage(ComePlayer.MessageTypeShu);

            }
            System.out.println("是否继续游戏！");
            String answer = new Scanner(System.in).next();
            if (!"y".equalsIgnoreCase(answer)) {
                break;
            }


            //开始游戏
        }
    }

    public void xianCaidan(){
    //显示菜单
    System.out.println("欢迎进入游戏《"+fangjianname+"》游戏房间");
    System.out.println("出拳规则: 1-石头 2-布 3-拳头");

}
public void xuanRenwu(){
    //显示人物
    System.out.println("对方角色: 1-风剑：2-妮妮：3-正南：4-阿呆  。。。。");
    System.out.println("请选择角色:");
    int renwu = new Scanner(System.in).nextInt();
    String [] nameArray ={"风剑","妮妮","正南","阿呆"};
    wanjia2.setName(nameArray[renwu-1]);
    wanjia1.setName("蜡笔小新");
    System.out.println(wanjia1.getName()+"VS"+wanjia2.getName());
}
public int panGame(int quan1,int quan2){

   if (quan1==quan2) return 0;
   if (quan1==1&&quan2==3 ||quan1 ==2&& quan2==1 ||quan1==3&&quan2==2){
       wanjia1.setFenshu(wanjia1.getFenshu()+1);
       wanjia2.setFenshu(wanjia2.getFenshu()-1);
       return -1;

   }
    wanjia1.setFenshu(wanjia1.getFenshu()-1);
    wanjia2.setFenshu(wanjia2.getFenshu()+1);
   return 1;


    //裁判
}
public void jieGame(){
    System.out.println(wanjia1.getName()+"\t"+wanjia2.getName());
    System.out.println(wanjia1.getFenshu()+"\t"+wanjia2.getFenshu());
    System.out.println("游戏已经结束，欢迎下次在来");

}

    public long getFangjianid() {
        return fangjianid;
    }

    public void setFangjianid(long fangjianid) {
        this.fangjianid = fangjianid;
    }

    public String getFangjianname() {
        return fangjianname;
    }

    public void setFangjianname(String fangjianname) {
        this.fangjianname = fangjianname;
    }

    public String getFangjianpass() {
        return fangjianpass;
    }

    public void setFangjianpass(String fangjianpass) {
        this.fangjianpass = fangjianpass;
    }
}
