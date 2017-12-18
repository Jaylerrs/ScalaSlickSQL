package com.tradition.jaylerr.ScalaSlickSQL.connection
import slick.driver.MySQLDriver
trait MySqlComponent extends DBComponent{
  val driver = MySQLDriver
  import driver.api._
  val db = Database.forConfig("mySqlDb")

}
