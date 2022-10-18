package pt.unl.fct.di.lab4.data

import javax.persistence.*

@Entity
data class Product (
    @Id @GeneratedValue                val code:Long,
                                       val description:String,
    @ManyToMany(mappedBy = "products") val stores:MutableSet<Store>
) {
    override fun hashCode(): Int = code.toInt()
}

@Entity
data class Store (
    @Id @GeneratedValue val id:Long,
                        val name:String,
    @ManyToMany         val products:MutableSet<Product>
) {
    override fun hashCode(): Int = id.toInt()

    override fun toString(): String ="Store(id=${id}, name=${name})"
}


@Entity
data class Client (
    @Id @GeneratedValue             val number:Long,
                                    val name:String,
    @OneToMany(mappedBy = "client") val orders:MutableList<Order>
)


@Entity
data class OrderLine (
    @Id @GeneratedValue val id:Long,
    @ManyToOne          val product:Product,
    @ManyToOne          val order:Order,
                        val quantity:Long,
                        val unitprice:Long,
)

@Entity
@Table(name="OrderTable") // Cannot use Order as table name
data class Order (
    @Id @GeneratedValue              val number:Long,
    @OneToMany(mappedBy = "order")   val lines:MutableList<OrderLine>,
    @ManyToOne                       val client:Client
)
