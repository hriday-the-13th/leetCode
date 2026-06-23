class Solution {
    public record Pair(String gene, int stepCount){}
    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> geneSet = new HashSet<>();

        for(String gene: bank){
            geneSet.add(gene);
        }

        if(!geneSet.contains(endGene)) return -1;

        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(startGene, 0));
        geneSet.remove(startGene);

        char[] charArr = {'A', 'C', 'G', 'T'};

        while(!q.isEmpty()){
            Pair pair = q.poll();
            String gene = pair.gene();
            int stepCount = pair.stepCount();
            for(int i=0; i<gene.length(); i++){
                char[] geneArr = gene.toCharArray();
                for(char ch: charArr){
                    if (ch == gene.charAt(i)) continue;
                    geneArr[i] = ch;
                    String newGene = new String(geneArr);
                    if(geneSet.contains(newGene)){
                        q.add(new Pair(newGene, stepCount + 1));
                        geneSet.remove(newGene);
                        if(newGene.equals(endGene)){
                            return stepCount + 1;
                        }
                    }
                }
            }
        }
        
        return -1;



    }
}