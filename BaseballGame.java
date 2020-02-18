package baseballGame;

import java.util.*;

public class BaseballGame {
	int count, y_first, y_second, y_third, c_first, c_second, c_third, strike, ball;
	int[] arr = new int[10];

	BaseballGame() {
		for(int i = 0; i<arr.length;i++) {
			arr[i] = i;
		}
	}

	public void getRandomNumber() {
		Random rand = new Random();
		int temp, random;
		for(int i = 0; i<3;i++) {
			random = rand.nextInt(9);
			temp = arr[i];
			arr[i] = arr[random];
			arr[random] = temp;
		}
		c_first = arr[0];
		c_second = arr[1];
		c_third = arr[2];
	}

	public void setYourNumber() {
		Scanner scan = new Scanner(System.in);
		int yourNumber;
		while(true) {
			System.out.print("�� �ڸ� ���ڸ� �Է��Ͻÿ� : ");
			yourNumber = scan.nextInt();
			if(yourNumber > 0 && yourNumber < 1000) {
				break;
			}
			System.out.println("���� ������ �� ���� ���ּ���.");
		}
		y_first = yourNumber / 100;
		y_second = (yourNumber / 10) % 10;
		y_third = yourNumber % 10;

	}

	public void compare() {
		strike = 0; 
		ball = 0;
		if (c_first == y_first) {strike++;}
		if (c_second == y_second) {strike++;}
		if (c_third == y_third) {strike++;}
		if (c_first == y_second || c_first == y_third) {ball++;}
		if (c_second == y_first || c_second == y_third) {ball++;}
		if (c_third == y_first || c_third == y_second) {ball++;}
		count++;
	}



	public static void main(String[] args) {
		BaseballGame bg = new BaseballGame();
		bg.getRandomNumber();
		while(bg.count < 5) {
			bg.setYourNumber();
			bg.compare();
			System.out.println(bg.ball + "�� " + bg.strike + " ��Ʈ����ũ");
			System.out.println("��ȸ (" + bg.count + "/ 5)");
			System.out.println(bg.c_first +""+bg.c_second +""+ bg.c_third);
			System.out.println(bg.y_first +""+ bg.y_second +""+ bg.y_third);
			if(bg.strike >=3) {
				System.out.println("���ӿ��� �¸��ϼ̽��ϴ�.");
				System.exit(0);
			}
		}
		System.out.println("��� ��ȸ�� �������ϴ�. �ٽ� �������ּ���");
	}
}
