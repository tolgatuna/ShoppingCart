package shopping

import org.scalatest.wordspec.AnyWordSpec


class ShoppingCartTest extends AnyWordSpec {
  "Checkout method" should {
    "calculate correct price if there is one item" in {
      val totalPrice = ShoppingCart.checkout(List("Apple"))
      assert(totalPrice === 0.6)
    }

    "calculate correct price if there is more than one item and no discount" in {
      val totalPrice = ShoppingCart.checkout(List("Apple", "Orange", "Orange"))
      assert(totalPrice === 1.1)
    }

    "calculate correct price if there are apples with simple offer `buy one, get one free on Apples`" in {
      val totalPrice = ShoppingCart.checkout(List("Apple", "Apple"))
      assert(totalPrice === 0.6)
    }

    "calculate correct price if there are oranges with simple offer `3 for the price of 2 on Oranges`" in {
      val totalPrice = ShoppingCart.checkout(List("Orange", "Orange"))
      assert(totalPrice === 0.5)
    }

    "calculate correct price for mixed basket" in {
      val totalPrice = ShoppingCart.checkout(List("Apple", "Apple", "Apple", "Orange", "Orange", "Orange", "Orange"))
      // 2 Apples for one price = 0.6
      // 1 extra Apple = 0.6
      // 3 Oranges with one free = 0.5
      // 1 extra Orange = 0.25
      // Total = 1.95
      assert(totalPrice === 1.95)
    }

    "should ignore unavailable products and calculate correct price for other products" in {
      // We can have better solution, but for now we have just ignored the "ASD"
      val totalPrice = ShoppingCart.checkout(List("Apple", "ASD"))
      assert(totalPrice === 0.6)
    }
  }
}
