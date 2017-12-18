package com.tradition.jaylerr.ScalaSlickSQL.model

import com.tradition.jaylerr.ScalaSlickSQL.connection.{DBComponent, MySqlComponent}

case class Users (id :Int, email :String, name :String, password:String)

trait UsersTable extends MySqlComponent {
  this: DBComponent =>
  import driver.api._

  class UsersTable(tag: Tag) extends Table[Users] (tag, "users") {
    val id = column[Int]("id" , O.PrimaryKey)
    val email = column[String]("email")
    val name = column[String]("name")
    val password = column[String]("password")
    def * = (id, email, name, password) <> (Users.tupled, Users.unapply)
  }

  val usersTableQuery = TableQuery[UsersTable]
}
