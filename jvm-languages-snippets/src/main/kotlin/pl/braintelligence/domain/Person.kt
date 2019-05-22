package pl.braintelligence.domain

data class Person(
        val firstname: String,
        val lastname: String
) {
    companion object {
        val WALTER_WHITE = Person("Walter", "White")
        val JON_SNOW = Person("Jon", "Snow")
        val JESSE_PINKMAN = Person("Jesse", "Pinkman")
        val FRANSIS_UNDERWOOD = Person("Francis", "Underwood")
        val WHITE_WALKER = Person("White", "Walker")
        val JOHN_DOE = Person("John", "Doe")
    }
}

