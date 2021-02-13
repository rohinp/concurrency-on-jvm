package concurrency

import java.io.{PrintWriter, StringWriter}
import java.util.Random
import scala.io.AnsiColor._

object Utilities:
  
  /**
   * A simple thread creation utility. As we all know that java threads have a direct maping to the OS threads.
   * Every process, can create some n * 100's of threads, and it seems limited as we know that every thread creation take 1MB os stack space.
   * OS can be optimized and can allow a process to create may be n * 1000's of threads. 
   * */
  def thread[T](body: => T, isDeamon:Boolean = false): Thread = {
    val t = new Thread(new Runnable {
      override def run(): Unit = body
    })
    t.setDaemon(isDeamon)
    t.start()
    t
  }
  
  /**
   * A User thread created:
   * Note: JVM exists only once all the user threads are done execution 
   * */
  def userThread[T](body: => T): Thread = thread(body)

  /**
   * A Daemon thread created:
   * Note: JVM does not waits for the daemon threads to finish 
   * */
  def daemonThread[T](body: => T): Thread = thread(body, true)

  def log(msg:String) = println(s"${BLUE}${BOLD}${Thread.currentThread().getName}${RESET}${BLINK} -> ${RESET} ${YELLOW}${BOLD}$msg${RESET}")

  def stackTraceToString(e:Throwable): String = {
    val sw = new StringWriter
    e.printStackTrace(new PrintWriter(sw))
    sw.toString
  }

  /**
   * Notes from JAVA docs
   * 
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
  def fiber[T](body: => T): Thread = Thread.startVirtualThread(s"Fiber", () => body)

  /**
   * This is another way to create a virtual thread.
   * Thread class provides the Builder interface which is inside Thread class.
   * Will suggest to browse the source code on how the builder is implemented.
   * In this case it creates a virtual thread but does not starts it does in the startVirtualThread static method
   * */
  def makeFiber[T](body: => T): Thread = Thread.builder().virtual().task(() => body).build()
