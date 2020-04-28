import java.util.Random;
import java.util.Scanner;

public class GuessNumber2 {	
	public static void judge(int number) {
		if (number >= 100 && number <= 999) 
			return;
		else {
			System.err.println("数据不合法,程序结束");
			System.exit(0);
		}
	}
	
	public static void rejudge(int number1, int number2) {
		if (number1 > number2) 
			System.out.println("猜低了！");
		 else if (number1 < number2) 
			System.out.println("猜高了！");
		 else {
			System.out.println("恭喜你，猜对了！");
			System.exit(0);			 
		 }

	}
	
	public static void main(String[] args) {	
		Random r = new Random();			
		int setNumber = r.nextInt(900)+100;
		judge(setNumber);

		System.out.println("你至多有10次机会猜数字~~~");
		System.out.println("请输入一个三位整数");
		Scanner scan = new Scanner(System.in);
		
		for (int j= 0; j < 10; j++) {
			int getNumber = scan.nextInt();
			judge(getNumber);				
			rejudge(setNumber, getNumber);			
			if (j == 9) {
				System.out.println("要猜的数是：" + setNumber);
			}
		}	
		scan.close();
	}
}
