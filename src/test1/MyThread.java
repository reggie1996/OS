package test1;
/**
 * �߳���
 * @author 24073
 *
 */
public class MyThread {
	private String name;//�߳���
	private int serveTime;//��������ʱ��
	private int runedTime;//�Ѿ���ɵ�ʱ��
	private float priority;//���ȼ� ֵԽ�����ȼ�Խ��
	private int status;//�̵߳�״̬  1��ʾ��� 0��ʾδ���
	
	
	public MyThread(String name, int serveTime, long priority) {
		super();
		this.name = name;
		this.serveTime = serveTime;
		this.priority = priority;
		this.runedTime = 0;
		this.status = 0;
	}
	
	//�߳���һ��ʱ��Ƭ
	public void run(int timeSlice){
		if(runedTime != serveTime){
			runedTime += timeSlice; //���ܵ�ʱ���1
			priority -= 1;//���ȼ�����
			if(runedTime == serveTime){
				//����Ѿ��ܵ�ʱ���������Ҫ�ܵ�ʱ�� ״̬��Ϊ1
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
