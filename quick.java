class quick{
    public static void quicksort(int a[],int l,int h){
        if(l<h){
            int pi=pivort(a,l,h);
            quicksort(a,l,pi-1);
            quicksort(a, pi+1, h);
        }

    }
    public static int pivort(int a[],int l,int h){
        int i=l-1;
        int p=a[h];
        int temp;
        for(int j=l;j<h;j++){
            if(a[j]<p){
                i++;
                temp=a[i];
                a[i]=a[j];
                a[j]=temp;
            }
        }
        i++;
        temp=a[i];
        a[i]=a[h];
        a[h]=temp;
        return i;
    }
    public static void main(String[] args) {
        int a[]={9,4,2,31,33};
        int l=0;
        int n=a.length-1;
        int h=n;
        quicksort(a,l,h);
        for (int i = 0; i <= n; i++) {
            System.out.println(""+a[i]);
        }
    }
}
