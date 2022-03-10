package concurrencyoperators

import zio.{URIO, UIO}

trait SearchEngine:
  def results(str: String): UIO[Seq[String]]
  def nSearches(userId: Int): URIO[String, Int]

object Google extends SearchEngine:
  def results(str: String): UIO[Seq[String]] = ???

  // limited to 5 concurrent searches per client.
  // may be left as is
  def nSearches(userId: Int): URIO[String, Int] = ???

object Bing extends SearchEngine:
  def results(str: String): UIO[Seq[String]] = ???
  def nSearches(userId: Int): URIO[String, Int] = ???
