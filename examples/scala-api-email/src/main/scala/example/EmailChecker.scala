package example

import scala.scalajs.js

class EmailChecker {

  val emailProviders = List("@gmail.com", "@hotmail.com", "...")

  def isValid(email: String): Boolean = {
   return emailProviders.exists(email.endsWith(_))
  }

}
