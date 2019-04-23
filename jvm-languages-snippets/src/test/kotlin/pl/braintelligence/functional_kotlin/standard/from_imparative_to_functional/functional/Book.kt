package pl.braintelligence.functional_kotlin.standard.from_imparative_to_functional.functional

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.math.BigDecimal
import kotlin.math.sqrt


class Payment(val bankTransfer: BankTransfer, val price: BigDecimal)
class Book(val name: String, val price: BigDecimal)

open class BankTransfer {
    fun performPayment(price: BigDecimal) {}
}


class BookStore {
    fun buyPetersonBook(bankTransfer: BankTransfer): Pair<Book, Payment> {
        val book = Book(name = "12 Rules for Life", price = BigDecimal("50"))
        val payment = Payment(bankTransfer, book.price)
        return Pair(book, payment)
    }
}

class BookTest {

    @Test
    fun `Should test buying peterson book`() {
        // given:
        val creditCard = BankTransfer()
        val bookStore = BookStore()

        // when:
        val purchase = bookStore.buyPetersonBook(creditCard)

        // then:
        assertThat(BigDecimal("50"))
                .isEqualTo(purchase.first.price)
        assertThat(creditCard)
                .isEqualTo(purchase.second.bankTransfer)
    }
}

fun divide(a: Int, b: Int) = a / b.toFloat()


fun main() {
    print(sqrt(2.0))
}
