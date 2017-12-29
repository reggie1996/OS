package test2;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LRU {

	private static final int M = 3; //主存块数
	private List<Integer> inputPages = new ArrayList<>();//传入的页面list
	private Stack stack = new Stack<>(); //同于存放页面的数组
	private Stack stack_t = new Stack<>();//用于中转的栈
	
	private int s;//访问页面成功的次数
	private int f;//访问页面失败的次数
	
	public LRU(int[] pages) {
		super();
		for(int i : pages){
			inputPages.add(i);
		}
	}
	
	//读入一个页面时的操作
	private void readOnePage(int page_num){
		if(stack.contains(page_num)){
			//如果栈里面有这个页面，则把该页面移到栈顶，其余页面往下压
			s++;
			int page_t;
			do{
				page_t = (int) stack.pop();
				if(page_t != page_num){
					stack_t.push(page_t);
				}else{
					break;
				}
			}while(true);
			
			while(!stack_t.isEmpty()){
				stack.push(stack_t.pop());
			}
			stack.push(page_t);
		}else{
			//如果没有这个页面
			f++;
			if(stack.size()<M){
				//如果主存还有位置,则直接入栈
				stack.push(page_num);
			}else{
				//如果没有位置，就删除栈底的元素，在栈顶压入page_num
				while(!stack.isEmpty()){
					stack_t.push(stack.pop());
				}
				stack_t.pop();
				while(!stack_t.isEmpty()){
					stack.push(stack_t.pop());
				}
				stack.push(page_num);
			}
		}
	}
	
	private void print(){
		//打印当前内存页面情况
		while(!stack.isEmpty()){
			stack_t.push(stack.pop());
		}
		while(!stack_t.isEmpty()){
			System.out.print(stack_t.peek() + " ");
			stack.push(stack_t.pop());
		}
		System.out.println();
	}
	
	
	public void start(){
		for(int i = 0; i<inputPages.size(); i++){
			readOnePage(inputPages.get(i));
			print();
		}
		System.out.println("\n缺页率：   " + f*1.0/(f+s) );
	}


}
