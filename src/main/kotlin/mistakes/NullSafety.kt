package com.arjunjadeja.mistakes

import com.arjunjadeja.Something

class NullSafety {

    private val something: Something? = null

    // ❌ Avoid this
    fun forceUnwrapNull() = println(something!!.toString())  // NullPointerException

    // ✅ Do this instead
    fun safeHandlingOfNullable() = println(something?.toString() ?: "String is null")
}

/**
 * Notes:
 *
 * 1. Avoid using `!!` to force unwrap nullable values (`forceUnwrapNull`):
 *    - The `!!` operator forces the assumption that the value is non-null. If the value is actually null,
 *      it throws a `NullPointerException`, leading to unsafe and undesirable code.
 *    - In `forceUnwrapNull`, `nullableString` is null. Using `nullableString!!.length` will result in a `NullPointerException`,
 *      which should be avoided.
 *
 * 2. Use safe call (`?.`) and Elvis operator (`safeHandlingOfNullable`):
 *    - A safer alternative is to use the safe call operator (`?.`). It only accesses the value if it's not null,
 *      otherwise, it returns null and avoids exceptions.
 *    - The Elvis operator (`?:`) allows you to provide a default value when the expression is null.
 *    - In `safeHandlingOfNullable`, we use `nullableString?.length` to check if `nullableString` is non-null,
 *      and if it is null, we print "String is null" instead of causing an exception.
 *
 * 3. General Recommendation:
 *    - Avoid using `!!` unless you're absolutely sure that the value is guaranteed to be non-null.
 *    - Prefer using the safe call operator and null checks to ensure your code handles null values safely.
 *
 * 4. When to use `!!`:
 *    - The `!!` operator can be used in situations where you are certain that the value cannot be null.
 *    - It is typically used in cases where you have complete control over the data source,
 *      or after a series of checks that guarantee the value will be non-null (e.g., after explicit null checks).
 *    - Be cautious with `!!`, as misuse can lead to runtime exceptions. It is often safer to use other Kotlin features,
 *      such as the safe call operator (`?.`) or smart casting.
 */
