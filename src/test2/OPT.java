package test2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OPT {
	private static final int M = 3; //�������
	private List<Integer> inputPages = new ArrayList<>();//�����ҳ��list
	
	private List<Integer> pageList = new ArrayList<>();//���ڴ��ҳ���list
	private int index;//���ڴ�ŵ�ǰ�����Ǹ�page���±�
	
	private Map<Integer, Integer> map = new HashMap<>();
	
	private int s;//����ҳ��ɹ��Ĵ���
	private int f;//����ҳ��ʧ�ܵĴ���
	
	public OPT(int[] pages) {
		super();
		for(int i : pages){
			inputPages.add(i);
		}
	}
	
	//�ҵ���ʱ�䲻�ᱻ���ʵ�ҳ��������ҳ��
	private int findThePage(){
		map.clear();
		for(Integer i : pageList){
			map.put(i, -1);
		}
		System.out.println(map);
		for(int i = index; i<inputPages.size(); i++){
			int pageNum;
			pageNum = inputPages.get(i);
			if(map.containsKey(pageNum) && (map.get(pageNum) == -1)){
				map.replace(pageNum, -1, i);
			}
		}
		
		int max = -1;//Խ����ֵ�ֵԽ��
		int maxpage = -1;//��Ӧ��ҳ���
		
		for(Map.Entry<Integer, Integer> entry : map.entrySet()){
			if(entry.getValue() > max){
				max = entry.getValue();
				maxpage = entry.getKey();
			}
		}
			
		return maxpage;
	}
	
	
	//����һ��ҳ��ʱ�Ĳ���
	private void readOnePage(int page_num){	
		if(pageList.indexOf(page_num)<0){
			//����ڸ�ҳ�����ڴ��ڣ���ֱ�Ӵ���
			if(pageList.size() < M){
				//�ڴ����δ����ֱ�Ӵ���
				pageList.add(page_num);
			}else{
				//�ڴ��������ɾ��δ����ʱ�䲻�õ��Ǹ����ٴ���
				int deletePage = findThePage();
				int indexOfdeletePage = pageList.indexOf(deletePage);
				if(indexOfdeletePage != -1)
					pageList.set(indexOfdeletePage, page_num);
			}
		}else{
			//��ҳ���ڴ��ڣ���ɶ������
		}
		index++;
	}
	
	
	private void print(){
		for(int page :pageList){
			System.out.print(page + " ");
		}
		System.out.println();
	}
	
	
	public void start(){
		int[] pages = {7,0,1,2,0,3,0,4,2,3,0,3,2,1,2,0,1,7,0,1};
		FIFO fifo = new FIFO(pages);
		fifo.start();
	}
	
	
	
}
