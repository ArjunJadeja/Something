package com.arjunjadeja

/**
 * 1. Uninitialized `lateinit` properties
 *
 * This function demonstrates accessing uninitialized `lateinit` properties,
 * which leads to an `UninitializedPropertyAccessException`.
 */
private lateinit var uninitializedSomething: Something
private lateinit var uninitializedAnything: Any

fun callUninitializedProperties() {
    println("1. Accessing uninitialized lateinit properties")
    println(uninitializedSomething.toString())  // UninitializedPropertyAccessException
    println(uninitializedAnything.hashCode())   // UninitializedPropertyAccessException
}

/**
 * 2. Using `!!` to force unwrap a null value
 *
 * This function demonstrates forcing a null value using the `!!` operator,
 * which results in a `NullPointerException`.
 */
fun forceUnwrapNull() {
    println("\n2. Force unwrapping null")
    val nullableString: String? = null
    println(nullableString!!.length)  // NullPointerException
}

/**
 * 3. Unsafe cast without checking type
 *
 * This function demonstrates an unsafe cast without type checking, leading to a
 * `ClassCastException` when the actual type of the value doesn't match the expected type.
 */
fun unsafeCast() {
    println("\n3. Unsafe cast")
    val anyValue: Any = "Kotlin"
    val intValue: Int = anyValue as Int  // ClassCastException
    println(intValue)
}

/**
 * 4. Access nullable collection without null check
 *
 * This function demonstrates accessing a nullable collection without performing a
 * null check, which results in a `NullPointerException`.
 */
fun accessNullableCollectionWithoutCheck() {
    println("\n4. Accessing nullable collection without null check")
    val nullableList: List<String>? = null
    println(nullableList!!.size)  // NullPointerException
}

/**
 * 5. Iterating over a nullable list without null safety
 *
 * This function demonstrates iterating over a list containing nullable elements and
 * accessing the elements without null safety, which results in a `NullPointerException`
 * when encountering a null element.
 */
fun iterateOverNullableList() {
    println("\n5. Iterating over nullable list without null safety")
    val nullableList: List<String?> = listOf("one", null, "three")
    nullableList.forEach {
        println(it!!.length)  // NullPointerException when `it` is null
    }
}

/**
 * 6. Access property in a custom getter before initialization
 *
 * This class demonstrates accessing a property within a custom getter before it has been
 * initialized, resulting in a `NullPointerException`.
 */
class CustomClass {
    private var name: String? = null
    val customName: String
        get() = name!!.uppercase()  // NullPointerException if `name` is null
}

/**
 * This function calls the custom getter of the `CustomClass` before initializing the
 * property, demonstrating the resulting `NullPointerException`.
 */
fun customGetterBeforeInitialization() {
    println("\n6. Access property in custom getter before initialization")
    val customClass = CustomClass()
    println(customClass.customName)  // NullPointerException
}

/**
 * 7. Shadowing variables inside a lambda
 *
 * This function demonstrates the shadowing of variables within a lambda, which can
 * lead to confusion and unexpected results. In this case, the variable `it` inside
 * the lambda is shadowed, leading to unexpected output.
 */
fun shadowingVariablesInLambda() {
    println("\n7. Shadowing variables in lambda")
    val number = 5
    val list = listOf(1, 2, 3)
    list.forEach {
        val it = number  // Shadowing `it`
        println(it)  // Always prints 5, not the list elements
    }
}
