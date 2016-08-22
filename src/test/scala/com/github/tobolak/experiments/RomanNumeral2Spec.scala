package com.github.tobolak.experiments

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.{FlatSpec, Matchers}

@RunWith(classOf[JUnitRunner])
class RomanNumeral2Spec extends FlatSpec with Matchers {

  "A roman numeral" should "have single symbol when transformed from certain integers" in {
    RomanNumeral2(1) should be(RomanNumeral2("I"))
    RomanNumeral2(5) should be(RomanNumeral2("V"))
    RomanNumeral2(10) should be(RomanNumeral2("X"))
    RomanNumeral2(50) should be(RomanNumeral2("L"))
    RomanNumeral2(100) should be(RomanNumeral2("C"))
    RomanNumeral2(500) should be(RomanNumeral2("D"))
    RomanNumeral2(1000) should be(RomanNumeral2("M"))
  }

  it should "convert additions" in {
    RomanNumeral2(2) should be(RomanNumeral2("II"))
    RomanNumeral2(3) should be(RomanNumeral2("III"))
    RomanNumeral2(6) should be(RomanNumeral2("VI"))
    RomanNumeral2(7) should be(RomanNumeral2("VII"))
    RomanNumeral2(8) should be(RomanNumeral2("VIII"))
    RomanNumeral2(11) should be(RomanNumeral2("XI"))
    RomanNumeral2(15) should be(RomanNumeral2("XV"))
    RomanNumeral2(17) should be(RomanNumeral2("XVII"))
    RomanNumeral2(20) should be(RomanNumeral2("XX"))
    RomanNumeral2(37) should be(RomanNumeral2("XXXVII"))
    RomanNumeral2(78) should be(RomanNumeral2("LXXVIII"))
    RomanNumeral2(278) should be(RomanNumeral2("CCLXXVIII"))
    RomanNumeral2(778) should be(RomanNumeral2("DCCLXXVIII"))
    RomanNumeral2(2778) should be(RomanNumeral2("MMDCCLXXVIII"))
  }

  it should "handle subscractions" in {
    RomanNumeral2(4) should be(RomanNumeral2("IV"))
    RomanNumeral2(9) should be(RomanNumeral2("IX"))
    RomanNumeral2(29) should be(RomanNumeral2("XXIX"))
    RomanNumeral2(40) should be(RomanNumeral2("XL"))
    RomanNumeral2(41) should be(RomanNumeral2("XLI"))
    RomanNumeral2(94) should be(RomanNumeral2("XCIV"))
    RomanNumeral2(244) should be(RomanNumeral2("CCXLIV"))
    RomanNumeral2(434) should be(RomanNumeral2("CDXXXIV"))
    RomanNumeral2(1984) should be(RomanNumeral2("MCMLXXXIV"))
    RomanNumeral2(3999) should be(RomanNumeral2("MMMCMXCIX"))
  }

  it should "throw exceptions" in {
    an[IllegalArgumentException] should be thrownBy RomanNumeral2(4000)
    an[IllegalArgumentException] should be thrownBy RomanNumeral2(0)
  }
}




