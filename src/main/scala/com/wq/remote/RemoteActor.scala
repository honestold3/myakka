package com.wq.remote

import akka.actor.{ActorLogging, Actor}
import akka.util.Timeout
import akka.pattern.ask
import scala.concurrent.Await
import scala.concurrent.duration._

//import akka.actor.{Actor, Props, ActorSystem}
//import com.typesafe.config.ConfigFactory
import com.wq.local._

class RemoteActor extends Actor {
    //val system = ActorSystem("LocalNodeApp", ConfigFactory.load().getConfig("LocalSys"))

    //val localActor = system.actorOf(Props[LocalActor], name = "localActor")
    
    val localActor = context.actorSelection("akka.tcp://LocalNodeApp@10.12.1.15:2552/user/localActor")
    
    def receive = {
     case message: String => 
       println("remote call "+message)
       localActor ! message + " hehe !"
    }
}
