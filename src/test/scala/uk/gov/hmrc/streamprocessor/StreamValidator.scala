package uk.gov.hmrc.streamprocessor

import org.scalatest.{WordSpec, Matchers}

object StreamValidator {

//  /**
//     * Generates a stream of tuple values A, B & C which is sorted by the lowest value of c
//     * which satisfy the equation:
//     * `2 * a * a + b * b = c * c`
//     *
//     * @return A stream of [[Tuple tuples]] satisfying the equation 2*a*a+b*b=c*c where
//     *         a,b and c are unsigned integers and a > 0 and b > 0.
//     */
//    def generateABCTuples(): Stream[Tuple] = {
//      for {
//        c <- Stream.from(1)
//        minimiseCCal = c * c
//        b <- 1 until c
//        a <- 2 until c
//        if minimiseCCal == 2 * a * a + b * b
//      } yield Tuple(a, b, c)
//    }

//  def validateByRow[A](id : A) : Unit = {
//    val fromGridfs = """row1,
//                       |row2,
//                       |row3
//                     """.getBytes
//
//    for {
//      c <- Stream.iterate[Byte](fromGridfs[0])(endOfLine _)
//
//    } yield {
//      println("c [" + new String(c) + "]")
//      c
//    }
//  }
//
//
//  def endOfLine(in : Byte) : Byte = {
//    println("I've been called!")
//    in.toString
//  }

}

/**
 * A tuple
 * @param A The value of A
 * @param B The value of B
 * @param C The value of C
 */
case class Tuple(A: Int, B: Int, C: Int)


class StreamSpec extends WordSpec with Matchers {

  "print" in {
    StreamValidator.validateByRow("id")
  }
}