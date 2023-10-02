package shopping

sealed abstract class Product(
                               val name: String,
                               val price: Double,
                               val freeItemThreshold: Int
                             )

object Product {
  final case object Apple extends Product(
    name = "Apple",
    price = .60,
    freeItemThreshold = 2
  )

  final case object Orange extends Product(
    name = "Orange",
    price = .25,
    freeItemThreshold = 3
  )

  val availableProducts: Map[String, Product] = Map(
    Apple.name.toUpperCase() -> Apple,
    Orange.name.toUpperCase() -> Orange
  )
}