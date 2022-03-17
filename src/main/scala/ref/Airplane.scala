package ref

import zio.{ZIOAppDefault, Ref, Console}

object Airplane extends ZIOAppDefault:

  private val seats = Ref.make(Vector.fill(10)(Option.empty[String]))
  // yep
  def run =
    for
      seating <- seats
      _ <- seating.update(_.updated(1, Some("juancho")))
      vector <- seating.get
      _ <- Console.printLine(vector)
    yield ()

  def book(i: Int) = ???
  