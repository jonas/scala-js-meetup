package example

import scala.scalajs.js

object ScalaJSExample {

  val emailProviders = List("@gmail.com", "@hotmail.com", "...")

  def main(): Unit = {
    val g = js.Dynamic.global
    val button = g.document.getElementById("button")
    button.onclick = { () =>
      val email = g.document.getElementById("email").value.asInstanceOf[String]
      if (emailProviders.exists(email.endsWith(_)))
        g.console.log("Send data to server")
      else
        g.alert(s"Email provider for ${email} is not supported")
    }
  }

}
