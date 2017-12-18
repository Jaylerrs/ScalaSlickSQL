package com.tradition.jaylerr.ScalaSlickSQL.connection

import slick.jdbc.JdbcProfile

trait DBComponent {

  val driver: JdbcProfile
  import driver.api._
  def db: Database

}
