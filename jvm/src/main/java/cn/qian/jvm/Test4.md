1.  程序: Test3
2.  jvm参数 :  -Xmx20m -Xms20m -Xmn7m -XX:+PrintGCDetails  -XX:SurvivorRatio=2
     设置堆内存最大最小值为20M，新生代内存为7M，eden与幸存区的比率为2:1:1    打印详细的堆参数
3.  结果：
[GC (Allocation Failure) [PSYoungGen: 3186K->1528K(5632K)] 3186K->1648K(18944K), 0.0008831 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
[GC (Allocation Failure) [PSYoungGen: 4678K->1512K(5632K)] 4798K->1648K(18944K), 0.0007746 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
[GC (Allocation Failure) [PSYoungGen: 4654K->1528K(5632K)] 4790K->1688K(18944K), 0.0004853 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
Heap
 PSYoungGen      total 5632K, used 3731K [0x00000000ff900000, 0x0000000100000000, 0x0000000100000000)
  eden space 4096K, 53% used [0x00000000ff900000,0x00000000ffb26f98,0x00000000ffd00000)
  from space 1536K, 99% used [0x00000000ffd00000,0x00000000ffe7e040,0x00000000ffe80000)
  to   space 1536K, 0% used [0x00000000ffe80000,0x00000000ffe80000,0x0000000100000000)
 ParOldGen       total 13312K, used 160K [0x00000000fec00000, 0x00000000ff900000, 0x00000000ff900000)
  object space  , 1% used [0x00000000fec00000,0x00000000fec28000,0x00000000ff900000)
 Metaspace       used 2874K, capacity 4486K, committed 4864K, reserved 1056768K
  class space    used 308K, capacity 386K, committed 512K, reserved 1048576K
  
 4. 结果解释：
触发了三次垃圾回收，对象会进如幸存区，因为空间足够，老年代基本用不到

发生的gc次数太多，会影响系统性能，因此需要调整