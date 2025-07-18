package dev.malo.cupcake

import dev.malo.cupcake.model.Bundle
import dev.malo.cupcake.model.Chocolate
import dev.malo.cupcake.model.Cookie
import dev.malo.cupcake.model.Cupcake
import dev.malo.cupcake.model.Peanut

fun main() {
    println("# Cupcakes & Cookies:")

    listOf(
        Cupcake(),
        Cookie(),
        Cupcake() with Chocolate(),
        Cookie() with Chocolate(),
        Cupcake() with Chocolate() and Peanut(),
        Cookie() with Chocolate() and Peanut(),
        // Cookie() with Cupcake(), // doesn't compile
        // Chocolate() with Peanut() // doesn't compile
        // Peanut() and Peanut(), // doesn't compile
    ).joinToString(separator = "\n") {
        """
        ${it.price()}$ for "${it.name()}"
        """.trimIndent()
    }.let { println(it) }

    println()
    println("# Bundles:")

    Bundle(
        Cupcake() with Chocolate(),
        Bundle(Bundle(Bundle())),
        Cupcake() with Peanut(),
        Bundle(
            Cookie(),
            Cookie() with Peanut(),
        ),
        Bundle(
            Cookie(),
            Cookie() with Chocolate(),
            Cookie() with Chocolate() and Chocolate() and Chocolate() and Chocolate() and Chocolate(),
            Bundle(
                Bundle(
                    Cupcake() with Chocolate() and Chocolate() and Chocolate(),
                    Cupcake() with Peanut() and Chocolate() and Peanut(),
                ),
                Bundle()
            ),
        )
    ).let { println("${it.price()}$ for \n${it.description()}") }
}
