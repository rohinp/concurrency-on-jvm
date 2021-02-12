package concurrency.basics
import concurrency.Utilities._

@main def firstVirtualThread() =
  for {
    x <- 1 to 100
  } yield fiber {
    Thread.sleep(100)
    log(s"Fiber ${x}")
  }
