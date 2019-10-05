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
			System.out.println("성적을 알아봅시다.");
			System.out.print("<1>추가  <2>삭제  <3>출력  <4>저장  <5>로드  <6>종료 : ");

			switch (scan.nextInt()) {
			case 1: //메모리에 추가 
				gc.add();
				break;
			case 2: //메모리삭제
				gc.delete();                   //파일에 저장된것도 어떻게 삭제가 되지? 
				break;
			case 3: // 출력         //메모리상에 있는것 출력. + 파일 로드한 후에 출력해도 출력됨 
				gc.print();
				break;
			case 4: // 저장 
				gc.save();
				break;
			case 5: // 로드
				gc.load();
				break;
			case 6: // 종료 
				gc.exit();
				break;
			}// switch
		} // while
	}// main

	// 출력 - 메모리상 저장된거 출력
	// 저장 - 파일로 저장
	// 로드 - 파일로 저장된거 출력

	private void add() {
		Grade grade = new Grade();
		map.put(count, grade.input(grade)); // 여기서 왜 input자리에 grade를 넣지?
		count++;
	}

	private void delete() { // 여기서 삭제되는건 메모리상에 저장된것만 삭제되는건가?
		System.out.println("삭제하실 번호를 입력하세요.");
		int num = scan.nextInt();
		if (map.containsKey(num)) {
			map.remove(num);
			System.out.println("삭제되었습니다.");
		} else {
			System.out.println("고객님 번호를 잘못입력하셨습니다.");
		}
	}

	private void print() {
		Set<Integer> set = map.keySet();
		System.out.println("번호         수학          자바            파이선            평균            결과");
		for (Integer value : set) {
			double math = map.get(value).getMath();
			double java = map.get(value).getJava();
			double phyton = map.get(value).getPhyton();
			double avg = map.get(value).getAvg();
			String you = map.get(value).getYou();
			System.out.printf("[%s]  %.2f   %.2f   %.2f   %.2f   %s\n", value, math, java, phyton, avg, you); // value를 순서숫자로 쓸 수 있네?
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
		System.out.println("저장되었습니다.");
	}
	
	private void load() {
		File file = new File("grade.txt"); //grade 파일 하나에 쭉~ 저장되는 것 
		
		try {
			FileInputStream fs = new FileInputStream(file);     //read
			ObjectInputStream ois = new ObjectInputStream(fs);
			
			map = (HashMap<Integer, Grade>) ois.readObject(); //읽어온걸  map에 저장    이때 저장할때 key값은 key값으로, value값은 value값으로 알아서 저장되나?
			
			System.out.println("번호   수학   자바   파이선  평균  결과 ");
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
			System.out.println("불러오는데 실패하였습니다.");
		}
	}
	
	private void exit() {
		System.out.println("시스템을 종료합니다.");
		System.exit(0);
		scan.close();  // 스캔도 꺼줘야하나? 
	}

}
