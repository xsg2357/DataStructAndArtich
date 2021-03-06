# 排序

## 冒泡排序

   * 基本思想： 通过对待排序序列从前向后（从下标较小的元素开始）, **依次比较
     相邻元素的值，若发现逆序则交换，使值较大的元素逐渐从前移向后部**，就象水底下的气泡一样逐渐向上冒。
   
   * 优化： 因为排序的过程中，各元素不断接近自己的位置， **如果一趟比较下来没有进行过交换 ， 就说明序列有序，因此要在
     排序过程中设置一个标志 flag 判断元素是否进行过交换**。从而减少不必要的比较。(这里说的优化，可以在冒泡排
     序写好后，在进行)
     
   * 图解过程
            
            原始数组：3,9，-1,10,20
            第一趟排序：
            1) 3,9，-1,10,20 //相邻的元素逆序就会交换
            2) 3,-1,9，10,20
            3) 3,-1,9，10,20
            4) 3,-1,9，10,20
            第二趟排序：
            1) -1,3,9，10,20
            2)-1, 3,9，10,20
            3)-1, 3,9，10,20
            第三趟排序：
            1) -1,3,9，10,20
            2)-1, 3,9，10,20
            第四趟排序:
            1)-1, 3,9，10,20
   * 小结：
        1) 一共进行 数组的大小-1 次 大的循环
        2) 每一趟排序的次数在逐渐的减少
        3) 如果我们发现在某趟排序中，没有发生一次交换， 可以提前结束冒泡排序。这个就是优化
## 选择排序
   * 简述：选择式排序也属于内部排序法，是**从欲排序的数据中，按指定的规则选出某一元素**，再依规定交换位置后达到
    排序的目的。 
   
   * 排序思想：选择排序（select sorting）也是一种简单的排序方法。它的基本思想是：第一次从 arr[0]~arr[n-1]中选取最小值，
     与 arr[0]交换，第二次从 arr[1]~arr[n-1]中选取最小值，与 arr[1]交换，第三次从 arr[2]~arr[n-1]中选取最小值，与 arr[2]
     交换，…，第 i 次从 arr[i-1]~arr[n-1]中选取最小值，与 arr[i-1]交换，…, 第 n-1 次从 arr[n-2]~arr[n-1]中选取最小值，
     与 arr[n-2]交换，总共通过 n-1 次，得到一个按排序码从小到大排列的有序序列。  
     
   * 排序案例：
      * 原始数组： 101 34  119 1
      * 第1次排序：1 34 119 101
      * 第2次排序：1 34 119 101
      * 第3次排序：1 34 101 119     
                     
   * 说明：
     1) 选择排序一共有数组大小-1轮排序
     2) 每一轮排序 又是一个循环 循环的规则：
       * 假定当前数是最小数
       * 然后和后面的每个数进行比较 如果发现有比当前述更小的数 就重新确定最小数 并得到下标
       * 遍历到数组的最后 就得到本轮最小数和下标
       * 交换
       
       
## 插入排序   
   
   * 简述：插入式排序属于内部排序法，是对于**欲排序的元素以插入的方式**找寻该元素的适当位置，以达到排序的目的。
   
   * 插入排序法思想:
           插入排序（Insertion Sorting）的基本思想是：把 把 n  个待排序的元素看成为**一个有序表和一个无序表**，开始时 有
           序表中**只包含一个元素，无序表中包含有 n-1  个元素**，排序过程中每次从无序表中**取出第一个元素，把它的排
           序码依次与有序表元素的排序码**进行比较，将它插入到有**序表中的适当位置**，使之成为**新的有序表**。 
           
   * 图解案例<br>
   ```
 | ttt|R[0]|R[1]|R[2]|R[3]|R[4]|R[5]|
   |:-|:-:|-:|-:|-:|-:|-:|
   |初始状态	|(17)|3	|25	|14|20| 9|
   |第1次插入|(3	 |17)|25| 14|20| 9|
   |第2次插入|(3	 |17|25)| 14|20|9|
   |第3次插入|(3	 |14| 17|25)|20| 9|
   |第4次插入|(3	 |14|17	|20|25)|9|
   |第5次插入|(3	 |9	| 14|17	|20	|25)|     
```       