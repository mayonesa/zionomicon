package ref

import zio.{ZIOAppDefault, Ref, Console, UIO}

object Airplane extends ZIOAppDefault:

  private val seats : UIO[Vector[Ref[Option[String]]]] = UIO.foreach(0 until 10) { _ => 
    Ref.make(Option.empty[String])
  }.map(_.toVector)
  // yep
  def run =
    for
      seating <- seats
      _ <-  UIO.foreachPar(1 to 10) { i =>
        seating(0).update(_ => Some("passenger" + i))
      } 
      _ <- Console.printLine(seating)
    yield ()
