package pl.braintelligence.katas

import java.util.stream.IntStream
import java.util.stream.Stream

class Kotlin_5_Primes {

    fun computeImperativeStyle(n: Int, k: Int): Int {
        var result: Double = 0.0;
        var index: Int = n;
        var count = 0;

        while (count < k) {
            if (PrimeFinder.isPrime(index)) {
                result += Math.sqrt(index.toDouble())
                count++
            }
            index++
        }
        return result.toInt()
    }

    fun computeFunctionalStyle(n: Int, k: Int): Int = Stream.iterate(n, { it + 1 })
            .filter { PrimeFinder.isPrime(it) }
            .mapToDouble { Math.sqrt(it.toDouble()) }
            .limit(k.toLong())
            .sum().toInt()

}

class PrimeFinder {
    companion object {

        @JvmStatic
        fun isPrime(number: Int): Boolean {
            return number > 1 &&
                    IntStream.range(2, number)
                            .noneMatch { number % it == 0 }
        }
    }
}
