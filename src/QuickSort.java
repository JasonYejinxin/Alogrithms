public class QuickSort {
    public void quickSort(int[] a,int l,int r) {
        if (l < r) {
            swap(a, l + (int) Math.random() * (r - l + 1), r);
            int[] p = partition(a,l,r); //获得一个只有两个元素的数组，数组值分别为： 1. <的右边界+1；2. >的左边界-1
            quickSort(a,l,p[0] - 1); // <区递归，p[0]-1 为<区右边界
            quickSort(a,p[1] + 1,r); // >区递归，p[1]+1 为>区左边界
        }
    }
    public int[] partition(int[] a,int l, int r){
        int less = l - 1;
        int more = r;
        while(l < more){ // l表示当前位置，a[r]表示划分值
            if(a[l] < a[r]){ //当前数 < 划分值
                swap(a,++less,l++);
            }else if(a[l] > a[r]){ //当前数 > 划分值
                swap(a,--more,l);
            }
            else l++;
        }
        swap(a,more,r);
        return new int[]{less + 1, more};
    }

    private void swap(int[] a,int b,int c) {
        int temp = 0;
        temp = a[c];
        a[c] = a[b];
        a[b] = temp;
    }

    public static void main(String[] args) {
        QuickSort test = new QuickSort();
        int[] a = new int[]{1,4,3,5,5,4};
        test.quickSort(a,0,a.length - 1);
        for(int i = 0; i <a.length; i++){
            System.out.print(a[i] + "\t");
        }
    }
}
