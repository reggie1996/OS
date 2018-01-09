package test1;

public class Main {
	public static void main(String[] args) {
		
		MyThread thread1 = new MyThread("1", 9, 9);
		MyThread thread2 = new MyThread("2", 2, 8);
		MyThread thread3 = new MyThread("3", 3, 7);
		MyThread thread4 = new MyThread("4", 4, 6);
		MyThread thread5 = new MyThread("5", 5, 5);
		
		MyProcess myProcess = new MyProcess(1, thread1, thread2, thread3, thread4, thread5);
		
		System.out.println("初始状态：");
		myProcess.print();
		System.out.println("");
		
		int i = 0;
		while(myProcess.flag != 1){
			System.out.println("第" + (i+1) +"次轮转：");
			myProcess.oneRound();
			i++;
		}
		
	}
}
