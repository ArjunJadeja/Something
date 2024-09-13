package com.arjunjadeja

/**
 * 1. Safely initializing nullable properties
 *
 * This function demonstrates safely handling properties that might be uninitialized.
 * Instead of using `lateinit`, nullable types are used with proper null checks
 * to avoid `UninitializedPropertyAccessException`.
 */
private var initializedSomething: Something? = null
private var initializedAnything: Any? = null

fun safelyAccessProperties() {
    println("1. Safely accessing nullable properties")

    initializedSomething?.let {
        println(it.toString())
    } ?: println("initializedSomething is not initialized")

    initializedAnything?.let {
        println(it.hashCode())
    } ?: println("initializedAnything is not initialized")
}

/**
 * 2. Safely handling nullable values without using `!!`
 *
 * This function demonstrates safely handling nullable types using the `?.` (safe call)
 * operator and the Elvis operator (`?:`) instead of forcing nulls using `!!`,
 * preventing `NullPointerException`.
 */
fun safeUnwrapNull() {
    println("\n2. Safely handling nullable values")
    val nullableString: String? = null
    val length = nullableString?.length ?: "String is null"
    println(length)
}

/**
 * 3. Safe casting with `as?` (safe cast)
 *
 * This function demonstrates using the safe cast (`as?`) operator to avoid
 * `ClassCastException`. If the cast fails, the result will be `null`.
 */
fun safeCast() {
    println("\n3. Safe casting")
    val anyValue: Any = "Kotlin"
    val intValue: Int? = anyValue as? Int
    println(intValue ?: "Casting failed, value is not an Int")
}

/**
 * 4. Safely accessing a nullable collection with null checks
 *
 * This function demonstrates safely accessing a nullable collection using
 * a null check or the `?.` (safe call) operator to avoid `NullPointerException`.
 */
fun safelyAccessNullableCollection() {
    println("\n4. Safely accessing nullable collection")
    val nullableList: List<String>? = null
    val size = nullableList?.size ?: "List is null"
    println(size)
}

/**
 * 5. Safely iterating over a nullable list
 *
 * This function demonstrates safely iterating over a nullable list and handling
 * nullable elements inside the list to avoid `NullPointerException`.
 */
fun safelyIterateOverNullableList() {
    println("\n5. Safely iterating over nullable list")
    val nullableList: List<String?> = listOf("one", null, "three")
    nullableList.forEach {
        val length = it?.length ?: "Element is null"
        println(length)
    }
}

/**
 * 6. Proper initialization before accessing property in custom getter
 *
 * This class demonstrates safely accessing a property in a custom getter by ensuring
 * that it is properly initialized before accessing it.
 */
class SafeCustomClass {
    private var name: String = "Default Name"
    val customName: String
        get() = name.uppercase()
}

/**
 * This function demonstrates proper initialization of properties in `SafeCustomClass`
 * and safely accessing the `customName` property without causing a `NullPointerException`.
 */
fun safelyAccessCustomGetter() {
    println("\n6. Safely accessing property in custom getter")
    val customClass = SafeCustomClass()
    println(customClass.customName)
}

/**
 * 7. Avoiding variable shadowing inside lambdas
 *
 * This function demonstrates avoiding variable shadowing within a lambda by ensuring
 * that inner variables have distinct names, preventing confusion and unexpected behavior.
 */
fun avoidShadowingVariablesInLambda() {
    println("\n7. Avoiding variable shadowing in lambda")
    val number = 5
    val list = listOf(1, 2, 3)
    list.forEach { listItem ->
        println(listItem)  // Properly prints the list elements (1, 2, 3)
    }
}
