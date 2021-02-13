package concurrency.basics

import concurrency.Utilities._
/**
 * In build.sbt we have set fork to true to make sure that the threads are 
 * spawn in a seperate jvm and not the same where sbt is running
 *
 * */
@main def runningThread(): Unit = {
  userThread{
    Thread.sleep(200)
    log("I'm a user thread and JVM will wait for me to finish")
  }
  
  daemonThread{
    Thread.sleep(500)
    log("I'm a daemon thread and JVM will not wait for me to finish, I wont be printed on screen")
  }
  
  log(s"Main thread is by default user thread Thread.currentThread().isDaemon ${Thread.currentThread().isDaemon}")
}

