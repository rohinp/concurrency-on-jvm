package concurrency.executor

import concurrency.Utilities.log

import java.io.IOException
import java.net.ServerSocket
import java.net.Socket
import java.util.concurrent.Executor
import java.util.concurrent.Executors
import scala.concurrent.ExecutionContext

@main def taskExecutionWebServer =
  val NTHREADS = 100
  val exec = ExecutionContext.global
  val socket = new ServerSocket(80)
    
  while (true) {
    val connection = socket.accept
    val task = new Runnable() {
      override def run(): Unit = {
        handleRequest(connection)
      }
    }
    exec.execute(task)
  }

  def handleRequest(connection: Socket): Unit =
    log(s"Server stated and listening at ${connection.getLocalPort}")
