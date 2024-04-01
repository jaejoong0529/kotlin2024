package kr.mjc.jacob.spring.springdata.user

import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Slice
import org.springframework.data.jdbc.repository.query.Modifying
import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.repository.Repository
import org.springframework.transaction.annotation.Transactional

/**
 * Repository 인터페이스를 확장한 인터페이스의 구현체는
 * 개발자가 구현하지 않고 스프링이 구현한다.
 */
@Transactional(readOnly = true)
interface UserRepository : Repository<User, Int> {
  fun findById(id: Int): User?

  fun findByUsername(username: String): User?

  fun findAll(pageable: Pageable): Slice<User>

  @Transactional
  fun deleteById(id: Int)

  @Transactional
  fun save(user: User): User

  @Modifying
  @Transactional
  @Query("update user set password=:password where id=:id")
  fun changePassword(id: Int, password: String)
}
