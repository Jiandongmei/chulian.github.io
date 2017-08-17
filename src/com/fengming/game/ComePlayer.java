package com.fengming.game;

public class ComePlayer {
    /*
    静态常量
     */
    public static final int MessageTypeQuan = 1;
    //出拳的时候的信息
    public static final int MessageTypeYing = 2;
            //赢的时候的信息
    public static final int MessageTypeShu = 3;
    //输的时候的信息

   private String name;
   private int fenshu;
   private int quan;
   /*
   角色出拳时候所说的个性化台词
    */
   private String [] quanWords ={
           "动感光波--biubiubiu",
           "大象你的鼻子为什么这么长",
           "必杀：露PP的外星人",
           "大姐姐你喜欢吃青椒嘛",
           "胸部平平的欧巴桑吃完一拳",


   };
   private String [] yingWords = {
           "还有哪个",
           "猜拳有点意思",
           "超神",
           "全军出击",
           "吃着火锅唱着歌然后你就输了",



   };
   private String [] shuWords = {
           "通往成功的路上总在施工",
           "等到潮水退去就知道那个在裸游",
           "将来我死了。把我的QQ捐给希望工程。希望孩子们一用到 QQ就是太阳",
           "夏天就是不好，穷的时候西北风都么有喝",
           " 我灰太狼一定会回来的",

   };
   /*
   根据传输的消息类型随机发送对应类型的消息

    */
   public void sendMessage(int msgType){
       /*
       随机生成1-5 的数字
        */
       int index = ((int )(Math.random()*1000))%5;
       String message = null;//要打印的消息
       switch (msgType){
           case MessageTypeQuan:
               message =quanWords[index];//随机输入的信息
               break;
           case MessageTypeYing:
               message = yingWords[index];

               break;
           case MessageTypeShu:
               message = shuWords[index];

               break;
       }
       System.out.println(message);//打印出来

   }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFenshu() {
        return fenshu;
    }

    public void setFenshu(int fenshu) {
        this.fenshu = fenshu;
    }

    public int getQuan() {
       quan = ((int)Math.random()*3000)%3+1;
        return quan;
    }


}
