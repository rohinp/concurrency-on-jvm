package concurrency.promises

import scala.concurrent.{Future, Promise}
import scala.concurrent.ExecutionContext.global
import scala.util.control.NonFatal
object CustomFuture:
  def myFuture[T](body: => T):Future[T] = {
    val p = Promise[T]
    global.execute(new Runnable {
      override def run(): Unit = try{
        val result = body
        p success result
      }catch {
        case NonFatal(e) => 
          p failure e
      }
    })
    p.future
  }

