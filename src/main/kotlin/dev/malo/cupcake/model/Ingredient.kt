package dev.malo.cupcake.model

/**
 * Simple leaf
 */
sealed class Ingredient() : Component {
    //TODO prototype pattern for cloning objects and keeping them immutable (val topping)
    protected var topping: Topping? = null

    protected abstract val componentName: String
    protected abstract val componentPrice: Double

    protected fun add(extraTopping: Topping): Ingredient = apply {
        when (topping) {
            null -> topping = extraTopping
            else -> topping!!.add(extraTopping)
        }
    }

    override fun name(): String =
        when (topping) {
            null -> componentName
            else -> "$componentName $nameSeparator ${topping!!.name()}"
        }

    override fun price(): Double =
        when (topping) {
            null -> componentPrice
            else -> componentPrice + topping!!.price()
        }
}

//TODO visitor pattern would handle this concern externally
private val Ingredient.nameSeparator: String
    get() = when (this) {
        is Cake -> "with"
        is Topping -> "and"
    }
