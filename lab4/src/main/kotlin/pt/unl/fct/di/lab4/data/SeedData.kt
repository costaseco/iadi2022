package pt.unl.fct.di.lab4.data

import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import javax.transaction.Transactional

@Component
class SeedData(
    val products:ProductRepository,
    val orders:OrderRepository,
    val lines:LinesRepository,
    val clients:ClientRepository,
    val stores:StoresRepository
) : CommandLineRunner {

    fun addClients() {
        clients.saveAll(listOf(
            Client(0,"Client 1", mutableListOf()),
            Client(0,"Client 2", mutableListOf()),
        ))
    }

    fun addProductsAndStores() {
        val p1 = Product(0,"Product 1", mutableSetOf())
        val p2 = Product(0,"Product 2", mutableSetOf())
        products.saveAll(listOf(p1,p2))

        val s1 = Store(0, "Store 1", mutableSetOf())
        val s2 = Store(0, "Store 2", mutableSetOf())
        stores.saveAll(listOf(s1,s2))

        s1.products.add(p1)
        s1.products.add(p2)
        s2.products.add(p1)
        s2.products.add(p2)

        p1.stores.add(s1)
        p1.stores.add(s2)
        p2.stores.add(s1)
        p2.stores.add(s2)
    }

    fun addOrders() {
        val c1 = clients.findByName("Client 1").get()
        val c2 = clients.findByName("Client 2").get()

        val p1 = products.findByDescription("Product 1").get()
        val p2 = products.findByDescription("Product 2").get()

        val o1 = Order(0, mutableListOf(), c1)
        val o2 = Order(0, mutableListOf(), c2)
        orders.saveAll(listOf(o1, o2))

        val l1 = OrderLine(0, p1, o1, 1, 20)
        val l2 = OrderLine(0, p2, o1, 2, 10)
        val l3 = OrderLine(0, p1, o2, 2, 20)
        val l4 = OrderLine(0, p2, o2, 1, 10)

        o1.lines.add(l1)
        o1.lines.add(l2)
        o2.lines.add(l3)
        o2.lines.add(l4)

        lines.saveAll(listOf(l1,l2,l3,l4))
    }

    @Transactional
    override fun run(vararg args: String?) {
        addClients()
        addProductsAndStores()
        addOrders()

        clients.findAll().forEach {
            println(it.name)
        }

        products.findAll().forEach {
            println("Product(${it.code}, ${it.description}, stores = ${it.stores.count()})")
        }

        println("===Products===")
        stores.findAll().forEach {
            println("Store(${it.name}, products = ${it.products.count()})")
            it.products.forEach { println(it.description) }
        }

        println("===Orders===")
        orders.findAll().forEach {
            println("Order(${it.number}, ${it.client.name}, lines = ${it.lines.count()})")
            println("Stores = ${orders.findStores(it.number)}")

            println("Product available at")
            orders.findProductPairs(it.number).forEach {
                println("${it.p.code} - ${it.p.description}: ${it.s}")
            }

            println("Lines with fetch ${it.number}")
            orders.findByIdWithLines(it.number).forEach {
                println("Order ${it.number}")
                it.lines.forEach {
                    println("Product ${it.product.description}")
                }
            }
        }
    }
}
