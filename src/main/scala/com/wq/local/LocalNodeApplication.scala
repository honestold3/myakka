package com.wq.local

import akka.actor.{Props, ActorSystem}
import com.typesafe.config.ConfigFactory

object LocalNodeApplication extends App {
  val system = ActorSystem("LocalNodeApp", ConfigFactory.load().getConfig("LocalSys"))

  val localActor = system.actorOf(Props[LocalActor], name = "localActor")
  localActor ! "hello demo actor"

  Thread.sleep(10000)
  system.shutdown()

}
