package com.accord.base
import com.wix.accord.specs2.ResultMatchers
import org.specs2.mutable.Specification
import org.specs2.matcher.Matchers
import com.wix.accord._
/**
 * @author Rishi
 */
class AccordExampleTest extends Specification with Matchers with ResultMatchers{
  
  val validUser = User("Rishi",26,"0123456789","M")
  "User validator" should {
    "succeed on a valid user" in {
      validate( validUser ) should succeed
    }
    "fail on an invalid user for empty name" in {
      val invalidUser = validUser.copy( name = "" )
      validate( invalidUser ) should fail
    }
    "fail on an invalid user for age less than 18" in {
      val invalidUser = validUser.copy( age = 15 )
      validate( invalidUser ) should fail
    }
    "fail on an invalid user for empty sex" in {
      val invalidUser = validUser.copy( sex = "" )
      validate( invalidUser ) should failWith( "sex" -> "must not be empty" )
    }
     "fail on an invalid user for wrong phone no" in {
      val invalidUser = validUser.copy( phone = "123456" )
      validate( invalidUser ) should fail
    }
  }
}