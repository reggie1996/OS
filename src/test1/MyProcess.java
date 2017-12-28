package test1;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//������
public class MyProcess {
	
	public List<MyThread> mythreads;//��Ÿ����̵߳�����
	private int timeSlice;//ʱ��Ƭ
	public int flag = 0;
	
	public MyProcess(int timeSlice, MyThread... mythreads) {
		super();
		this.timeSlice = timeSlice;
		this.mythreads = java.util.Arrays.asList(mythreads);
	}
	
	//��ӡ�������̵�״̬
	public void print(){
		for(MyThread thread :mythreads){
			System.out.println("�߳�" + thread.getName() +"  ���ȼ���" + thread.getPriority() + 
								"  �������ʱ�䣺" + thread.getServeTime() + "  ������ʱ�䣺" + thread.getRunedTime() +
								"  ״̬��" + (thread.getStatus() == 1 ? "ִ�н���":"�ȴ�ִ��"));
		}
	}
	
	//�������ȼ����߳�����
	public void resortMythread(){
		Collections.sort(mythreads, new Comparator<MyThread>() {
		            @Override
		            public int compare(MyThread o1, MyThread o2) {
		                //����
		                return (int)(o2.getPriority()-o1.getPriority());
		            }
	            });
	}
	
	//һ����ת�Ĳ���
	public void oneRound(){
		System.out.println("-----------------------------------------------");
		mythreads.get(0).run(timeSlice); //���ȼ���ߵ�ִ��һ��ʱ��Ƭ
		System.out.println("ִ���߳�" + mythreads.get(0).getName());
		resortMythread();
		print();
		System.out.println("-----------------------------------------------\n");
		if(mythreads.get(0).getStatus() == 1){
			flag = 1;
		}
	}
	
	
}
