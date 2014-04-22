package com.wq.remote

import akka.actor.{Props, ActorSystem}
import com.typesafe.config.ConfigFactory

object WqApplication {
    def main(args: Array[String]){
        implicit val context = ActorSystem("RemoteNodeApp",ConfigFactory.load.getConfig("RemoteSys"))
        val server = context.actorOf(Props[RemoteActor], name = "remoteActor")
        Thread.sleep(30000)
        context.shutdown()
    }
    
} 
