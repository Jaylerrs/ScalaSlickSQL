package com.tradition.jaylerr.ScalaSlickSQL

import com.tradition.jaylerr.ScalaSlickSQL.components.UsersComponent$
import com.tradition.jaylerr.ScalaSlickSQL.task.{SignIn, SignUp}

import scala.concurrent
import scala.concurrent.Await
import scala.concurrent.duration.Duration
import scala.language.postfixOps

object main extends App {

  def startUp(): Unit ={
    println(
      """
        | +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
        | |                                     |
        | + Welcome to Scala Database Tutorial  +
        | |                                     |
        | +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+""".stripMargin)
    println(
      """press 0, End this
        |press 1, Sign in
        |press 2, Sign up""".stripMargin)
    menu()
  }

  override def main(args: Array[String]): Unit = {
    startUp()
  }

  def menu(): Unit ={
    print("Select : ")
    val temp = select()
    temp match {
      case 0 => endThis()
      case 1 => signIn()
      case 2 => signUp()
      case _ => invalidInput()
    }
  }

  def select():Int = {
    var temp:Int = 0
    try {
      temp = scala.io.StdIn.readInt()
    }
    catch {
      case _ => temp = -1
    }
    temp
  }

  def invalidInput(): Unit ={
    println("Please select only we have provided")
    menu()
  }

  def endThis(): Unit ={
    println("Good Bye ^^")
  }

  def signIn(): Unit ={
    SignIn.signingIn()
    startUp()
  }

  def signUp(): Unit ={
    SignUp.signingUp()
    startUp()
  }
}


