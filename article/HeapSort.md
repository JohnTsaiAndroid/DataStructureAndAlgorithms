# 堆排序

### 优先队列

> 学习链接:
> 
> 1.[维基百科——堆排序](https://zh.wikipedia.org/wiki/%E5%84%AA%E5%85%88%E4%BD%87%E5%88%97)
> 
> 2.[MIT算法课视频——堆排序](https://www.youtube.com/watch?v=B7hVxCmfPtM)
> 
> 3.[MIT算法课PDF——堆排序](http://ocw.mit.edu/courses/electrical-engineering-and-computer-science/6-006-introduction-to-algorithms-fall-2011/lecture-videos/MIT6_006F11_lec04.pdf)

定义:
>抽象数据类型。优先队列的每个元素都有各自的**优先级**。
    优先级高的先得到服务,优先级相同的按照在优先队列中的顺序得到服务。
    
实现:

1. 初级实现：使用有序数组或无序数组或链表。
2. 典型实现：使用堆。

优先队列通常用 [堆](https://zh.wikipedia.org/wiki/%E5%A0%86_(%E6%95%B0%E6%8D%AE%E7%BB%93%E6%9E%84)) 实现。  

### 堆的定义  
堆有序：二叉树的每个结点都大于等于它的两个子结点。
