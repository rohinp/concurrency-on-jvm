package concurrency.basics
import concurrency.Utilities._


def looper(count:Int):Unit =
  val tid = Thread.currentThread.getId
  if (count > 500) ()
    else {
      try {
        Thread.sleep(10)
        if (count % 100 == 0) log("Thread id: " + tid + " : " + count)
      } catch {
        case e: InterruptedException => e.printStackTrace()
      }
      looper(count - 1)
  }

/**
 * Try using user/daemon thread and run the program, check the activity monitor/ task monitor on your OS
 * 
 * There Will be a huge spike, as all CPU will get busy.
 * 
 * Now comment the user thread and use the virtual thread (fiber method). 
 * You can see the difference very clearly how the virtual threads are meant to execute millions
 * of blocking tasks without any issue.
 *
 * Note: Run the user/daemon thread version on your own risk, it might make you VM go crazy ;-)
 **/
@main def crashTheVM =
  val threads = List[Thread]()
  for (i <- 0 until 2000000) {
    //threads.appended(userThread(() => looper(1)))
    threads.appended(fiber(() => looper(1)))
    if (i % 1000 == 0) log(s"$i fiber started")
  }
  // Join all the threads
  threads.foreach((t: Thread) => {
    def foo(t: Thread) = {
      try t.join()
      catch {
        case e: InterruptedException =>
          e.printStackTrace()
      }
    }
    foo(t)
  })
