package com.accord.base
import com.wix.accord.Validator
import com.wix.accord.dsl._
/**
 * @author Rishi
 */
case class User(name: String, age: Int, phone: String, sex: String)

case object User {
  implicit val minorValidator: Validator[User] =
    validator[User] { user =>
      user.age > 18 is true
      user.name is notEmpty
      user.phone.length() >= 10  is true
      user.sex is notEmpty
    }
}