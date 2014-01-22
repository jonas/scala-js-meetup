package example.dom

import scala.scalajs.js

trait DOMDocument extends js.Object {
  def createElement(name: js.String): HTMLElement = ???
  val body: HTMLElement
}
