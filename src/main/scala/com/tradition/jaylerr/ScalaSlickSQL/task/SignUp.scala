package com.tradition.jaylerr.ScalaSlickSQL.task

import com.tradition.jaylerr.ScalaSlickSQL.components.UsersComponent$
import com.tradition.jaylerr.ScalaSlickSQL.model.Users

import scala.concurrent.Await
import scala.concurrent.duration.Duration

object SignUp {
  val read = scala.io.StdIn
  def signingUp(): Unit ={ println("Sign Up or press 'Exit' to end this");
    tryToSignUp(new Users( (getNo() + 1), getEmail(), getName(), getPassword()))}

  def getNo(): Int = { UsersComponent$.getMaxId() }

  def getEmail():String = {print("Email : "); read.readLine().toLowerCase()}

  def getName():String = {print("Name : "); read.readLine()}

  def getPassword():String = {print("Password : "); read.readLine()}

  def tryToSignUp(users: Users): Unit ={
    if (!isExistingUser(users.email)){
      val res = Await.result(UsersComponent$.insert(users), Duration.Inf); Thread.sleep(1000)
      res match {
        case 0 => println("Something wrong, Sign up failed")
        case 1 => println(s"Sign up successfully, Welcome ${users.name}")
        case _ => println("Something wrong, this is everything we know about, Please try again")}
    } else println(s"Sign up failed, This email : ${users.email} already exist")
  }

  def isExistingUser(email: String): Boolean = { val res = Await.result(UsersComponent$.getExisting(email), Duration.Inf)
    Thread.sleep(1000); res.size != 0}
}
