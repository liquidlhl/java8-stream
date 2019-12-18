# java8-test
notes of learning java8 stream
### java8 stream ###
java8流操作的实践,包含了一些练习,主要如下几个操作

## 筛选与切片 ##
   filter-接收Lambda,从流中排除某些元素  
   limit-截断流,使其元素不超过给定数量  
   skip(n)-跳过元素,返回-个扔掉了n个元素的流。若流中元素不足n个,则返回-个空流与1imit(n)互补  
   distinct-筛选,通过流所生成元素的 hashCode()和 equals()去除重复元素  

## 分组 ##
   按key实现统计分组

### 映射 ##
   map-接收Lambda,将元素转换成其他形式或提取信息。接收-个函数作为参数,该函数会被应用到每个元素上,并将其映射成-个新的元素  
   f1atMap接收-个函数作为参数,将流中的每个值都换成另-个流,然后把所有流连接成-个流  

## 查找与匹配 ##
   allMatch-检查是否匹配所有元素  
   anyMatch-检查是否至少匹配-个元素  
   noneMatch-检查是否没有匹配所有元素  
   findFirst-返回第-个元素  
   findAny-返回当前流中的任意元素  
   count-返回流中元素的总个数  
   max-返回流中最大值  
   min-返回流中最小值  

## 归约 ##
   reduce(identity, BinaryOperator)/ reduce(BinaryOperator)可以将流中元素反复结合起来,得到-个值  

## 收集 ##
   collect-将流转换为其他形式接收-个 Collector接口的实现,用于给 Stream中元素做汇总的方法  

## 排序 ##
   sorted()-自然排序  
   sorted(Comparator com)-定制排序  

## 参考 ##
Java8新特性: https://www.bilibili.com/video/av35195879?p=9  
java8+实战pdf: https://mega.nz/#!76JXWCQS!idGmOx6n41PCkg5bwU0T4dYhk-QcyvLzpWWaWY0eZUM  
