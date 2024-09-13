package com.arjunjadeja.mistakes

import com.arjunjadeja.Something

class UninitializedProperties {

    private lateinit var something: Something

    // ❌ Avoid this
    fun callUninitializedProperties() = println(something.toString())  // UninitializedPropertyAccessException

    // ✅ Do this instead
    fun checkInitializedProperties() = if (this::something.isInitialized) println(something.toString())
    else println("initializedSomething is not initialized")
}

// Do this instead
class InitializedProperty {
    private var something: Something? = null
    fun printSomething() = print(something?.toString() ?: "String is null")
}

/**
 * Notes:
 *
 * 1. Uninitialized `lateinit` properties (`UninitializedProperties`):
 *    - Using `lateinit` allows you to delay the initialization of a property.
 *    - However, if you try to access the property before initializing it,
 *      it will throw an `UninitializedPropertyAccessException`.
 *    - In `UninitializedProperties`, we directly try to access `uninitializedSomething`, which hasn't been initialized,
 *      leading to an exception. This is dangerous and should be avoided.
 *
 * 2. Checking initialization of `lateinit` (`CheckingInitializedProperties`):
 *    - If you still want to use `lateinit`, Kotlin provides a way to check if it has been initialized using
 *      `this::property.isInitialized`.
 *    - In `CheckingInitializedProperties`, before accessing `initializedSomething`, we check if it has been initialized.
 *    - This prevents the `UninitializedPropertyAccessException` and ensures safe property access.
 *
 * 3. Using nullable properties (`SafelyInitializedProperties`):
 *    - A safer approach is to use nullable properties (`Something?`) and perform null checks.
 *    - In `SafelyInitializedProperties`, we check if the property is null using `?.let` before accessing it.
 *    - This ensures that the property is only accessed if it is initialized.
 *    - If the property is not initialized, the code inside `?:` (the Elvis operator) executes, providing a default message.
 *    - This pattern avoids exceptions and handles potentially uninitialized properties gracefully.
 *
 * 4. Recommendation:
 *    - Using nullable properties with proper null checks (`SafelyInitializedProperties`) is generally safer.
 *    - If you use `lateinit`, always check its initialization status before accessing the property.
 */
