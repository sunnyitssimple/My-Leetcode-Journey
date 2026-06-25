import java.util.*;

class Pair implements Comparable<Pair> {
    char ch;
    int freq;
    
    Pair(char ch, int freq) {
        this.ch = ch;
        this.freq = freq;
    }
    
   
    @Override
    public int compareTo(Pair other) {
        return Integer.compare(this.freq, other.freq);
    }
}

class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
      
        char[] arr = s.toCharArray();
        int n = arr.length;
        int i = 0;
        
        while (i < n) {
            char current_ch = arr[i];
           
            map.put(current_ch, map.getOrDefault(current_ch, 0) + 1);
            i++; 
        }
        
 
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            maxHeap.offer(new Pair(entry.getKey(), entry.getValue()));
        }
        
      
        StringBuilder sb = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            Pair pair = maxHeap.poll();
            char ch = pair.ch;
            int frequency = pair.freq;

       
            for (int j = 0; j < frequency; j++) {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}