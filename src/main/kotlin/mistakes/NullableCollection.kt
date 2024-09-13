package com.arjunjadeja.mistakes

import com.arjunjadeja.Something

class NullableCollection {

    private val nullableList: List<Something>? = null

    // ❌ Avoid this
    fun accessNullableCollectionWithoutCheck() = println(nullableList!!.size)  // NullPointerException

    // ✅ Do this instead
    fun safelyAccessNullableCollection() = println(nullableList?.size ?: "List is null")
}

/**
 * Notes:
 *
 * 1. Avoid using `!!` to force access to nullable collections (`accessNullableCollectionWithoutCheck`):
 *    - The `!!` operator forces access to a nullable value, assuming it is not null.
 *    - If the collection is actually null, a `NullPointerException` will be thrown, leading to unsafe code.
 *    - In `accessNullableCollectionWithoutCheck`, `nullableList` is null. Using `nullableList!!.size` will result in a
 *      `NullPointerException`, which should be avoided.
 *
 * 2. Safely access nullable collections (`safelyAccessNullableCollection`):
 *    - The safe call operator (`?.`) is a better alternative. It accesses the collection only if it is not null,
 *      and otherwise returns `null` without throwing an exception.
 *    - The Elvis operator (`?:`) provides a fallback when the collection is null. In this case, a message ("List is null")
 *      is printed instead of attempting to access a null value.
 *    - In `safelyAccessNullableCollection`, `nullableList?.size` safely checks if the list is non-null, and if it is null,
 *      we print "List is null" rather than causing a crash.
 *
 * 3. General Recommendation:
 *    - Avoid using `!!` to force access to nullable collections, as it can lead to `NullPointerException`.
 *    - Prefer using safe call (`?.`) and Elvis operator (`?:`) to handle nullable collections gracefully.
 *
 * 4. When to use `!!`:
 *    - You should use `!!` only if you're certain that the collection is never null in that context.
 *    - However, this is rare, and in most cases, it's safer to perform a null check using the safe call operator.
 */
