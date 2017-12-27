package test1;
/**
 * 线程类
 * @author 24073
 *
 */
public class MyThread {
	private String name;//线程名
	private int serveTime;//所需服务的时间
	private int runedTime;//已经完成的时间
	private float priority;//优先级 值越大优先级越大
	private int status;//线程的状态  1表示完成 0表示未完成
	
	
	public MyThread(String name, int serveTime, long priority) {
		super();
		this.name = name;
		this.serveTime = serveTime;
		this.priority = priority;
		this.runedTime = 0;
		this.status = 0;
	}
	
	//线程跑一个时间片
	public void run(int timeSlice){
		if(runedTime != serveTime){
			runedTime += timeSlice; //以跑的时间加1
			priority -= 1;//优先级减少
			if(runedTime == serveTime){
				//如果已经跑的时间等于所需要跑的时间 状态变为1
				status = 1;
				priority = -10;
			}
		}
	} 
	
	public String getName() {
		return name;
	}
	public int getServeTime() {
		return serveTime;
	}
	public void setServeTime(int serveTime) {
		this.serveTime = serveTime;
	}
	public int getRunedTime() {
		return runedTime;
	}
	public void setRunedTime(int runedTime) {
		this.runedTime = runedTime;
	}
	public float getPriority() {
		return priority;
	}
	public void setPriority(float priority) {
		this.priority = priority;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}

}
