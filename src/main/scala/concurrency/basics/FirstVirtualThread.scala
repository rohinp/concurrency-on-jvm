package concurrency.basics
import concurrency.Utilities._

/**
 * Nothing special here just running 100 task's in virtual thread
 * 
 * Virtual threads are not mapped to the OS thread, a high level understanding is there is a pool of threads which java manages for us.
 * And all our tasks will run in one of those threads in the pool. The default scheduler used is ForkJoin.
 * The way java manages virtual threads you can leterally run million or may be billions of them without frying out your CPU.
 * */
@main def firstVirtualThread() =
  for {
    x <- 1 to 100
  } yield fiber {
    Thread.sleep(100)
    log(s"Fiber ${x}")
  }
