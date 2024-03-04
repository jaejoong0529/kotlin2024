package kr.mjc.jacob.concepts.functions

import java.util.concurrent.TimeUnit
import java.util.concurrent.locks.Condition
import java.util.concurrent.locks.Lock

fun main() {
  val s = "abcde"
  myWith(s) {
    println(length)
  }

  val r1 = Resource("Gold")

  var count = 0

  for (i in 1..10) lock(r1) { println("mining ${count++}") }
}

fun <T, R> myWith(receiver: T, block: T.() -> R): R = receiver.block()

inline fun lock(resource: Lock, run: () -> Unit) {
  resource.lock()
  try {
    run()
  } finally {
    resource.unlock()
  }
}

class Resource(private val firstName: String) : Lock {
  override fun lock() {
    println("$firstName 리소스를 잠갔습니다.")
  }

  override fun lockInterruptibly() {
    TODO("Not yet implemented")
  }

  override fun tryLock(): Boolean {
    TODO("Not yet implemented")
  }

  override fun tryLock(time: Long, unit: TimeUnit): Boolean {
    TODO("Not yet implemented")
  }

  override fun unlock() {
    println("$firstName 리소스를 해제했습니다.")
  }

  override fun newCondition(): Condition {
    TODO("Not yet implemented")
  }
}


