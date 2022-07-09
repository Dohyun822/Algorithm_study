import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> minheap = new PriorityQueue<>();
        for(int a : scoville) {
        	minheap.offer(a);
        }
        int socv = minheap.peek();
        while(K > minheap.peek()) {
            if(minheap.peek()==null || minheap.size() == 1) {
        		return -1;
        	}
        	int x = minheap.poll();
        	int y = minheap.poll();
        	socv = x + (2*y);
            minheap.offer(socv);
        	
        	answer++;
        	
        }
        return answer;
    }
}