package com.tradition.jaylerr.ScalaSlickSQL.components

import com.tradition.jaylerr.ScalaSlickSQL.connection.DBComponent
import com.tradition.jaylerr.ScalaSlickSQL.model.{Users, UsersTable}

import scala.concurrent.{Await, Future}
import scala.concurrent.duration.Duration

trait UsersComponent$ extends UsersTable {

  this: DBComponent =>
  import driver.api._

  def create = db.run(usersTableQuery.schema.create)

  def insert(user: Users) = db run {
    usersTableQuery += user
  }

  def delete(mail: String) = {
    val query = usersTableQuery.filter(x => x.email === mail).delete
    db.run(query)
  }

  def getAll : Future[List[Users]] = db run {
    usersTableQuery.to[List].result
  }

  def getMaxId(): Int = {
    val user = Await.result(UsersComponent$.getAll, Duration.Inf); Thread.sleep(1000);
    val u = user(user.size - 1)
    u.id
  }

  def getSignIn(email: String, password:String) : Future[List[Users]] = db run {
    usersTableQuery.filter(x => x.email === email && x.password === password).to[List].result
  }

  def getExisting(email: String) : Future[List[Users]] = db run {
    usersTableQuery.filter(x => x.email === email).to[List].result
  }

  def sortByUsersName() {
    val sortedNames = usersTableQuery.sortBy(x => x.name)
    println(sortedNames)
  }

  def sortByUsersID() {
    val sortedNames = usersTableQuery.sortBy(x => x.id)
    println(sortedNames)
  }

  def getMember : Future[List[Users]] = db run {
    usersTableQuery.sortBy(x => x.name).to[List].result
  }
}


object UsersComponent$ extends UsersComponent$