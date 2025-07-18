package dev.malo.cupcake.model

sealed class Topping() : Ingredient()

class Chocolate() : Topping() {
    override val componentName: String = "🍫"
    override val componentPrice: Double = 0.1
}

class Peanut() : Topping() {
    override val componentName: String = "🥜"
    override val componentPrice: Double = 0.2
}