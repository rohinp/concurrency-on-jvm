package concurrency.executor

import java.net.Socket
import java.net.ServerSocket
import concurrency.Utilities._

@main def singleThreadWebserver =
  val socket = new ServerSocket(80)
  while(true){
    val connection = socket.accept()
    handleRequest(connection)
  }

  def handleRequest(connection: Socket): Unit =
    log(s"Server stated and listening at ${connection.getLocalPort}")
