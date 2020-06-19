1.  程序: Test3
2.  jvm参数 :  -Xmx20m -Xms20m -XX:NewRatio=1 -XX:+PrintHeapAtGC  -XX:SurvivorRatio=3
     设置堆内存最大最小值为20M，新生代与老年代内存比率为1:1，eden与幸存区的比率为3:1:1    打印GC前后的详细堆参数
3.  结果：
{Heap before GC invocations=1 (full 0):
 PSYoungGen      total 8192K, used 5381K [0x00000000ff600000, 0x0000000100000000, 0x0000000100000000)
  eden space 6144K, 87% used [0x00000000ff600000,0x00000000ffb41678,0x00000000ffc00000)
  from space 2048K, 0% used [0x00000000ffe00000,0x00000000ffe00000,0x0000000100000000)
  to   space 2048K, 0% used [0x00000000ffc00000,0x00000000ffc00000,0x00000000ffe00000)
 ParOldGen       total 10240K, used 0K [0x00000000fec00000, 0x00000000ff600000, 0x00000000ff600000)
  object space 10240K, 0% used [0x00000000fec00000,0x00000000fec00000,0x00000000ff600000)
 Metaspace       used 2867K, capacity 4486K, committed 4864K, reserved 1056768K
  class space    used 307K, capacity 386K, committed 512K, reserved 1048576K
Heap after GC invocations=1 (full 0):
 PSYoungGen      total 8192K, used 1688K [0x00000000ff600000, 0x0000000100000000, 0x0000000100000000)
  eden space 6144K, 0% used [0x00000000ff600000,0x00000000ff600000,0x00000000ffc00000)
  from space 2048K, 82% used [0x00000000ffc00000,0x00000000ffda6020,0x00000000ffe00000)
  to   space 2048K, 0% used [0x00000000ffe00000,0x00000000ffe00000,0x0000000100000000)
 ParOldGen       total 10240K, used 8K [0x00000000fec00000, 0x00000000ff600000, 0x00000000ff600000)
  object space 10240K, 0% used [0x00000000fec00000,0x00000000fec02000,0x00000000ff600000)
 Metaspace       used 2867K, capacity 4486K, committed 4864K, reserved 1056768K
  class space    used 307K, capacity 386K, committed 512K, reserved 1048576K
}
{Heap before GC invocations=2 (full 0):
 PSYoungGen      total 8192K, used 6926K [0x00000000ff600000, 0x0000000100000000, 0x0000000100000000)
  eden space 6144K, 85% used [0x00000000ff600000,0x00000000ffb1daf8,0x00000000ffc00000)
  from space 2048K, 82% used [0x00000000ffc00000,0x00000000ffda6020,0x00000000ffe00000)
  to   space 2048K, 0% used [0x00000000ffe00000,0x00000000ffe00000,0x0000000100000000)
 ParOldGen       total 10240K, used 8K [0x00000000fec00000, 0x00000000ff600000, 0x00000000ff600000)
  object space 10240K, 0% used [0x00000000fec00000,0x00000000fec02000,0x00000000ff600000)
 Metaspace       used 2867K, capacity 4486K, committed 4864K, reserved 1056768K
  class space    used 307K, capacity 386K, committed 512K, reserved 1048576K
Heap after GC invocations=2 (full 0):
 PSYoungGen      total 8192K, used 1736K [0x00000000ff600000, 0x0000000100000000, 0x0000000100000000)
  eden space 6144K, 0% used [0x00000000ff600000,0x00000000ff600000,0x00000000ffc00000)
  from space 2048K, 84% used [0x00000000ffe00000,0x00000000fffb2030,0x0000000100000000)
  to   space 2048K, 0% used [0x00000000ffc00000,0x00000000ffc00000,0x00000000ffe00000)
 ParOldGen       total 10240K, used 8K [0x00000000fec00000, 0x00000000ff600000, 0x00000000ff600000)
  object space 10240K, 0% used [0x00000000fec00000,0x00000000fec02000,0x00000000ff600000)
 Metaspace       used 2867K, capacity 4486K, committed 4864K, reserved 1056768K
  class space    used 307K, capacity 386K, committed 512K, reserved 1048576K
}
  
 4. 结果解释：
Heap before GC invocations=1  表示第一次gc前的堆信息
Heap after GC invocations=1      表示第一次gc后的堆信息

数据表明 每次新生的对象都被放入eden区，当eden区内存将近临界值时，就会被gc回收  
第一次eden区达到5.3m时，被回收掉3.7M，剩余的1.6m被放入from区，因为from内存足够，不必放入老年代
这个例子相比Test4，增大了新生代的内存，所以gc就少了一次