package com.github.tobolak.experiments

object RomanNumeral2 {
  private val SEGMENTS = Seq(("M", 1000), ("CM", 900), ("D", 500), ("CD", 400), ("C", 100),
    ("XC", 90), ("L", 50), ("XL", 40), ("X", 10), ("IX", 9), ("V", 5), ("IV", 4), ("I", 1))

  def apply(value: Int): RomanNumeral2 = {
    require(value > 0 && value < 4000)
    RomanNumeral2(romanString(value))
  }

  private def romanString(remainder: Int): String = greatestSegmentNotExceeding(remainder)
    .map { case (symbol, value) => symbol + romanString(remainder - value) }
    .getOrElse("")

  private def greatestSegmentNotExceeding(max: Int) = SEGMENTS.find { case (symbol, value) => value <= max }
}

case class RomanNumeral2(numeralString: String)