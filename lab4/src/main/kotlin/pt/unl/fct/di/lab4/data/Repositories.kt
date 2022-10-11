package pt.unl.fct.di.lab4.data

import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import java.util.*

interface ProductRepository : CrudRepository<Product,Long> {
    fun findByDescription(desc:String): Optional<Product>
}

interface ClientRepository : CrudRepository<Client,Long> {
    fun findByName(name:String): Optional<Client>
}

data class ProductStorePair(val p:Product, val s:Store)

interface OrderRepository : CrudRepository<Order,Long> {

    @Query("select distinct s from Order o inner join o.lines l inner join l.product p inner join p.stores s where o.number = :number")
    fun findStores(number:Long):Collection<Store>

    @Query("select distinct new pt.unl.fct.di.lab4.data.ProductStorePair(p,s) from Order o inner join o.lines l inner join l.product p inner join p.stores s where o.number = :number")
    fun findProductPairs(number:Long):Collection<ProductStorePair>

    @Query("select o from Order o inner join fetch o.lines l inner join fetch l.product where o.number = :number")
    fun findByIdWithLines(number:Long):Collection<Order>

}

interface LinesRepository : CrudRepository<OrderLine,Long>

interface StoresRepository : CrudRepository<Store,Long>
