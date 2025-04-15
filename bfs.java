
import java.util.*;
class bfs{
    static void Bfs(int a[][],boolean [] b,int c){
        Queue<Integer> q= new LinkedList<>();
        q.add(c);
        while(!q.isEmpty()){
            int g=q.poll();
            b[g]=true;
            System.out.print(g+" ");
            for(int i=0;i<b.length;i++){  
                if(a[g][i]!=0){
                    if(!b[i]){
                        q.add(i);
                    }
                }
         
            }
        }
    }
    static void dfs(int a[][],boolean b[],int c){
        System.out.println(c);
        b[c]=true;
        int i;
        for(i=0;i<a.length;i++){
            if(a[c][i]==1 && !b[i]){
                dfs(a,b,i);

            }
        }
    }
    public static void main(String[] args) {
        int a[][]={{0,1,0},{0,0,1},{1,0,0}};
        boolean c[]=new boolean[3];
        dfs(a,c,1);


    }
}