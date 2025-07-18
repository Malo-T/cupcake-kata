package dev.malo.cupcake.model

import kotlin.math.roundToInt

/**
 * Composite / Container leaf
 */
data class Bundle(
    val items: List<Component>,
    val indent: Int = 1
) : Component {
    constructor(vararg items: Component) : this(items.asList())

    private val discount: Double = 0.1

    //TODO use visitor pattern to decouple from the component (and remove indent field)
    fun description(): String = name()

    override fun name(): String =
        buildString {
            appendLine("-> Bundle (${price()}$ after ${discount * 100}% discount):")
            items.map {
                when (it) {
                    is Bundle -> it.copy(indent = indent + 1)
                    else -> it
                }
            }.forEach {
                append("  ".repeat(indent))
                when (it) {
                    is Bundle -> /*if (it.items.isNotEmpty())*/ append(it.description())
                    else -> append("-> ").appendLine("${it.name()} (${it.price()}$)")
                }
            }
        }

    // don't reapply discount to bundles
    override fun price(): Double =
        items.sumOf {
            when (it) {
                is Bundle -> it.price()
                else -> (it.price() * (1 - discount))
            }
        }.twoDecimals()
}

fun Double.twoDecimals() = (this * 100).roundToInt() / 100.0