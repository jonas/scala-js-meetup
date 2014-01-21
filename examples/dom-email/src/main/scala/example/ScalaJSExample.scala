package example

import scala.scalajs.js
import org.scalajs.dom._

object ScalaJSExample {

  val emailProviders = List("@gmail.com", "@hotmail.com", "...")

  def main(): Unit = {
    val button = document.getElementById("button")
    val emailInput = document.getElementById("email").asInstanceOf[HTMLInputElement]
    button.onclick = checkEmail _
    def checkEmail(e: MouseEvent): js.Any = {
      val email: String = emailInput.value
      if (emailProviders.exists(email.endsWith(_)))
        console.log("Send data to server")
      else
        alert(s"Email provider for ${email} is not supported")
      true
    }
  }

}
