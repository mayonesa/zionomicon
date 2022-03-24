package promise

import zio.Console.printLine

// serve 1 batch of coffee (20 coffees/batch). There are 3 baristas on this shift.
object Cafe:
  // for 1 batch
  val grind = printLine("1. grind coffee for batch")

  // for individual coffee
  val fillBasket = printLine("2. fill basket with coffee grind")
  val tamp = printLine("3. tamp coffee")
  val extract = printLine("4. extract coffee")

  // for 1 batch
  val serve = printLine("5. serving all coffees in batch")