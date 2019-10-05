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
	static HashMap<Integer, BMI> map = new HashMap<Integer, BMI>();   // 왜 static이지?
	static int count = 1;
	static Scanner scan = new Scanner(System.in); // 왜 static이지?
	File file = new File("mybmi.txt");  //여기다 놓던지 로드/저장 메소드에서 새로 뉴 해주던지 같은건가?

	
	
	public static void main(String[] args) {
		BMIcheck bmi = new BMIcheck();            //BMIcheck 안에 있는 메인메소드인데 이렇게 뉴 해줘야하나?
		
		do {
			System.out.println("BMI를 측정합니다.");
			System.out.println("1.추가   2.삭제   3.출력   4.저장   5.로드   6.종료");
			int select = Integer.parseInt(scan.nextLine());
			switch(select) {
			case 1: //추가
				bmi.add();  // 메모리에 추가
				break;
			case 2: //삭제
				bmi.delete();   //메모리 삭제
				break;
			case 3: //출력
				bmi.print();   // 메모리 출력
				break;
			case 4: //저장
				bmi.save();    //파일로 저장
				break;
			case 5: //로드
				bmi.load();    //파일로 저장된거 불러옴
				break;
			case 6: //종료
				bmi.exit();
				break;
			//default : System.out.println("다시입력하세요.");
			}
		}while(true); 
		

	}//Main 
	
	private void add() { // 1.추가
		BMI bmi = new BMI();
		map.put(count++, bmi.input(bmi));  // ++count 선취로 해도 가능한가요?
		System.out.println("추가되었습니다.");
	}
	
	private void delete() { // 2.삭제
		System.out.println("삭제할 번호를 입력해주세요.");
		int num = Integer.parseInt(scan.nextLine()); 
		if(map.containsKey(num)) {
			map.remove(num);
		}else { 
			System.out.println("잘못입력하셨습니다." ); // 다시 입력해주세요. 가능? 이 다음에 콘솔창이 어디로 넘어가지?
		}
	} //count삭제하면 누적이라서 다음번호가 나오나? 아니면, 채워지나? 아니면 앞으로 당겨지나? 
	
	private void print() { //3. 출력
		System.out.println("리스트를 출력합니다.");
		
		Iterator<Integer> iterator = map.keySet().iterator();
		System.out.println("번호             키              몸무게        결과         판정");
		while(iterator.hasNext()) {
			Integer key = iterator.next();
			double length = map.get(key).getLength();
			double weight = map.get(key).getWeight();
			double result = map.get(key).getResult();
			String you = map.get(key).getYou();

			System.out.printf("[%d]     %.2f     %.2f     %.2f     %s\n", key, length, weight, result, you);
		}
	}
	
	private void save() { //4. 저장


		try {
			FileOutputStream fos = new FileOutputStream(file);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			ObjectOutputStream oos = new ObjectOutputStream(bos);
			
			oos.writeObject(map);
			oos.close();
			bos.close();
			fos.close();
			
		} catch (Exception e) {
			System.out.println("에러에러");
			e.printStackTrace();
		}
	}
	
	private void load() { //5. 로드

		FileInputStream fis = null;
		BufferedInputStream bis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);
			ois = new ObjectInputStream(bis);
			
			map = (HashMap<Integer, BMI>) ois.readObject();
			
			Iterator<Integer> iterator = map.keySet().iterator();
			System.out.println("번호             키              몸무게        결과         판정");
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
		System.out.println("시스템을 종료합니다.");
		System.exit(0);
		scan.close();
	}
	

}
