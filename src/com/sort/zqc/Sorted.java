package com.sort.zqc;

/**
 * Created by Interllij IDEA
 * User:Zqc
 * Data:2018/7/12
 * Time:10:30
 * Email:quanchaozhao@yeah.net
 * To change this template use File | Settings | File Templates.
 */
public class Sorted {
    private static final int MAX = 100000;
    public int count = 0;

    public static void main(String[] args) {
        int[] nums = {7,5,4,12,3,8,1,13,16,46,55,76,87,57,21,34,35,65,54,66,78,52};
//        int[] nums = new int[MAX];
//        for (int i = 0; i < MAX; i++) {
//            nums[i] = (int) (Math.random() * MAX);
//        }
        int[] temNums = new int[nums.length];
//        System.out.println("待排序数据：");
//        print(nums);
        Sorted sort = new Sorted();

//        Date currentDate = new Date();
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("ss");
//        System.out.println(simpleDateFormat.format(currentDate));
        long currentTime = System.currentTimeMillis();
        System.out.println();
        System.arraycopy(nums, 0, temNums, 0, nums.length);
        System.out.println("\n######-------无耻分割线------######\n");
        System.out.print("Insert排序");
        sort.insertSorted(temNums);
        System.out.println("[Insert排序]后结果：");
//        print(temNums);
        System.out.println("执行时间：" + (System.currentTimeMillis() - currentTime) + "s");

        currentTime = System.currentTimeMillis();
        System.arraycopy(nums, 0, temNums, 0, nums.length);
        System.out.println("\n######-------无耻分割线------######\n");
        System.out.print("Shell排序");
        sort.shellSorted(temNums);
//        Sorted.shellSort(temNums);
        System.out.println("[Shell排序]后结果：");
//        print(temNums);
        System.out.println("执行时间：" + (System.currentTimeMillis() - currentTime) + "s");

        currentTime = System.currentTimeMillis();
        System.arraycopy(nums, 0, temNums, 0, nums.length);
        System.out.println("\n######-------无耻分割线------######\n");
        System.out.print("Bubble排序");
        sort.bubbleSorted(temNums);
        System.out.println("[Bubble排序]后结果：");
//        print(temNums);
        System.out.println("执行时间：" + (System.currentTimeMillis() - currentTime) + "s");

        currentTime = System.currentTimeMillis();
        System.arraycopy(nums, 0, temNums, 0, nums.length);
        System.out.println("\n######-------无耻分割线------######\n");
        System.out.println("Quick排序");
        sort.quickSorted(temNums, 0, temNums.length - 1);
        System.out.println("[Quick排序]后结果：");
//        print(temNums);
        System.out.println("执行时间：" + (System.currentTimeMillis() - currentTime) + "s");

        currentTime = System.currentTimeMillis();
        System.arraycopy(nums, 0, temNums, 0, nums.length);
        System.out.println("\n######-------无耻分割线------######\n");
        System.out.print("Select排序");
        sort.selectSorted(temNums);
        System.out.println("[Select排序]后结果：");
//        print(temNums);
        System.out.println("执行时间：" + (System.currentTimeMillis() - currentTime) + "s");

        currentTime = System.currentTimeMillis();
        System.arraycopy(nums, 0, temNums, 0, nums.length);
        System.out.println("\n######-------无耻分割线------######\n");
        System.out.print("Heap排序");
        sort.heapSorted(temNums);
        System.out.println("[Heap排序]后结果：");
//        print(temNums);
        System.out.println("执行时间：" + (System.currentTimeMillis() - currentTime) + "s");

        currentTime = System.currentTimeMillis();
        System.arraycopy(nums, 0, temNums, 0, nums.length);
        System.out.println("\n######-------无耻分割线------######\n");
        System.out.println("Merge排序");
        sort.mergeSorted(temNums,0,temNums.length - 1);
        System.out.println("[Merge排序]后结果：");
//        print(temNums);
        System.out.println("执行时间：" + (System.currentTimeMillis() - currentTime) + "s");
    }

