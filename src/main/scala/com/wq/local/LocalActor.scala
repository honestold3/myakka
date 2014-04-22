package com.wq.local

import akka.actor.{ActorLogging, Actor}
import akka.util.Timeout
import akka.pattern.ask
import scala.concurrent.Await
import scala.concurrent.duration._

class LocalActor extends Actor with ActorLogging {
  val remoteActor = context.actorSelection("akka.tcp://RemoteNodeApp@10.12.1.113:2554/user/remoteActor")
  implicit val timeout = Timeout(5 seconds)

  def receive = {
    case message: String =>
      println("local call "+message)
      val future = (remoteActor ? message).mapTo[String]
      //val result = Await.result(future, timeout.duration)
      //log.info("Message received from server -> {}", result)
      
      //remoteActor ! "hehe!"
  }
}
