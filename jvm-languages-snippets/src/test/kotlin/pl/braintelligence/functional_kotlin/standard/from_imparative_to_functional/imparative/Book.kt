package pl.braintelligence.functional_kotlin.standard.from_imparative_to_functional.imparative

import java.math.BigDecimal

data class Book(val name: String, val price: BigDecimal)

open class CreditCard {
    fun performPayment(price: BigDecimal) {
        TODO("Calling bank or some Mocked response")
    }
}


class BookStore {
    fun buyBook(creditCard: CreditCard): Book {
        val book = Book("12 Rules for Life", BigDecimal("50"))
        creditCard.performPayment(book.price)
        return book
    }
}