    /**
     *
     * 直接插入排序，若待排序数字的下标为i，则认为【0，i-1】已经有序。
     * 平均时间复杂度O（n^2），空间复杂度O(1)
     * 排序效果稳定，适用于顺序存储和链式存储，建议使用哨兵，
     * 避免多次移动数据，造成时间浪费。
     *
     * @param nums 待排序数据
     */
    public void insertSorted(int[] nums) {
        System.out.println();
        for (int i = 1; i < nums.length; i++) {
//            System.out.println("第" + (i) + "次排序，插入数值为：" + nums[i] + ",排序结果为");
            if (nums[i] < nums[i - 1]) {
                int tem = nums[i];
                int j = i - 1;
                while (j >= 0 && nums[j] > tem){
                    nums[j + 1] = nums[j];
                    j--;
                }
//                for (j = i - 1; j >= 0; j--) {
//                    if (nums[j] > tem){
//                        nums[j + 1] = nums[j];
//                    }else {
//                        break;
//                    }
//                }
                nums[j + 1] = tem;
            }
//            print(nums);
        }
    }


    /**
     * shell排序，可以认为是对直接排序的改进，进行分组排序，最坏和最好情况
     * 的时间复杂度和直接插入排序相同，但平均情况优于直接插入排序O(n^1.5)，
     * 空间复杂度为O(1),排序不稳定，分组间隔最后一个一定为1.
     *
     * @param nums 待排序数组
     */
    public void shellSorted(int[] nums) {
        System.out.println();
        int h;
        for (h = nums.length / 2; h > 0; h /= 2) {
            for (int i = h; i < nums.length; i++) {
//                System.out.println("第" + (++count) + "次排序，h = " + h + ",排序结果为:");
                int j = i - h;
                int tem = nums[i];
                while (j >= 0 && nums[j] > tem){
                    nums[j + h] = nums[j];
                    j -= h;
                }
                nums[j + h] = tem;
//                print(nums);
            }
        }
    }

//    public static void shellSort(int[] data) {
//        //shell 排序的增量循环
//        int count = 0;
//        for (int delta = data.length / 2; delta > 0; delta = delta / 2) {
//            for (int i = 0; i < data.length - delta; i++) {
//                int temp = data[delta + i];
//                int index = delta + i;
//                while (index - delta >= 0 && data[index - delta] > temp) {
//                    data[index] = data[index - delta];
//                    index = index - delta;
//                }
//                data[index] = temp;
//            }
//            System.out.println("第" + (++count) + "次排序，h = " + delta + ",排序结果为:");
//            print(data);
//        }
//    }

    /**
     * Bubble排序算法，属于交换排序算法。平均时间复杂度为O(n^2)
     * 空间复杂度为O(1)，排序稳定。可以设置一个变量来记录在某次
     * 排序中是否进行了相邻数据的交换，如果没有则可以提前结束排序。
     *
     * @param nums 待排序数组
     */
    public void bubbleSorted(int[] nums) {
        System.out.println();
        boolean flag = true;
        for (int i = 0; i < nums.length - 1; i++) {
            flag = false;
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
//            System.out.println("第" + (i + 1) + "次排序，排序结果为");
//            print(nums);
        }
    }

    /**
     * 对Bubble的改进，通过一趟遍历将待排序数组分割成两部分，左边部分都比
     * 右边部分小，然后分别左右两部分尽心递归。
     * 从左边开始比较时，先从右侧找小于待排序值的数据。
     * 切记加入判断 left < right。
     * 平均时间复杂度O(nlogn)，空间复杂度同时间复杂度，且排序不稳定。
     * @param nums  待排序数组
     * @param left  左边起始位置
     * @param right 右边结束为止
     */
    public void quickSorted(int[] nums, int left, int right) {
        if (left >= right)
            return;
        int start = left, end = right;
        int tem = nums[start];
        while (start < end) {
            while (start < end && nums[end] >= tem) {
                end--;
            }
            nums[start] = nums[end];
            while (start < end && nums[start] <= tem) {
                start++;
            }
            nums[end] = nums[start];
        }
        nums[start] = tem;
//        System.out.println("第" + ++count +"次排序，以[" + tem + "]为枢纽，结果如下：" );
//        print(nums);
        quickSorted(nums, left, start - 1);
        quickSorted(nums, start + 1, right);
    }

