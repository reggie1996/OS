package test1;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//进程类
public class MyProcess {
	
	public List<MyThread> mythreads;//存放各个线程的数组
	private int timeSlice;//时间片
	public int flag = 0;
	
	public MyProcess(int timeSlice, MyThread... mythreads) {
		super();
		this.timeSlice = timeSlice;
		this.mythreads = java.util.Arrays.asList(mythreads);
	}
	
	//打印各个进程的状态
	public void print(){
		for(MyThread thread :mythreads){
			System.out.println("线程" + thread.getName() +"  优先级：" + thread.getPriority() + 
								"  所需服务时间：" + thread.getServeTime() + "  已运行时间：" + thread.getRunedTime() +
								"  状态：" + (thread.getStatus() == 1 ? "执行结束":"等待执行"));
		}
	}
	
	//根据优先级将线程排序
	public void resortMythread(){
		Collections.sort(mythreads, new Comparator<MyThread>() {
		            @Override
		            public int compare(MyThread o1, MyThread o2) {
		                //降序
		                return (int)(o2.getPriority()-o1.getPriority());
		            }
	            });
	}
	
	//一次轮转的操作
	public void oneRound(){
		System.out.println("-----------------------------------------------");
		mythreads.get(0).run(timeSlice); //优先级最高的执行一个时间片
		System.out.println("执行线程" + mythreads.get(0).getName());
		resortMythread();
		print();
		System.out.println("-----------------------------------------------\n");
		if(mythreads.get(0).getStatus() == 1){
			flag = 1;
		}
	}
	
	
}
