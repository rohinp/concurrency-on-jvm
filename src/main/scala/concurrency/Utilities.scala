package concurrency

import java.io.{PrintWriter, StringWriter}

object Utilities:
  
  def thread[T](body: => T): Thread = {
    val t = new Thread(new Runnable {
      override def run(): Unit = body
    })
    t.start()
    t
  }

  def log(msg:String) = println(s"${Thread.currentThread().getName} -> $msg")

  def stackTraceToString(e:Throwable): String = {
    val sw = new StringWriter
    e.printStackTrace(new PrintWriter(sw))
    sw.toString
  }

  /**
   * {@code Thread} also supports the creation of <i>virtual threads</i> that
   * are scheduled by the Java virtual machine using a small set of platform threads
   * that are used as <em>carrier threads</em>.
   * Virtual threads will typically require few resources and a single Java virtual
   * machine may support millions of virtual threads. Virtual threads are suitable
   * for executing tasks that spend most of the time blocked, often waiting for
   * synchronous blocking I/O operations to complete.
   * Locking and I/O operations are the <i>scheduling points</i> where a carrier thread
   * is re-scheduled from one virtual thread to another. Code executing in virtual
   * threads will usually not be aware of the underlying carrier thread, and in
   * particular, the {@linkplain Thread# currentThread ( )} method, to obtain a reference
   * to the <i>current thread</i>, will return the {@code Thread} object for the virtual
   * thread.
   * */
  def fiber[T](body: => T): Thread = Thread.startVirtualThread(() => body)