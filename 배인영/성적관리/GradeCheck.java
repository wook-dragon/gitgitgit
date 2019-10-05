package Grade;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class GradeCheck {
	static HashMap<Integer, Grade> map = new HashMap<Integer, Grade>();
	static int count = 1;
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		GradeCheck gc = new GradeCheck();
		while (true) {
			System.out.println("������ �˾ƺ��ô�.");
			System.out.print("<1>�߰�  <2>����  <3>���  <4>����  <5>�ε�  <6>���� : ");

			switch (scan.nextInt()) {
			case 1: //�޸𸮿� �߰� 
				gc.add();
				break;
			case 2: //�޸𸮻���
				gc.delete();                   //���Ͽ� ����Ȱ͵� ��� ������ ����? 
				break;
			case 3: // ���         //�޸𸮻� �ִ°� ���. + ���� �ε��� �Ŀ� ����ص� ��µ� 
				gc.print();
				break;
			case 4: // ���� 
				gc.save();
				break;
			case 5: // �ε�
				gc.load();
				break;
			case 6: // ���� 
				gc.exit();
				break;
			}// switch
		} // while
	}// main

	// ��� - �޸𸮻� ����Ȱ� ���
	// ���� - ���Ϸ� ����
	// �ε� - ���Ϸ� ����Ȱ� ���

	private void add() {
		Grade grade = new Grade();
		map.put(count, grade.input(grade)); // ���⼭ �� input�ڸ��� grade�� ����?
		count++;
	}

	private void delete() { // ���⼭ �����Ǵ°� �޸𸮻� ����Ȱ͸� �����Ǵ°ǰ�?
		System.out.println("�����Ͻ� ��ȣ�� �Է��ϼ���.");
		int num = scan.nextInt();
		if (map.containsKey(num)) {
			map.remove(num);
			System.out.println("�����Ǿ����ϴ�.");
		} else {
			System.out.println("���� ��ȣ�� �߸��Է��ϼ̽��ϴ�.");
		}
	}

	private void print() {
		Set<Integer> set = map.keySet();
		System.out.println("��ȣ         ����          �ڹ�            ���̼�            ���            ���");
		for (Integer value : set) {
			double math = map.get(value).getMath();
			double java = map.get(value).getJava();
			double phyton = map.get(value).getPhyton();
			double avg = map.get(value).getAvg();
			String you = map.get(value).getYou();
			System.out.printf("[%s]  %.2f   %.2f   %.2f   %.2f   %s\n", value, math, java, phyton, avg, you); // value�� �������ڷ� �� �� �ֳ�?
		}
	}

	private void save() {
		File file = new File("grade.txt");

		try {
			FileOutputStream fo = new FileOutputStream(file);   //write
			ObjectOutputStream oos = new ObjectOutputStream(fo);

			oos.writeObject(map);

			oos.close();
			fo.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("����Ǿ����ϴ�.");
	}
	
	private void load() {
		File file = new File("grade.txt"); //grade ���� �ϳ��� ��~ ����Ǵ� �� 
		
		try {
			FileInputStream fs = new FileInputStream(file);     //read
			ObjectInputStream ois = new ObjectInputStream(fs);
			
			map = (HashMap<Integer, Grade>) ois.readObject(); //�о�°�  map�� ����    �̶� �����Ҷ� key���� key������, value���� value������ �˾Ƽ� ����ǳ�?
			
			System.out.println("��ȣ   ����   �ڹ�   ���̼�  ���  ��� ");
			Set<Integer> set = map.keySet();
			
			for(Integer value : set) {
				double math = map.get(value).getMath();
				double java = map.get(value).getJava();
				double phyton = map.get(value).getPhyton();
				double avg = map.get(value).getAvg();
				String you = map.get(value).getYou();
				System.out.printf("[%d]  %.2f   %.2f   %.2f   %.2f   %s\n",value, math, java, phyton, avg, you);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("�ҷ����µ� �����Ͽ����ϴ�.");
		}
	}
	
	private void exit() {
		System.out.println("�ý����� �����մϴ�.");
		System.exit(0);
		scan.close();  // ��ĵ�� ������ϳ�? 
	}

}
