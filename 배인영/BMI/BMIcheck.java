import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class BMIcheck {
	static HashMap<Integer, BMI> map = new HashMap<Integer, BMI>();   // �� static����?
	static int count = 1;
	static Scanner scan = new Scanner(System.in); // �� static����?
	File file = new File("mybmi.txt");  //����� ������ �ε�/���� �޼ҵ忡�� ���� �� ���ִ��� �����ǰ�?

	
	
	public static void main(String[] args) {
		BMIcheck bmi = new BMIcheck();            //BMIcheck �ȿ� �ִ� ���θ޼ҵ��ε� �̷��� �� ������ϳ�?
		
		do {
			System.out.println("BMI�� �����մϴ�.");
			System.out.println("1.�߰�   2.����   3.���   4.����   5.�ε�   6.����");
			int select = Integer.parseInt(scan.nextLine());
			switch(select) {
			case 1: //�߰�
				bmi.add();  // �޸𸮿� �߰�
				break;
			case 2: //����
				bmi.delete();   //�޸� ����
				break;
			case 3: //���
				bmi.print();   // �޸� ���
				break;
			case 4: //����
				bmi.save();    //���Ϸ� ����
				break;
			case 5: //�ε�
				bmi.load();    //���Ϸ� ����Ȱ� �ҷ���
				break;
			case 6: //����
				bmi.exit();
				break;
			//default : System.out.println("�ٽ��Է��ϼ���.");
			}
		}while(true); 
		

	}//Main 
	
	private void add() { // 1.�߰�
		BMI bmi = new BMI();
		map.put(count++, bmi.input(bmi));  // ++count ����� �ص� �����Ѱ���?
		System.out.println("�߰��Ǿ����ϴ�.");
	}
	
	private void delete() { // 2.����
		System.out.println("������ ��ȣ�� �Է����ּ���.");
		int num = Integer.parseInt(scan.nextLine()); 
		if(map.containsKey(num)) {
			map.remove(num);
		}else { 
			System.out.println("�߸��Է��ϼ̽��ϴ�." ); // �ٽ� �Է����ּ���. ����? �� ������ �ܼ�â�� ���� �Ѿ��?
		}
	} //count�����ϸ� �����̶� ������ȣ�� ������? �ƴϸ�, ä������? �ƴϸ� ������ �������? 
	
	private void print() { //3. ���
		System.out.println("����Ʈ�� ����մϴ�.");
		
		Iterator<Integer> iterator = map.keySet().iterator();
		System.out.println("��ȣ             Ű              ������        ���         ����");
		while(iterator.hasNext()) {
			Integer key = iterator.next();
			double length = map.get(key).getLength();
			double weight = map.get(key).getWeight();
			double result = map.get(key).getResult();
			String you = map.get(key).getYou();

			System.out.printf("[%d]     %.2f     %.2f     %.2f     %s\n", key, length, weight, result, you);
		}
	}
	
	private void save() { //4. ����


		try {
			FileOutputStream fos = new FileOutputStream(file);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			ObjectOutputStream oos = new ObjectOutputStream(bos);
			
			oos.writeObject(map);
			oos.close();
			bos.close();
			fos.close();
			
		} catch (Exception e) {
			System.out.println("��������");
			e.printStackTrace();
		}
	}
	
	private void load() { //5. �ε�

		FileInputStream fis = null;
		BufferedInputStream bis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);
			ois = new ObjectInputStream(bis);
			
			map = (HashMap<Integer, BMI>) ois.readObject();
			
			Iterator<Integer> iterator = map.keySet().iterator();
			System.out.println("��ȣ             Ű              ������        ���         ����");
			while(iterator.hasNext()) {
				Integer key = iterator.next();
				double length = map.get(key).getLength();
				double weight = map.get(key).getWeight();
				double result = map.get(key).getResult();
				String you = map.get(key).getYou();
	
				System.out.printf("[%d]     %.2f     %.2f     %.2f     %s\n",key, length, weight, result, you);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				ois.close();
				bis.close();
				fis.close();
			} catch (IOException e) {

				e.printStackTrace();
			}
		}
	}
	
	private void exit() {
		System.out.println("�ý����� �����մϴ�.");
		System.exit(0);
		scan.close();
	}
	

}
