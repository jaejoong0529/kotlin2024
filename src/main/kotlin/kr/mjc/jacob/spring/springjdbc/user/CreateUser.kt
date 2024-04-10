package kr.mjc.jacob.spring.springjdbc.user

import kr.mjc.jacob.bcryptHashed
import kr.mjc.jacob.jdbc.user.User
import kr.mjc.jacob.jdbc.user.UserDao
import kr.mjc.jacob.spring.springjdbc.applicationContext
import org.slf4j.LoggerFactory
import org.springframework.dao.EmptyResultDataAccessException
import java.util.*

fun main() {
  val userDao = applicationContext.getBean(UserDao::class.java)
  val log = LoggerFactory.getLogger({}.javaClass)

  print("Create user - username(email) password firstName ? ")
  val user = Scanner(System.`in`).use {
    User(username = it.next(), password = it.next().bcryptHashed,
        firstName = it.next())
  }

  try {
    userDao.getByUsername(user.username)
    log.debug("username이 존재합니다.")
  } catch (e: EmptyResultDataAccessException) { // username이 없을 경우
    val userCreated = userDao.create(user)
    log.info(userCreated.toString())
  }
}
