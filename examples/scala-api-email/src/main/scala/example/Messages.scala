package example

import scala.scalajs.js

object Messages {

  def notSupported(email: String): String =
    s"Email provider for ${email} is not supported"

}
