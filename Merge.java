class Merge{
    public static void merge(int a[],int l,int h){
        int m=l+(h-l)/2;
        if(l<h){
            merge(a, l, m);
            merge(a, m+1, h);
            MergeSort(a, l, m, h);
        }
    }
    public static void MergeSort(int a[],int l,int m,int h){
        int b[]=new int[h-l+1];
        int i=l;
        int j=m+1;
        int k=0;
        while(i<=m && j<=h){
            if(a[i]<=a[j]){
                b[k]=a[i];
                i++;
            }
            else{
                b[k]=a[j];
                j++;
            }
            k++;
        }
        while(i<=m){
            b[k]=a[i];
            i++;
            k++;
        }
        while(j<=h){
            b[k]=a[j];
            j++;
            k++;
        }
        for(i=l;i<=h;i++){
            a[i]=b[i-l];
        }

    }   

    public static void main(String args[]){
        int a[]={1,3,5,7,9,2,4,6,8};
        merge(a, 0, a.length-1);
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
    }
}