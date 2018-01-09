package test2;

import java.util.ArrayList;
import java.util.List;

public class OPT {
	private static final int M = 3; //主存块数
	private List<Integer> inputPages = new ArrayList<>();//传入的页面list
	
	private List<Integer> pageList = new ArrayList<>();//用于存放页面的list
	private int index;//用于存放当前读到那个page的下表
	
	private int s;//访问页面成功的次数
	private int f;//访问页面失败的次数
	
	public OPT(int[] pages) {
		super();
		for(int i : pages){
			inputPages.add(i);
		}
	}
	
	//读入一个页面时的操作
	private void readOnePage(int page_num){	
		
	}
	
	
}
