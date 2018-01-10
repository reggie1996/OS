package test2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OPT {
	private static final int M = 3; //主存块数
	private List<Integer> inputPages = new ArrayList<>();//传入的页面list
	
	private List<Integer> pageList = new ArrayList<>();//用于存放页面的list
	private int index;//用于存放当前读到那个page的下标
	
	private Map<Integer, Integer> map = new HashMap<>();
	
	private int s;//访问页面成功的次数
	private int f;//访问页面失败的次数
	
	public OPT(int[] pages) {
		super();
		for(int i : pages){
			inputPages.add(i);
		}
	}
	
	//找到长时间不会被访问的页，并返回页号
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
		
		int max = -1;//越后出现的值越大
		int maxpage = -1;//对应的页面号
		
		for(Map.Entry<Integer, Integer> entry : map.entrySet()){
			if(entry.getValue() > max){
				max = entry.getValue();
				maxpage = entry.getKey();
			}
		}
			
		return maxpage;
	}
	
	
	//读入一个页面时的操作
	private void readOnePage(int page_num){	
		if(pageList.indexOf(page_num)<0){
			//如果在该页不在内存内，则直接存入
			if(pageList.size() < M){
				//内存块里未满。直接存入
				pageList.add(page_num);
			}else{
				//内存块已满，删除未来长时间不用的那个，再存入
				int deletePage = findThePage();
				int indexOfdeletePage = pageList.indexOf(deletePage);
				if(indexOfdeletePage != -1)
					pageList.set(indexOfdeletePage, page_num);
			}
		}else{
			//该页在内存内，则啥都不做
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
