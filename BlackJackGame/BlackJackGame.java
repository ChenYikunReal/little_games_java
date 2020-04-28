import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class BlackJackGame {

	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		System.out.println("这个游戏需要两人进行比赛，由电脑给两者发放初始牌（底牌），"
				+ "玩家决定是否继续加牌，确保自己所有牌的\n点数和不"
				+ "超过21（J,Q,K按11, 12, 13记）。如果超过21，该玩家直接输掉比赛，"
				+ "如果两人都不再加牌，比较两人牌的总点数，点数大的人赢。");
        String card[]= {                                                       //创建整个牌组
        		"1","2","3","4","5","6","7","8","9","10","J","Q","K",
        		"1","2","3","4","5","6","7","8","9","10","J","Q","K",
        		"1","2","3","4","5","6","7","8","9","10","J","Q","K",
        		"1","2","3","4","5","6","7","8","9","10","J","Q","K"};
        List<String> card0=Arrays.asList(card);                               //转换牌组为集合
        List<String> card1 = new ArrayList<>(card0);                                    
        Random a=new Random();                              //创建随机数器并设置最大范围
        int index=51;                                                                                
        double pointP1=0.0,pointP2=0.0;                     //记录两玩家分数
        String judge="是";
        String p1=(String) card1.get(a.nextInt(index--));   //记录玩家1的底牌
        pointP1=point(p1);                                  //给玩家2得分
        card1.remove(p1);                                   //移除分发的牌
        String p2=(String) card1.get(a.nextInt(index--));   //同玩家1步骤
        pointP2=point(p2); 
        card1.remove(p2);                                   
        System.out.println("游戏开始\n玩家1的底牌是:"+p1+"\n玩家2的底牌是"+p2);
        System.out.println("玩家1分数："+pointP1);
        System.out.println("玩家2分数："+pointP2);
        System.out.println("玩家1要牌吗（是/否）");
        judge=input.next(); 
        while(judge.equals("是")) {                         //当玩家需要时重复给玩家发牌
        	 p1=(String) card1.get(a.nextInt(index--));
        	 System.out.println("你得到的牌是："+p1);
        	 pointP1=point(p1)+pointP1;
        	 System.out.println("玩家1分数："+pointP1);
             card1.remove(p1);
             if(pointP1>21) {
            	 System.out.println("玩家1输了");           //当玩家点数超过上限，直接输掉
            	 break;
             }else {
            	 System.out.println("还要牌吗？");
            	 judge=input.next();             }
        }System.out.println("玩家2要牌吗？（是/否）");
        judge=input.next(); 
        while(judge.equals("是")) {
       	 p2=(String) card1.get(a.nextInt(index--));
       	System.out.println("你得到的牌是："+p2);
       	 pointP2=point(p2)+pointP2;
       	System.out.println("玩家2分数："+pointP2);
            card1.remove(p2);
            if(pointP2>21) {
           	 System.out.println("玩家2输了");
           	 break;
            }else {
           	 System.out.println("还要牌吗？");
           	 judge=input.next();             }
       }if(pointP1<=21&&pointP2<=21) {                   //判断最终输赢
    	   if(pointP1>pointP2) {
    		   System.out.println("玩家1赢");
    	   }else if(pointP1<pointP2) {
    		   System.out.println("玩家2赢");
    	   }else {
    		   System.out.println("平局");
    	   }
       }else if(pointP1>21&&pointP2>21){
    	   System.out.println("平局");
       }
       input.close();
       
	}
	
	
	public static double point(String a) {     //判断玩家每次得分
		double point=0;
		switch (a){
		case "1":
		    point=1;
		    break;
		case "2":
		    point=2;
		    break;
		case "3":
		    point=3;
		    break;
		case "4":
		    point=4;
		    break;
		case "5":
		    point=5;
		    break;
		case "6":
		    point=6;
		    break;
		case "7":
		    point=7;
		    break;
		case "8":
		    point=8;
		    break;
		case "9":
		    point=9;
		    break;
		case "10":
		    point=10;
		    break;
		case "J":
		    point=11;
		    break;
		case "Q":
		    point=12;
		    break;
		case "K":
		    point=13;
		    break;
		}
		return point;
	}

}
