package dev.malo.cupcake.model

/**
 * Common interface for every component of the tree (leaf / container)
 */
interface Component {
    fun name(): String
    fun price(): Double
}