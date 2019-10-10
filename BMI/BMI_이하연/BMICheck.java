import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Scanner;

public class BMICheck {
	static HashMap<Integer, BMI> map = new HashMap<Integer, BMI>();
	static Scanner sc = new Scanner(System.in);
	static int count = 1;

	public static void main(String[] args) {
		BMICheck bc = new BMICheck();
		while (true) {
			System.out.println("1.추가  2.삭제  3.저장  4.종료");

			switch (sc.nextInt()) {
			case 1:
				bc.add();
				break;
			case 2:
				bc.delete();
				break;
			case 3:
				bc.save();
				break;
			case 4:
				bc.exit();
				break;
			}

		}
	}

	private void add() {


		BMI bmi = new BMI();
		map.put(count, bmi.input(bmi));
		count++;
	}

	private void delete() {
		System.out.print("삭제할 번호를 입력해 주세요 : ");

		int num = sc.nextInt();
		map.remove(num);
		System.out.println("삭제되었습니다.");
	}

	private void save() {
		File file = new File("bmi.txt");try
		{
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			oos.writeObject(map);

			oos.close();
			fos.close();
		}catch(
				Exception e)
		{
			System.out.println("에러");
			e.printStackTrace();
		}System.out.println("저장되었습니다.");
	}

	private void exit() {
		System.out.println("시스템을 종료합니다.");
		System.exit(0);
		sc.close();
	}
}

