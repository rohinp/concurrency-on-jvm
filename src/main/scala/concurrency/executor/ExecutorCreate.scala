package concurrency.executor

import java.util.concurrent.ForkJoinPool
import concurrency.Utilities._

import scala.concurrent.ExecutionContext

case class MyError(msg:String) extends RuntimeException

@main def executorCreate =  
  val pool = ExecutionContext.fromExecutor(null, {
    case MyError(e) => log(s"Error msg is ${e}")
    case _ => log("Unhandled Exception")
  })

  pool.execute(() => {log(s"Task completed")})
  pool.execute(() => {
    log(s"Task throwing error completed")
    throw MyError("Some error in th thread...")
  })
  
    
  Thread.sleep(5000)
  log("Main executed...")

