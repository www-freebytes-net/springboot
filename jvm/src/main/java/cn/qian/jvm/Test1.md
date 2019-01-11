1.  程序: Test1
2.  jvm参数 :  -Xmx20m -Xms20m -Xmn1m -XX:+PrintGCDetails
     设置堆内存最大最小值为20M，新生代内存为1M，打印详细的堆参数
3.  结果：
[GC (Allocation Failure) [PSYoungGen: 511K->504K(1024K)] 511K->504K(19968K), 0.0024389 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
Heap
 PSYoungGen      total 1024K, used 962K [0x00000000ffe80000, 0x0000000100000000, 0x0000000100000000)
  eden space 512K, 89% used [0x00000000ffe80000,0x00000000ffef2878,0x00000000fff00000)
  from space 512K, 98% used [0x00000000fff00000,0x00000000fff7e030,0x00000000fff80000)
  to   space 512K, 0% used [0x00000000fff80000,0x00000000fff80000,0x0000000100000000)
 ParOldGen       total 18944K, used 10240K [0x00000000fec00000, 0x00000000ffe80000, 0x00000000ffe80000)
  object space 18944K, 54% used [0x00000000fec00000,0x00000000ff6000a0,0x00000000ffe80000)
 Metaspace       used 2873K, capacity 4486K, committed 4864K, reserved 1056768K
  class space    used 308K, capacity 386K, committed 512K, reserved 1048576K
  
  
 4. 结果解释：
 4.1    Allocation Failure 表明本次引起GC的原因是因为在年轻代中没有足够的空间能够存储新的数据了。
 4.2    [PSYoungGen: 511K->504K(1024K)]  使用PSYoungGen垃圾收集器，回收前新生代内存占用511K，回收后占用504K，新生代总内存1024K
 4.3    511K->504K(19968K)  堆内存在gc前占用511K，gc后占用504K，总大小19968K
 4.4    0.0024389 secs 表示gc耗时
 4.5    ParOldGen       total 18944K, used 10240K  表示老年代使用了10M，也就是说程序分配的byte数组对象都直接分到了老年代，
           因为新生代只有1M，不足以接受每次分配的对象
 