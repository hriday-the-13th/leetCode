class Solution {
    public record Pair(String word, int stepCount){}
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>();

        for(String word: wordList){
            wordSet.add(word);
        }

        if(!wordSet.contains(endWord)) return 0;
        
        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(beginWord, 1));
        wordSet.remove(beginWord);

        while(!q.isEmpty()){
            Pair pair = q.poll();
            String word = pair.word();
            int stepCount = pair.stepCount();
            for(int i=0; i<word.length(); i++){
                char[] wordArray = word.toCharArray();
                for(char ch = 'a'; ch <= 'z'; ch++){
                    if (ch == word.charAt(i)) continue;
                    wordArray[i] = ch;
                    String newWord = new String(wordArray);
                    if(wordSet.contains(newWord)){
                        q.add(new Pair(newWord, stepCount + 1));
                        wordSet.remove(newWord);
                        if(newWord.equals(endWord)){
                            return stepCount + 1;
                        }
                    }
                }
            }
        }
        
        return 0;
    }
}