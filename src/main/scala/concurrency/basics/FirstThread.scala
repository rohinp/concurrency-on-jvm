package concurrency.basics

import concurrency.Utilities._

@main def runningThread(): Unit = {
  thread{
    Thread.sleep(500)
    log("I'm a new thread")
  }
  //Main thread is by default user thread
  log(s"Thread.currentThread().isDaemon ${Thread.currentThread().isDaemon}")
  log("I'm in main")
}

