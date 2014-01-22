package example

import scala.scalajs.js

object jQuery extends js.Object {
  def apply(selector: js.Any): jQuery = ???
}

trait jQuery extends js.Object {
  def html(): js.String
  def html(value: js.String): this.type

  def click[U](f: js.Function0[U]): this.type
}

object ScalaJSExample {

  def main(): Unit = {
    var count = 0
    val link = jQuery("#link")
    link.click { () =>
      count += 1
      link.html(s"Clicked ${count} times")
    }
  }

}
