package com.tradition.jaylerr.ScalaSlickSQL.task

import com.tradition.jaylerr.ScalaSlickSQL.components.UsersComponent$
import com.tradition.jaylerr.ScalaSlickSQL.model.Users

import scala.concurrent.Await
import scala.concurrent.duration.Duration

object SignUp {
  def signingUp(): Unit ={
    println("Sign Up or press 'Exit' to end this")
    tryToSignUp(new Users( (getNo() + 1), getEmail(), getName(), getPassword()))
  }

  def getNo(): Int = {
    val res = Await.result(UsersComponent$.getAll, Duration.Inf)
    Thread.sleep(1000)
    res.size
  }

  def getEmail():String = {
    print("Email : ")
    scala.io.StdIn.readLine().toLowerCase()
  }

  def getName():String = {
    print("Name : ")
    scala.io.StdIn.readLine()
  }

  def getPassword():String = {
    print("Password : ")
    scala.io.StdIn.readLine()
  }

  def tryToSignUp(users: Users): Unit ={
    if (!isExistingUser(users.email)){
      val res = Await.result(UsersComponent$.insert(users), Duration.Inf)
      Thread.sleep(1000)
      res match {
        case 0 => println("Something wrong, Sign up failed")
        case 1 => println("Sign up successfully, please sign in with you email and password")
        case _ => println("Something wrong, this is everything we know about, Please try again")
      }
    } else println("Sign up failed, This email already exit please try to sign in")
  }

  def isExistingUser(email: String): Boolean = {
    val res = Await.result(UsersComponent$.getExisting(email), Duration.Inf)
    Thread.sleep(1000)
    res.size != 0
  }

}
