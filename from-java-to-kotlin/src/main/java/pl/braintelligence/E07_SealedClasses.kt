package pl.braintelligence

sealed class Expr {
}
data class Const(val number: Double) : Expr()
object NotANumber : Expr()
data class Sum(val e1: Expr, val e2: Expr) : Expr()


fun eval(expr: Expr): Double = when (expr) {
    is Const -> TODO()
    NotANumber -> TODO()
    is Sum -> TODO()
}

fun main() {

}
