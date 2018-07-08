
### APP可用内存大小     

1、cat /system/build.prop      

2、cat /system/build.prop | grep heapgrowthlimit     
heapgrowthlimit就是一个普通应用的内存限制      

3、cat /system/build.prop | grep heapsize            
heapsize是在manifest中设置了largeHeap=true之后，   
可以使用的最大内存值      

