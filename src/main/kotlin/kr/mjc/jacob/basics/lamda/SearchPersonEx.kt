package kr.mjc.jacob.basics.lamda

data class Person(val name: String, val age: Int)

fun main() {
  val roster = listOf(
    Person("Perter", 10),
    Person("Andre", 20),
    Person("Jacob", 30),
    Person("John", 40)
  )

  printPersons(roster) { p -> p.age >= 30 }
  printPersons(roster, ::overThirty)
}

fun printPersons(roster: List<Person>, test: (Person) -> Boolean) {
  roster.forEach { if (test(it)) println(it) }
}

fun overThirty(p: Person) = p.age >= 30
