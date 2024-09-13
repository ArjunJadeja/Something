package com.arjunjadeja.mistakes

import com.arjunjadeja.Something

class UnsafeCasting {

    private val something: Any = Something()

    // ❌ Avoid this
    fun unsafeCast() {
        val intValue: Int = something as Int  // ClassCastException
        println(intValue)
    }

    // ✅ Do this instead
    fun safeCast() {
        val intValue: Int? = something as? Int
        println(intValue ?: "Casting failed, value is not an Int")
    }
}

/**
 * Notes:
 *
 * 1. Avoid unsafe casting using `as` (`unsafeCast`):
 *    - The `as` operator forces a cast, assuming that the value can be safely cast to the specified type.
 *    - If the cast is not valid (e.g., trying to cast an object to a type it doesn't match), it throws a `ClassCastException`.
 *    - In `unsafeCast`, `something` is an instance of `Something`, not `Int`. Therefore, using `something as Int` will result
 *      in a `ClassCastException`, leading to unsafe and crash-prone code.
 *
 * 2. Use safe casting with `as?` (`safeCast`):
 *    - A safer alternative is to use the safe cast operator (`as?`), which attempts the cast but returns `null` if the cast fails.
 *    - This prevents exceptions and allows you to handle the case where the cast is not valid.
 *    - In `safeCast`, we attempt to cast `something` to an `Int`. If the cast is unsuccessful, `intValue` will be `null`,
 *      and the Elvis operator (`?:`) provides a fallback message ("Casting failed, value is not an Int").
 *
 * 3. General Recommendation:
 *    - Avoid using the `as` operator unless you're certain that the cast will always be valid.
 *    - Prefer using the safe cast operator (`as?`) to prevent `ClassCastException` and ensure your code handles invalid casts gracefully.
 *
 * 4. When to use `as`:
 *    - The `as` operator can be used in situations where you are confident that the value can always be safely cast to the expected type.
 *    - It is suitable when dealing with tightly controlled data or logic where the type is guaranteed.
 *    - However, misuse of `as` can lead to runtime exceptions, so it is often better to use `as?` and handle possible null values.
 */
