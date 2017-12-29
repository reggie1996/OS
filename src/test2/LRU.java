package test2;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LRU {

	private static final int M = 3; //�������
	private List<Integer> inputPages = new ArrayList<>();//�����ҳ��list
	private Stack stack = new Stack<>(); //ͬ�ڴ��ҳ�������
	private Stack stack_t = new Stack<>();//������ת��ջ
	
	private int s;//����ҳ��ɹ��Ĵ���
	private int f;//����ҳ��ʧ�ܵĴ���
	
	public LRU(int[] pages) {
		super();
		for(int i : pages){
			inputPages.add(i);
		}
	}
	
	//����һ��ҳ��ʱ�Ĳ���
	private void readOnePage(int page_num){
		if(stack.contains(page_num)){
			//���ջ���������ҳ�棬��Ѹ�ҳ���Ƶ�ջ��������ҳ������ѹ
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
			//���û�����ҳ��
			f++;
			if(stack.size()<M){
				//������滹��λ��,��ֱ����ջ
				stack.push(page_num);
			}else{
				//���û��λ�ã���ɾ��ջ�׵�Ԫ�أ���ջ��ѹ��page_num
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
		//��ӡ��ǰ�ڴ�ҳ�����
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
		System.out.println("\nȱҳ�ʣ�   " + f*1.0/(f+s) );
	}


}
