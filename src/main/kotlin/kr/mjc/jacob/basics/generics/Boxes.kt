package kr.mjc.jacob.basics.generics

data class Box(val value: Any)

data class IntegerBox(val value: Int)

data class StringBox(val value: String)

data class GenericBox<T>(val value: T)