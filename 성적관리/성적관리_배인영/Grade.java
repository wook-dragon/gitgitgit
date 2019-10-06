package Grade;

import java.io.Serializable;
import java.util.Scanner;

public class Grade implements Serializable{
	private double math = 0;
	private double java = 0;
	private double phyton = 0;
	private double avg = 0;
	private String you = null;
	
	public Grade input(Grade grade) {
		Scanner sc = new Scanner(System.in);
		System.out.print("수학점수 입력하세요. : ");
		this.math = Integer.parseInt(sc.nextLine());
		System.out.print("자바점수 입력하세요. : ");
		this.java = Integer.parseInt(sc.nextLine());
		System.out.print("파이선 점수를  입력하세요. : ");
		this.phyton = Integer.parseInt(sc.nextLine());
		
		this.avg = (this.math + this.java + this.phyton)/3; 
		if(this.avg >90)  {
			this.you = "A+";
		}else if (this.avg >80 && this.avg <=90) {
			this.you = "A";
		}else if (this.avg >70 && this.avg<=80) {
			this.you = "B+";
		}else if (this.avg >60 && this.avg <=70) {
			this.you = "B";
		}else {
			this.you = "C";
		}
		return grade;
	}

	public double getMath() {
		return math;
	}

	public void setMath(double math) {
		this.math = math;
	}

	public double getJava() {
		return java;
	}

	public void setJava(double java) {
		this.java = java;
	}

	public double getPhyton() {
		return phyton;
	}

	public void setPhyton(double phyton) {
		this.phyton = phyton;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}

	public String getYou() {
		return you;
	}

	public void setYou(String you) {
		this.you = you;
	}

	@Override
	public String toString() {
		return "Grade [math=" + math + ", java=" + java + ", phyton=" + phyton + ", avg=" + avg + ", you=" + you + "]";
	}
	
	
	
}
