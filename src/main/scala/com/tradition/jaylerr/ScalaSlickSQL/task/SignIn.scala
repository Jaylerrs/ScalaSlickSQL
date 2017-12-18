package com.tradition.jaylerr.ScalaSlickSQL.task

import com.tradition.jaylerr.ScalaSlickSQL.components.UsersComponent$

import scala.concurrent.Await
import scala.concurrent.duration.Duration

object SignIn {

  def signingIn(): Unit ={
    println("Sign In or press 'Exit' to end this")
    tryToSignIn(getEmail(), getPassword())
  }

  def getEmail(): String ={
    print("Email : ")
    val email:String = input()
    email.toLowerCase()
  }

  def getPassword(): String ={
    print("Password : ")
    val password:String = input()
    password
  }

  def input():String = {
    var temp:String = ""
    try {temp = scala.io.StdIn.readLine()} catch {case _ => temp = "FALSE"}
    temp
  }

  def tryToSignIn(email:String, password:String): Unit ={
    val res = Await.result(UsersComponent$.getSignIn(email, password), Duration.Inf)
    if (res == List()){
      println("Failed to sign in please make sure you have the correct email and password")
    } else if (res.size > 0){
      val user = res(0)
      print("welcome " + user.email + " " + user.name)
    }
    Thread.sleep(1000)
  }
}
