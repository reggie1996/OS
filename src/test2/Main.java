package test2;

public class Main {
	public static void main(String[] args) {
		int[] pages = {7,0,1,2,0,3,0,4,2,3,0,3,2,1,2,0,1,7,0,1};
		//FIFO fifo = new FIFO(pages);
		//fifo.start();
		LRU lru = new LRU(pages);
		lru.start();
	}
}
