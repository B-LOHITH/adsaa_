import java.util.*;
class Maxheap{
    static void insert(int a[],int b){
        int it=a[b];
        int i=b;
        while(i>0 && it>a[(i-1)/2]){
            a[i]=a[(i-1)/2];
            i=(i-1)/2;
        }
        a[i]=it;

    }
    static void delmax(int a[]){
        int l=a.length-1;
        a[0]=a[l];
        int y=a[l];
        int i=0;
        int j=2*i+1;
        while(j<=l){
            if(j<l && a[j]<a[j+1]){
                j++;
            }
            if(a[0]>a[j]){
                break;
            }
            a[i]=a[j];
            i=j;
            j=2*j+1;
        }
        a[i]=y;

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            insert(a, i);
        }
        delmax(a);
        for (int i = 0; i < n - 1; i++) {
            System.out.print(a[i] + " ");
        }
    }

}
