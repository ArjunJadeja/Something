package com.arjunjadeja.mistakes

import com.arjunjadeja.Something

class LambdaVariableShadowing {

    private val something: Something? = null
    private val someList = listOf(1, 2, 3, 4)

    // ❌ Avoid this
    fun shadowingVariablesInLambda() = someList.forEach { something ->  // Shadowing the external variable
        println(something)
    }

    // ✅ Do this instead
    fun avoidShadowingVariablesInLambda() = someList.forEach { listItem ->
        println(listItem)
    }

    // ✅ Do this instead
    fun usingItInLambda() = someList.forEach {
        println(it)
    }
}

/**
 * Notes:
 *
 * 1. Avoid shadowing variables in lambdas (`shadowingVariablesInLambda`):
 *    - Shadowing occurs when a lambda parameter has the same name as a variable in the outer scope.
 *    - In `shadowingVariablesInLambda`, the lambda parameter is named `something`, which shadows the `something` variable declared outside.
 *    - This causes confusion because within the lambda, `something` refers to the lambda's parameter, not the external variable.
 *      This could lead to unintended behavior and makes the code harder to understand.
 *
 * 2. Avoid shadowing by using distinct names for lambda parameters (`avoidShadowingVariablesInLambda`):
 *    - To avoid shadowing, you should give the lambda parameter a unique, meaningful name that doesn't conflict with external variables.
 *    - In `avoidShadowingVariablesInLambda`, the parameter `listItem` clearly refers to the items in the `someList`, making it distinct from the outer `something` variable. This avoids confusion and makes the code easier to follow.
 *
 * 3. Use the `it` keyword for concise single-parameter lambdas (`usingItInLambda`):
 *    - For simple cases where the lambda has a single parameter, Kotlin provides the implicit `it` keyword, which represents the lambda's argument.
 *    - In `usingItInLambda`, `it` refers to the current item in the list, making the code more concise without shadowing external variables.
 *    - Using `it` is idiomatic Kotlin, but it should be avoided in more complex lambdas where readability might suffer. In such cases, giving the parameter a meaningful name is preferred.
 *
 * 4. General Recommendation:
 *    - Avoid shadowing variables in lambdas by using distinct names for lambda parameters, as shadowing can lead to bugs and confusing code.
 *    - Use the `it` keyword for simple lambdas with one parameter, but switch to named parameters for more complex or nested lambdas where clarity is essential.
 *    - Always strive for readability and clarity in lambdas to avoid misunderstandings and errors in your code.
 *
 * 5. When to allow shadowing:
 *    - Variable shadowing might be acceptable in very simple or isolated cases, but in most scenarios, it's better to use distinct names for clarity and maintainability.
 *    - Always assess whether shadowing improves or complicates the code, and use it judiciously if necessary.
 */
