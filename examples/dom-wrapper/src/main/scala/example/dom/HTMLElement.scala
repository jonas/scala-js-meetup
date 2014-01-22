package example.dom

import scala.scalajs.js

trait HTMLElement extends js.Object {
  def appendChild(child: HTMLElement): HTMLElement = ???
  var innerHTML: js.String
}
