package test2;

import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;

public class FIFO {
	
	private static final int M = 3; //�������
	private List<Integer> inputPages = new ArrayList<>();//�����ҳ��list
	
	private List<Integer> pageList = new ArrayList<>();//���ڴ��ҳ���list
	private List<Integer> countList = new ArrayList<>(); //���ڴ��array_page��ͬ�±�����ҳ��Ŷ��ڵĴ���ʱ��
	
	private int s;//����ҳ��ɹ��Ĵ���
	private int f;//����ҳ��ʧ�ܵĴ���
	
	public FIFO(int[] pages) {
		super();
		for(int i : pages){
			inputPages.add(i);
		}
	}

	//��ʼ������list
	private void init(){
		for(int i = 0; i < M; i++){
			countList.add(0);
			
		}
	}
	
	private int deleteOldPage(){
		
		int max = countList.get(0);
		int index_of_max = 0;
		for(int count : countList){
			if(count >= max){
				index_of_max = countList.indexOf(count);
				max = count;
			}
		}
		
		countList.set(index_of_max, 0);
		pageList.set(index_of_max, -1);
		
		return index_of_max;
	}
	
	
	private void readOnePage(int page_num){
		
		//����һ��ҳ��ʱ���Ȱ�����ҳ��Ĵ���ʱ���һ
		for(int i = 0; i < pageList.size(); i++){
			int count = countList.get(i);
			count++;
			countList.set(i, count);
		}
		
		int index_of_page_num;
		index_of_page_num = pageList.indexOf(page_num);
		
		if(index_of_page_num < 0){
			//ԭ�ȵ��ڴ��в����ڸ�ҳ�������
			f++;//��Ϊ���������Է���ʧ�ܵĴ�����һ
			if(pageList.size() < M){
				//����ڴ����пռ���ֱ���ڿյĵط�����
				pageList.add(page_num);
				countList.set(pageList.size()-1, 1);
			}else{
				//���û�пռ䣬��ɾ�����ϵ�ҳ��,�ٴ���
				int insert_index = deleteOldPage();
				pageList.set(insert_index, page_num);
				countList.set(insert_index, 1);
			}
		}else{
			//����ҳ��ɹ� ���ʳɹ�������һ
			s++;
		}
		//��ӡ��ǰ�ڴ����
		print();
	}
	
	private void print(){
		for(int page :pageList){
			System.out.print(page + " ");
		}
		System.out.println();
	}
	
	
	public void start(){
		init();
		for(int i = 0; i<inputPages.size(); i++){
			readOnePage(inputPages.get(i));
		}
		System.out.println("\nȱҳ�ʣ�   " + f*1.0/(f+s) );
	}
	

}
