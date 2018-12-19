// Return the set of products that were ordered by every customer
fun Shop.getSetOfProductsOrderedByEveryCustomer(): Set<Product> {
    var list: List<Set<Product>> = customers.map { it.orders.flatMap { it.products }.toSet() }
    return list.fold(setOf<Product>(), {accumulated, element -> accumulated.intersect(element)})
}
