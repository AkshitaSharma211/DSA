import java.util.*;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>(wordList);
        if(!set.contains(endWord)) return 0;
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        set.remove(beginWord);
        int steps = 1;

        while(!q.isEmpty()){
            int size = q.size();
            for(int s = 0; s < size; s++){
                String curr = q.poll();
                for(int i = 0; i < curr.length(); i++){
                    for(char alpha='a'; alpha<='z'; alpha++){
                        char[] chars = curr.toCharArray();
                        chars[i] = alpha;
                        String newWord = new String(chars);
                        if(newWord.equals(endWord)) return steps+1;
                        if(set.contains(newWord)){
                            q.add(newWord);
                            set.remove(newWord);
                        }
                    }
                }
            }
            steps++;
        }
        return 0;
    }

    public static void main(String[] args){
    Solution s = new Solution();
    List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");
    System.out.println(s.ladderLength("hit", "cog", wordList));  // should print 6
}
}
