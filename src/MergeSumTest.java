public class MergeSumTest {
    public int Process(int[] a, int l, int r){
        if(l == r){
            return 0;
        }
        int sum = 0;
        int mid = l + ((r - l)>>1);
        return Process(a,l,mid) + Process(a,mid + 1,r) + Merge(a,l,r,mid);
//        Process(a,l,mid);
//        Process(a,mid + 1,r);
//        sum += Merge(a,l,r,mid);
//        return sum;
    }
    public int Merge(int[] a, int l, int r, int mid){
        int[] help = new int[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = mid + 1;
        int sum = 0;
        while(p1 <= mid && p2 <= r){
            sum += a[p1] < a[p2] ? a[p1] * (r - p2 + 1) : 0;
            help[i++] = a[p1] < a[p2] ? a[p1++]:a[p2++];
        }
        while(p1 <= mid){
            help[i++] = a[p1++];
        }
        while(p2 <= r){
            help[i++] = a[p2++];
        }
        for(i = 0; i < help.length; i++){
            a[l + i] = help[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        MergeSumTest test1 = new MergeSumTest();
        int[] a = new int[]{1,3,4,2,5};
        int l = 0;
        int r = a.length - 1;
        int ans = test1.Process(a,l,r);
        for(int i = 0; i < a.length; i++){
            System.out.print(a[i] + "\t");
        }
        System.out.println();
        System.out.println(ans);
    }
}