package kr.mjc.jacob.spring.jpa.user

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime

/**
 * Repository 인터페이스를 확장한 인터페이스의 구현체는
 * 개발자가 구현하지 않고 스프링이 구현한다.
 */
interface UserRepository : JpaRepository<User, Long> {

  fun findByUsername(username: String): User?

  @Modifying
  @Transactional
  @Query("update User set lastLogin=:lastLogin where id=:id")
  fun updateLastLogin(id: Long, lastLogin: LocalDateTime)

  @Modifying
  @Transactional
  @Query("update User set password=:password where id=:id")
  fun changePassword(id: Long, password: String)
}
