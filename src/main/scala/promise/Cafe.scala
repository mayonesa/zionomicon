package promise

import zio.Console.printLine
import zio.*

// serve 1 batch of coffee (20 coffees/batch). There are 3 baristas on this shift.
// 1 rule: a barista/coffee
object Cafe extends ZIOAppDefault:
  // for 1 batch
  val grind = printLine("1. grind coffee for batch")

  // for individual coffee
  private def fillBasket(coffeeId: Int) = printLine(s"2. fill basket with coffee grind ($coffeeId)")
  private def tamp(coffeeId: Int) = printLine(s"3. tamp coffee ($coffeeId)")
  private def extract(coffeeId: Int) = printLine(s"4. extract coffee ($coffeeId)")

  // for 1 batch
  val serve = printLine("5. serving all coffees in batch")

  override def run =
    def makeCoffee(coffeeId: Int) =
      for
        ms  <- Random.nextIntBetween(0, 1000)
        _   <- fillBasket(coffeeId).delay(ms.milliseconds)
        ms1 <- Random.nextIntBetween(0, 1000)
        _   <- tamp(coffeeId).delay(ms1.milliseconds)
        ms2 <- Random.nextIntBetween(0, 1000)
        _   <- extract(coffeeId).delay(ms2.milliseconds)
      yield ()

    grind *> ZIO.foreachPar(1 to 20)(makeCoffee).withParallelism(3) *> serve
