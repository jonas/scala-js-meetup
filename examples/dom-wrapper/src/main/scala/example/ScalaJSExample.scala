package example

import scala.scalajs.js

object ScalaJSExample {

  def main(): Unit = {
    val p = dom.document.createElement("p")
    p.innerHTML = "Hello from the DOM API"
    dom.document.body.appendChild(p)
  }

}
