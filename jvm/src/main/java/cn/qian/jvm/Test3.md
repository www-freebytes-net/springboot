1.  程序: Test3
2.  jvm参数 :  -Xmx20m -Xms20m -Xmn7m -XX:+PrintGCDetails       
     设置堆内存最大最小值为20M，新生代内存为7M，打印详细的堆参数
3.  结果：
[GC (Allocation Failure) [PSYoungGen: 5381K->504K(6656K)] 5381K->1632K(19968K), 0.0014377 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
[GC (Allocation Failure) [PSYoungGen: 5742K->504K(6656K)] 6870K->2696K(19968K), 0.0006764 secs] [Times: user=0.02 sys=0.02, real=0.00 secs] 
Heap
 PSYoungGen      total 6656K, used 1589K [0x00000000ff900000, 0x0000000100000000, 0x0000000100000000)
  eden space 6144K, 17% used [0x00000000ff900000,0x00000000ffa0f748,0x00000000fff00000)
  from space 512K, 98% used [0x00000000fff80000,0x00000000ffffe010,0x0000000100000000)
  to   space 512K, 0% used [0x00000000fff00000,0x00000000fff00000,0x00000000fff80000)
 ParOldGen       total 13312K, used 2192K [0x00000000fec00000, 0x00000000ff900000, 0x00000000ff900000)
                                                 object space 13312K, 16% used [0x00000000fec00000,0x00000000fee24030,0x00000000ff900000)
 Metaspace       used 2874K, capacity 4486K, committed 4864K, reserved 1056768K
  class space    used 308K, capacity 386K, committed 512K, reserved 1048576K
  
 4. 结果解释：
进行了两次垃圾回收，堆内存第一次回收掉3.7 第二次回收掉4.2M
这时对象基本不进入servivor区，因为太小了
 
 