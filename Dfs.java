import java.util.*;
class Dfs{
    static void dfs(List<List<Integer>> a,boolean [] b,int c){
        b[c]=true;
        System.out.print(c+" ");
        for(int i:a.get(c)){
            if(!b[i]) {
                dfs(a,b,i);
             }
        }   
    }
    static void addEdge(List<List<Integer>>a,int b,int c){
        a.get(b).add(c);
        a.get(c).add(b);
    }
    static void bfs(List<List<Integer>> a,boolean [] b,int c){
        Queue<Integer> q= new LinkedList<>();
        q.add(c);
        while(!q.isEmpty()){
            int f=q.poll();
            System.out.println(f);
            b[f]=true;
            for(int i:a.get(f)){
                if(!b[i]){
                    b[i]=true;
                    q.add(i);
                }
            }
        }

    }

    public static void main(String[] args) {
        List<List<Integer>> a=new ArrayList<>();
        for(int i=0;i<5;i++) {
            a.add(new ArrayList<>());
            }
        int[][] edges = {{ 1, 2 }, { 1, 0 }, { 2, 0 }, { 2, 3 }, { 2, 4 }}; 
        for (int[] edge : edges) {
            addEdge(a, edge[0], edge[1]);
            }
        boolean [] b=new boolean[5];
        bfs(a, b, 3);
    }
}
