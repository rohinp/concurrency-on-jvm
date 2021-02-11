package concurrency.promises

import scala.concurrent.Promise
import concurrency.Utilities._
import concurrent.ExecutionContext.Implicits.global

@main def promisesCreate =
  val p = Promise[String]
  val q = Promise[String]
  
  p.future foreach {
    case t => log(s"Promise successeded with ${t}")
  }

  p success "Hello"

  val secondAttempt = p trySuccess "Hello again"

  log(s"What happend to the second attempt $secondAttempt")

  q failure new Exception("promise not kept")
    
  q.future.failed foreach {
    case t => log(s"Promise failed with ${t}")
  }
  
