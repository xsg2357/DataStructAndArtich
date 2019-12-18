## 队列
     使用场景：银行排队
     
### 队列介绍
* 队列是一个 有序列表，可以用 数组或是 链表来实现。
* 遵循 先入先出的原则。即： 先存入队列的数据，要先取出。后存入的要后取出

### 数组模拟队列思路
*  队列本身是有序列表，若使用数组的结构来存储队列的数据, 其中 maxSize 是该队
   列的最大容量。
*  因为队列的输出、输入是分别从前后端来处理，因此需要两个变量 front 及 rear 分别记录队列前后端的下标，
*  front 会随着数据输出而改变，而 rear 则是随着数据输入而改变
   当我们将数据存入队列时称为”addQueue”，addQueue 的处理需要有两个步骤：思路分析
    1) 将尾指针往后移：rear+1 , 当 front == rear 【空】
    2) 若尾指针 rear 小于队列的最大下标 maxSize-1，则将数据存入 rear 所指的数组元素中，否则无法存入数据。
        rear == maxSize - 1[队列满]
```xml
    s(show):显示队列
    e(exit):退出程序
    a(add):添加进队列
    g(get):取数据出队列
    h(head):显示队列头
    s
    队列为空，不能打印数据
    s(show):显示队列
    e(exit):退出程序
    a(add):添加进队列
    g(get):取数据出队列
    h(head):显示队列头
    a
    输出一个数
    10
    s(show):显示队列
    e(exit):退出程序
    a(add):添加进队列
    g(get):取数据出队列
    h(head):显示队列头
    s
    arr[0]= 10
    arr[1]= 0
    arr[2]= 0
    s(show):显示队列
    e(exit):退出程序
    a(add):添加进队列
    g(get):取数据出队列
    h(head):显示队列头
    a
    输出一个数
    20
    s(show):显示队列
    e(exit):退出程序
    a(add):添加进队列
    g(get):取数据出队列
    h(head):显示队列头
    a
    输出一个数
    30
    s(show):显示队列
    e(exit):退出程序
    a(add):添加进队列
    g(get):取数据出队列
    h(head):显示队列头
    a
    输出一个数
    20
    队列满，不能加入数据
    s(show):显示队列
    e(exit):退出程序
    a(add):添加进队列
    g(get):取数据出队列
    h(head):显示队列头
    s
    arr[0]= 10
    arr[1]= 20
    arr[2]= 30
    s(show):显示队列
    e(exit):退出程序
    a(add):添加进队列
    g(get):取数据出队列
    h(head):显示队列头
    h
    取出的队列头数据：10s(show):显示队列
    e(exit):退出程序
    a(add):添加进队列
    g(get):取数据出队列
    h(head):显示队列头
    g
    取出的数据：10s(show):显示队列
    e(exit):退出程序
    a(add):添加进队列
    g(get):取数据出队列
    h(head):显示队列头
```        
        
### 问题分析并优化
1) 目前数组使用一次就不能用， 没有达到复用的效果
2) 将这个数组使用算法，改进成一个列 环形的队列 取模：%

### 数组模拟环形队列
    对前面的数组模拟队列的优化，充分利用数组. 因此将数组看做是一个环形的。(通过 取模的方式来实现即可)

#### 分析说明：
1) 尾索引的下一个为头索引时表示队列满，即将队列容量空出一个作为约定,这个在做判断队列满的
时候需要注意 (rear + 1) % maxSize == front 满]
2) rear == front [空]

#### 思路如下:
* front 变量的含义做一个调整: front 就指向队列的第一个元素,也就是说ar[front]就是队列的第一个元素
  front的初始值= 0
* rear 变量的含义做一个调整: rear 指向队列的最后一个元素的后一个位置.因为希望空出一个空间做为约定.
  rear的初始值=0
* 当队列满时，条件是(rear +1) % maxSize=front [满]
* 对队列为空的条件，rear== front空
* 当我们这样分析，队列中有效的数据的个数(rear + maxSize- front) % maxSize //rear= 1 front =0
* 我们就可以在原来的队列上修改得到一个环形队列
```mxml
    s(show):显示队列
    e(exit):退出程序
    a(add):添加进队列
    g(get):取数据出队列
    h(head):显示队列头
    s
    队列为空，不能打印数据
    s(show):显示队列
    e(exit):退出程序
    a(add):添加进队列
    g(get):取数据出队列
    h(head):显示队列头
    a
    输出一个数
    10
    s(show):显示队列
    e(exit):退出程序
    a(add):添加进队列
    g(get):取数据出队列
    h(head):显示队列头
    s
    arr[0]=10
    s(show):显示队列
    e(exit):退出程序
    a(add):添加进队列
    g(get):取数据出队列
    h(head):显示队列头
    a
    输出一个数
    20
    s(show):显示队列
    e(exit):退出程序
    a(add):添加进队列
    g(get):取数据出队列
    h(head):显示队列头
    s
    arr[0]=10
    arr[1]=20
    s(show):显示队列
    e(exit):退出程序
    a(add):添加进队列
    g(get):取数据出队列
    h(head):显示队列头
    a
    输出一个数
    30
    s(show):显示队列
    e(exit):退出程序
    a(add):添加进队列
    g(get):取数据出队列
    h(head):显示队列头
    s
    arr[0]=10
    arr[1]=20
    arr[2]=30
    s(show):显示队列
    e(exit):退出程序
    a(add):添加进队列
    g(get):取数据出队列
    h(head):显示队列头
    a
    输出一个数
    40
    队列满，不能加入数据
    s(show):显示队列
    e(exit):退出程序
    a(add):添加进队列
    g(get):取数据出队列
    h(head):显示队列头
    g
    取出的数据：10s(show):显示队列
    e(exit):退出程序
    a(add):添加进队列
    g(get):取数据出队列
    h(head):显示队列头
    s
    arr[1]=20
    arr[2]=30
    s(show):显示队列
    e(exit):退出程序
    a(add):添加进队列
    g(get):取数据出队列
    h(head):显示队列头
    a
    输出一个数
    20
    s(show):显示队列
    e(exit):退出程序
    a(add):添加进队列
    g(get):取数据出队列
    h(head):显示队列头
    s
    arr[1]=20
    arr[2]=30
    arr[3]=20
    s(show):显示队列
    e(exit):退出程序
    a(add):添加进队列
    g(get):取数据出队列
    h(head):显示队列头
```