    /**
     *
     * Select排序，以位置定数字，每次从待排序的部分数字中选择一个最小值或最大值
     * 放在指定位置。平均、最坏和最好情况时间复杂度均为O（n^2）。效率略差
     *
     * @param nums
     */
    public void selectSorted(int[] nums){
//        System.out.println();
        for (int i = 0; i < nums.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < nums.length; j++) {
                if(nums[j] < nums[index]){
                    index = j;
                }
            }
//            System.out.println("第" + (i + 1) + "次排序，排序数字为" + nums[index] + "排序结果如下：");
            if(index != i){
                swap(nums, index, i);
            }
//            print(nums);
        }
    }

    /**
     *
     * Heap排序基于选择排序，最优、最差和平均时间复杂度均为O(nlogn)，排序不稳定。
     * 下标为i的数据，父亲节点为 (i - 1) / 2，子节点分别为：2 * i + 1 和 2 * i + 2。
     * 增序选择建立大根堆，排序过程如下：
     * ①建堆，建堆是不断调整堆的过程，从len/2处开始调整，一直到第一个节点，此处len是堆中元素的个数。
     * 建堆的过程是线性的过程，从len/2到0处一直调用调整堆的过程，相当于o(h1)+o(h2)…+o(hlen/2)
     * 其中h表示节点的深度，len/2表示节点的个数，这是一个求和的过程，结果是线性的O(n)。
     * ②调整堆：调整堆在构建堆的过程中会用到，而且在堆排序过程中也会用到。利用的思想是比较节点i
     * 和它的孩子节点left(i),right(i)，选出三者最大(或者最小)者，如果最大（小）值不是节点i而是它的
     * 一个孩子节点，那边交互节点i和该节点，然后再调用调整堆过程，这是一个递归的过程。
     * 调整堆的过程时间复杂度与堆的深度有关系，是lgn的操作，因为是沿着深度方向进行调整的。
     * ③堆排序：堆排序是利用上面的两个过程来进行的。首先是根据元素构建堆。然后将堆的根节点取出
     * (一般是与最后一个节点进行交换)，将前面len-1个节点继续进行堆调整的过程，然后再将根节点取出，
     * 这样一直到所有节点都取出。
     *
     * @param nums 待排序数组
     */
    public void heapSorted(int[] nums){
        //建堆，从最后一个节点的父节点开始建立
//        System.out.println();
        for(int i = (nums.length - 1 - 1) / 2; i >= 0; i--){
            maxHeap(nums, nums.length, i);
        }
        int count = 0;
        for (int i = nums.length - 1; i > 0; i--){
//            System.out.println("第" + (++count) + "次排序，排序值为：" + nums[0] + ",排序结果为：");
            swap(nums, 0,i);
            maxHeap(nums,i,0);
//            print(nums);
        }
    }
    private static void maxHeap(int[] nums,int heapSize, int index){
        int leftChild = 2 * index + 1;
        int rightChild = 2 * index + 2;
        int largestIndex = index;

        //分别比较当前节点和左右节点，找出最小值
        if(leftChild < heapSize && nums[leftChild] > nums[largestIndex]){
            largestIndex = leftChild;
        }
        if(rightChild < heapSize && nums[rightChild] > nums[largestIndex]){
            largestIndex = rightChild;
        }
        //递归调整堆
        if(largestIndex != index){
            swap(nums, index, largestIndex);
            maxHeap(nums,heapSize,largestIndex);
        }
    }

    public void mergeSorted(int[] nums, int low, int hight){
        int middle = (low + hight) / 2;
        if (low < hight){
        mergeSorted(nums, low, middle);
        mergeSorted(nums, middle + 1, hight);
        merge(nums, low, middle, hight);
        }
    }
    public static void merge(int[] nums, int low, int middle, int hight){
        int[] tem = new int[hight - low + 1];
        int i = low, j = middle +  1,index = 0;
        while (i <= middle && j <= hight){
            if (nums[i] < nums[j]){
                tem[index++] = nums[i++];
            } else {
                tem[index++] = nums[j++];
            }
        }
        while (i <= middle){
            tem[index++] = nums[i++];
        }
        while (j <= hight){
            tem[index++] = nums[j++];
        }

        for (int k = 0; k < tem.length; k++) {
            nums[low + k] = tem[k];
        }
//        System.out.println("当前归并的字段");
//        print(tem);
    }
    public static void swap(int[] nums, int first, int second) {
        int tem = nums[first];
        nums[first] = nums[second];
        nums[second] = tem;
    }

    public static void print(int[] nums) {
        for (int x : nums) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
}
