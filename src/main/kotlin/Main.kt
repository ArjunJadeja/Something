package com.arjunjadeja


/**
 * Main function demonstrating mistakes.
 *
 * We know these are mistakes, so adding all function calls in `main` is also a mistake.
 * The first function will throw an exception, and the others will never see the light of day.
 * Rename function to main and comment them out or handle them one by one if you want to avoid total disaster.
 */
fun avoidThisMain() {
    callUninitializedProperties()
    forceUnwrapNull()
    unsafeCast()
    accessNullableCollectionWithoutCheck()
    customGetterBeforeInitialization()
    shadowingVariablesInLambda()
    iterateOverNullableList()
}

/**
 * Main function with safe practices
 *  *
 *  * This main function demonstrates best practices and safe handling in Kotlin,
 *  * avoiding exceptions and promoting null safety, type safety, and readability.
 *  */
fun main() {
    safelyAccessProperties()
    safeUnwrapNull()
    safeCast()
    safelyAccessNullableCollection()
    safelyAccessCustomGetter()
    avoidShadowingVariablesInLambda()
    safelyIterateOverNullableList()
}
