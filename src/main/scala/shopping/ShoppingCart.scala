package shopping

import shopping.Product.availableProducts

object ShoppingCart {
  def checkout(basket: List[String]): Double = {
    // Maybe basket product control could be added (to check all products exist or not in availableProducts)

    val groupedBasketItems = basket.map(_.toUpperCase())
      .groupBy(identity)
      .view
      .mapValues(_.size)
      .toMap

    groupedBasketItems.flatMap { groupedItem =>
      val (name, count) = groupedItem
      availableProducts.get(name).map { product => {
        val freeItemCount: Int = (count / product.freeItemThreshold)
        (count - freeItemCount) * product.price
      }}
    }.sum
  }
}
