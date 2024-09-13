package com.arjunjadeja.mistakes

import com.arjunjadeja.Something

class CustomGetter {

    private val someClass = SomeClass()
    private val someSafeClass = SomeSafeClass()
    private val safeClass = SomeSafeClass()

    fun customGetterBeforeInitialization() = println(someClass.someString)  // NullPointerException
    fun safelyAccessCustomGetter() = println(safeClass.someString)
    fun safelyAccessCustomGetterAgain() = println(safeClass.someString)
}

// ❌ Avoid this
private class SomeClass {
    private var something: Something? = null
    val someString: String
        get() = something!!.toString()  // NullPointerException if `name` is null
}

// ✅ Do this instead
private class SomeSafeClass {
    private var something: Something? = null
    val someString: String
        get() = something?.toString() ?: "Default"
}

// ✅ Do this instead
private class SafeClass {
    private var something: String = "Default Name"
    val someString: String
        get() = something.uppercase()
}

/**
 * Notes:
 *
 * 1. Avoid using `!!` in custom getters (`SomeClass`):
 *    - In the custom getter of `someString`, the value of `something` is force-unwrapped using `!!`. If `something` is null,
 *      this will cause a `NullPointerException`.
 *    - In `customGetterBeforeInitialization`, trying to access `someClass.someString` leads to a `NullPointerException` because
 *      `something` is null.
 *
 * 2. Safely handle null in custom getters (`SomeSafeClass`):
 *    - A safer approach is to use the safe call operator (`?.`) in the getter, so that `something?.toString()` returns `null`
 *      if `something` is null, and the Elvis operator (`?:`) provides a fallback value like "Default".
 *    - In `safelyAccessCustomGetter`, the getter works safely by returning a default string if `something` is null.
 *
 * 3. Using guaranteed initialization in custom getters (`SafeClass`):
 *    - In `SafeClass`, `something` is guaranteed to be initialized with a non-null value, making it safe to use directly
 *      in the getter without the need for null checks.
 *    - The getter transforms the string (e.g., by converting it to uppercase), demonstrating a custom getter on a guaranteed
 *      non-null property.
 *    - In `safelyAccessCustomGetterAgain`, the value is safely accessed, as `something` is never null.
 *
 * 4. General Recommendation:
 *    - Avoid using `!!` in custom getters because it can lead to runtime exceptions.
 *    - Use safe calls (`?.`) and fallback values (`?:`) to handle null cases gracefully, or ensure values are initialized
 *      before accessing them.
 *
 * 5. When to use `!!`:
 *    - Use `!!` only when you're absolutely sure the property will never be null. In custom getters, it's generally safer
 *      to handle nullable cases explicitly with safe calls and fallback values.
 */
