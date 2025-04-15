import java.util.*;
class job{
    int p;
    int d;
    job(int p,int d){
        this.p=p;
        this.d=d;
    }
    public static void main(String args[]){
        job[] j={
            new job(100,2),
            new job(27,2),
            new job(19,1),
            new job(28,1)
        };
        Arrays.sort(j,(a,b)->b.p-a.p);
        int n=2;
        boolean m[]=new boolean[n];
        int tp=0;
        for(job i:j){
            for(int v=(Math.min(n,i.d))-1;v>=0;v--){
                if(!m[v]){
                    m[v]=true;
                    tp+=i.p;
                    break;
                }
            }
        }
         
        System.out.println(tp);

    }
}