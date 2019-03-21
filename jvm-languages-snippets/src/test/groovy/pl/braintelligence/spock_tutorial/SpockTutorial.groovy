package pl.braintelligence.spock_tutorial

import pl.braintelligence.spock_tutorial.domain.*
import spock.lang.Specification

class SpockTutorial extends Specification {

    def funSpock = "Testing with Spock is fun."
    def anotherLibraries = " I couldn't feel the same way with other testing libraries :( "

    def "Should make you love Spock!"() {
        expect:
        (funSpock + anotherLibraries).contains("Spock")
    }

    def "Lets start with something simple"() {
        given: "create a list"
        def list = new ArrayList()

        when: "add something to list"
        list.add(1)

        then: "and check that there is something inside"
        list.size() == 1
    }

    def "Specify what should be returned by stubbed method"() {
        given:
        def list = Stub(List)
        list.size() >> 15

        expect:
        list.size() == 15
    }

    def "You can also specify some side-effect"() {
        given: "after >> you have CLOSURE"
        def list = Stub(List)

        and: "just throw exception when method is invoked"
        list.size() >> { throw new IllegalStateException() }

        when:
        list.size()

        then: "exception is well handled"
        thrown(IllegalStateException)
    }

    def "Different invocations, different results"() {
        given:
        def list = Stub(List)
        list.size() >>> [3, 55, 888]

        when:
        def result = list.size()

        then:
        result == 3

        when:
        result = list.size()

        then:
        result == 55

        when:
        result = list.size()

        then:
        result == 888

    }

    def "Or just use parametrized test"() {
        given:
        def list = Stub(List)
        list.size() >>> [item]

        when:
        def result = list.size()

        then:
        result == item

        where:
        item << [3, 5, 8, 13, 21, 34, 55, 89]
    }

    def "Should throw an exception when user with given name is saved"() {
        given:
        UserRepo repo = Stub()
        repo.save({ User user -> 'Spock' == user.name } as User) >> {
            throw new IllegalArgumentException("Opppss...")
        }

        when:
        def user = new User("Spock")
        repo.save(user)

        then:
        thrown(IllegalArgumentException)

        when:
        def user2 = new User("Just a normal username")
        repo.save(user2)

        then:
        notThrown(IllegalArgumentException)
    }

    def "Exception with a message? No problem!"() {
        when:
        throw new IllegalStateException("State was...")

        then:
        def exception = thrown(IllegalStateException)
        exception.message == "State was..."
    }

    def "Mysterius _ parameter "() {
        given:
        List list = Stub()

        and: "any argument"
        list.contains(_) >> false

        and: "any String argument"
        list.add(_ as String) >> true

        and: "any non null argument"
        list.add(!null) >> true

        and: "any argument different than `obj` "
        def obj = "test"
        list.add(!obj) >> true

        and: """
              cardinality of an interaction (also you can do multiline comments, yey 
              list can be called zero times
             """
        0 * list.size()

        and: "at least one time"
        (1.._) * list.size()

        and: "no more than one time, means 1 or 0 is valid invocation"
        (_..1) * list.size()

        and: "any number of times"
        _ * list.size()

    }

    def "Lets start with Mocks!"() {
        given: "Mock are used for example to verify number of invocations"
        List list = Mock()

        when: "one invocation"
        list.size()

        then: "check (try to change it to some other number)"
        1 * list.size()
    }

    def "Should fail due to wrong User"() {
        given:
        UserRepo userRepo = Mock()
        User user = new User("Łukasz Sroczyński")

        when:
        userRepo.save(user)

        then:
        1 * userRepo.save({ User u -> u.name == "Spock" } as User)
    }

    def "SPY is not exactly a dummy object"() {
        given: "Its more like wrapper to a normal object"
        UserRepositoryKotlin userRepo = Spy(UserRepositoryKotlinImpl)

        when:
        userRepo.save(new User("qwerty"))

        then:
        1 * userRepo.save(_)
    }



}
