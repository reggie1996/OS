package test2;

import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;

public class FIFO {
	
	private static final int M = 3; //主存块数
	private List<Integer> inputPages = new ArrayList<>();//传入的页面list
	
	private List<Integer> pageList = new ArrayList<>();//用于存放页面的list
	private List<Integer> countList = new ArrayList<>(); //用于存放array_page相同下标所存页面号对于的存在时间
	
	private int s;//访问页面成功的次数
	private int f;//访问页面失败的次数
	
	public FIFO(int[] pages) {
		super();
		for(int i : pages){
			inputPages.add(i);
		}
	}

	//初始化两个list
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
		
		//读入一个页面时，先把所有页面的存在时间加一
		for(int i = 0; i < pageList.size(); i++){
			int count = countList.get(i);
			count++;
			countList.set(i, count);
		}
		
		int index_of_page_num;
		index_of_page_num = pageList.indexOf(page_num);
		
		if(index_of_page_num < 0){
			//原先的内存中不存在该页面则插入
			f++;//因为不存在所以访问失败的次数加一
			if(pageList.size() < M){
				//如果内存中有空间则直接在空的地方存入
				pageList.add(page_num);
				countList.set(pageList.size()-1, 1);
			}else{
				//如果没有空间，就删掉最老的页面,再存入
				int insert_index = deleteOldPage();
				pageList.set(insert_index, page_num);
				countList.set(insert_index, 1);
			}
		}else{
			//访问页面成功 访问成功次数加一
			s++;
		}
		//打印当前内存情况
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
		System.out.println("\n缺页率：   " + f*1.0/(f+s) );
	}
	

}
