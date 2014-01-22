package example

import scala.scalajs.js

object ScalaJSExample {

  val console = js.Dynamic.global.console

  def main(): Unit = {
    def isWednesday(date: js.Date) =
      js.RegExp("Wed").exec(date.toString) ne null

    val date = new js.Date
    val todayIsWednesday = isWednesday(date)
    console.log(date, " is Wednesday? ", todayIsWednesday)

    val time = date.getTime
    date.setTime(time + 24 * 60 * 60 * 1000)
    console.log(date, " is Wednesday? ", isWednesday(date))

    val arr = js.Array[js.String]()
    arr.push("Scala.js")
    arr.push(s"Date: $date")
    console.log(arr)

    val msg = arr.length.toInt match {
      case 2 => console.log("Has two items")
      case _ => console.log("Has ${arr.length} items")
    }
  }

}
