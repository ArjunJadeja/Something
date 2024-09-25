package com.arjunjadeja.learnings

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

class ThenWithComposeModifier {

    // ✅ Example 1: Conditional Modifier Application Using `then`
    @Composable
    fun LoadSomeLayout(platform: Platform, content: @Composable () -> Unit) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .then(
                    when (platform) {
                        Platform.MOBILE -> Modifier.aspectRatio(9f / 16f)
                        Platform.TABLET -> Modifier.aspectRatio(16 / 10f).padding(16.dp)
                        Platform.DESKTOP -> Modifier.aspectRatio(4 / 3f).padding(32.dp)
                    }
                ),
            contentAlignment = Alignment.Center
        ) {
            content()
        }
    }

    // ✅ Example 2: Dynamic Modifier Addition with `then`
    @Composable
    fun DynamicModifierExample(isSelected: Boolean, content: @Composable () -> Unit) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .then(
                    if (isSelected) {
                        Modifier.padding(16.dp).background(Color.Green)
                    } else {
                        Modifier.padding(8.dp).background(Color.Gray)
                    }
                ),
            contentAlignment = Alignment.Center
        ) {
            content()
        }
    }

    // ❌ Example 3: Unnecessary Chaining with `then`
    @Composable
    fun UnnecessaryChaining(content: @Composable () -> Unit) {
        // Avoid using `then` when modifiers can be chained directly
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .then(Modifier.padding(8.dp)) // ❌ Unnecessary usage of `then`
                .then(Modifier.background(Color.Blue)) // ❌ Another redundant `then`
                .then(Modifier.padding(4.dp)), // ❌ Chaining directly would be simpler and clearer
            contentAlignment = Alignment.Center
        ) {
            content()
        }
    }

    enum class Platform {
        MOBILE,
        TABLET,
        DESKTOP
    }
}

/**
 * Notes on Using `then` in Jetpack Compose Modifiers:
 *
 * 1. What is `then`?
 *    - `then` is an extension function on `Modifier` that allows chaining another `Modifier` to an existing one.
 *    - It helps combine multiple modifiers, which can be especially useful when applying conditional modifiers.
 *    - Each `then` call returns a new `Modifier` representing the combined chain of modifiers.
 *
 * 2. Benefits of Using `then`:
 *    - Enhances readability: By separating base modifiers from conditional ones, `then` makes code clearer and more organized.
 *    - Supports conditional logic: Easily append modifiers based on state, device type, or other conditions.
 *    - Allows dynamic modifier composition, making UI code more flexible and responsive to changes.
 *
 * 3. How to Use `then`:
 *    - Combine base modifiers with conditionally applied modifiers:
 *      ```kotlin
 *      val baseModifier = Modifier.fillMaxWidth()
 *      val combinedModifier = baseModifier.then(
 *          if (isSelected) Modifier.padding(16.dp) else Modifier.padding(8.dp)
 *      )
 *      ```
 *    - Use in `Composable` functions to adjust layout properties dynamically.
 *    - In `LoadSomeLayout`, `then` appends the platform-specific modifier to the base `fillMaxWidth` modifier.
 *
 * 4. What Not to Do:
 *    - ❌ Avoid using `then` unnecessarily when the modifiers can be directly chained.
 *    - ❌ Don’t use `then` if it makes the modifier chain harder to read or maintain.
 *    - ❌ Be cautious of performance when chaining many modifiers; ensure each added modifier serves a clear purpose.
 *
 * 5. Recommendations:
 *    - Use `then` when you have conditional modifiers that need to be appended to a base modifier.
 *    - Keep the chain simple and readable; use `then` to keep conditional logic clean and separate.
 *    - Test modifiers visually to ensure the combined effect meets design expectations.
 */