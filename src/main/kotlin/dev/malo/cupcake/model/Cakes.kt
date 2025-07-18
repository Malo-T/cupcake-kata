package dev.malo.cupcake.model

/**
 * Note: this could also be a composite, with a list of toppings.
 */
sealed class Cake() : Ingredient() {
    /**
     * Will always set the first topping of the base cake
     * Multiple calls to [with] will override the topping. This is basiccaly a topping setter.
     */
    infix fun with(topping: Topping): Cake = apply { this.topping = topping }

    /**
     * Add a topping to the current ingredient if not already present.
     * Else, add the topping to the existing one (recursive).
     */
    infix fun and(extraTopping: Topping): Cake = apply { add(extraTopping) }
}

class Cupcake() : Cake() {
    override val componentName: String = "🧁"
    override val componentPrice: Double = 1.0
}

class Cookie() : Cake() {
    override val componentName: String = "🍪"
    override val componentPrice: Double = 2.0
}