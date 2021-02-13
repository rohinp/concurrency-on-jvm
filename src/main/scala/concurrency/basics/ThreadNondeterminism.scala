package concurrency.basics

import concurrency.Utilities._
/**
 * Here is a simple example where we can see how the basic units be it fiber or platform threads 
 * can be non deterministic, and we need some kind of synchronization inorder to make our threads have a 
 * deterministic behaviour.
 * */
@main def threadNondeterminism =
  val t = userThread{
    log("This print is non deterministic")
  }
  log("1...")
  log("2...")
  log("3...")
  log("Back to main thread")

/**
 * As virtual threads are tasks run by a scheduler in a thread pool.
 * Thus by default those are daemon threads, in that case we might need to have a join on the thread.
 * When we create a virtual thread, it returns a reference of the thread which might run our task.
 * Taking that reference we can do join in order to make sure our main thread waits till the task is finished.
 * */
@main def fiberNondeterminism =
  val t = fiber{
    log("This print is non deterministic")
  }
  log("1...")
  log("2...")
  log("3...")
  t.join()
  log("Back to main thread")
