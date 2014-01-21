package example

import scala.scalajs.js
import org.scalajs.dom._
import org.scalajs.jquery._

object ScalaJSExample {

  val emailProviders = List("@gmail.com", "@hotmail.com", "...")

  def main(): Unit = {
    jQuery("#button").click { e: JQueryEventObject =>
      val email = jQuery("#email").`val`().asInstanceOf[String]
      if (emailProviders.exists(email.endsWith(_)))
        console.log("Send data to server")
      else
        alert(s"Email provider for ${email} is not supported")
    }
  }

}
