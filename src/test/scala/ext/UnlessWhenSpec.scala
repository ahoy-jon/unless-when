package scala.ext

import UnlessWhen._
import org.scalatest.{FunSpec, Matchers}

/**
 * Created by lloydmeta on 8/6/14.
 */
class UnlessWhenSpec extends FunSpec with Matchers {

  describe("when") {

    it("should return None if the predicate is false"){
      when (4 < 2)(0) should be (None)
    }

    it("should return Some(value) if the predicate is false"){
      when(4 > 2)(0) should be (Some(0))
    }

    it("should be 'lazy") {
      when(4 < 2){ Iterator.from(0).sum} should be (None)
    }

  }

  describe("unless") {

    it("should return Some(value) if the predicate is false") {
      unless(4 < 2)(0) should be (Some(0))
    }

    it("should return None if the predicate is true") {
      unless(4 > 2)(0) should be (None)
    }

    it("should be 'lazy") {
      unless(4 > 2){ Iterator.from(0).sum} should be (None)
    }
  }

}