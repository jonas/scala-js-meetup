package example

import scala.scalajs.js
import js.Dynamic.{global => g}

object ScalaJSExample {

  def main(): Unit = {
    val document = g.document
    val p = document.createElement("p")
    p.innerHTML = js.Dynamic.newInstance(g.Date)()

    val styles: js.Dictionary = js.Dynamic.literal(
      color = "green",
      fontWeight = "bold"
    )

    for (cssProperty <- js.Dictionary.propertiesOf(styles)) {
      val pStyles = p.style.asInstanceOf[js.Dictionary]
      pStyles(cssProperty) = styles(cssProperty)
    }

    document.body.appendChild(p)
  }

}
