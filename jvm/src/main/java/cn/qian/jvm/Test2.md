1.  程序: Test2
2.  jvm参数 :  -Xmx20m -Xms20m -Xmn15m -XX:+PrintGCDetails
     设置堆内存最大最小值为20M，新生代内存为15M，打印详细的堆参数
3.  结果：
  Heap 
   PSYoungGen      total 13824K, used 12017K [0x00000000ff100000, 0x0000000100000000, 0x0000000100000000)
    eden space 12288K, 97% used [0x00000000ff100000,0x00000000ffcbc608,0x00000000ffd00000)
    from space 1536K, 0% used [0x00000000ffe80000,0x00000000ffe80000,0x0000000100000000)
    to   space 1536K, 0% used [0x00000000ffd00000,0x00000000ffd00000,0x00000000ffe80000)
   ParOldGen       total 5120K, used 0K [0x00000000fec00000, 0x00000000ff100000, 0x00000000ff100000)
    object space 5120K, 0% used [0x00000000fec00000,0x00000000fec00000,0x00000000ff100000)
   Metaspace       used 2873K, capacity 4486K, committed 4864K, reserved 1056768K
    class space    used 308K, capacity 386K, committed 512K, reserved 1048576K
  
 4. 结果解释：
 4.1    PSYoungGen      total 13824K, used 12017K  新生代总共13824K，用了12017k。
 4.2    ParOldGen       total 5120K, used 0K        老年代没有使用，因为新生代足够大，可以容纳10M的内存，
            所以没有触发GC 因此没有使用到老年代
 