public class MergeSort {

    public void Process(int[] a,int l,int r){
        if(l == r){
            return;
        }
        int mid = l + ((r - l) >> 1);
        Process(a,l,mid);
        Process(a,mid + 1,r);

        Merge(a,l,mid,r);
    }

    public void Merge(int[] a, int l, int mid, int r){
        int []help = new int[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = mid + 1;
        while(p1 <= mid && p2 <= r){
            help[i++] = (a[p1] <= a[p2]) ? a[p1++] : a[p2++];
        }
        while(p1 <= mid){
            help[i++] = a[p1++];
        }
        while(p2 <= r){
            help[i++] = a[p2++];
        }
        for (i = 0; i < help.length; i ++){
            a[l+i] = help[i];
        }
    }


    public static void main(String[] args) {
        MergeSort test1 = new MergeSort();
        int []a = new int[]{9,8,7,6,5,4,3,2,1};
        System.out.println();
        int l = 0;
        int r = a.length - 1;
        test1.Process(a,l,r);
        for(int i = 0; i < a.length; i++){
            System.out.print(a[i]);
        }
    }
}
