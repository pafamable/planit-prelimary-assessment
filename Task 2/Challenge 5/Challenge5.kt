package challenge5

fun main() {

    val person1 = Person("Patrick", 1994, "Philippines")
    val person1Same = Person("Patrick", 1994, "Philippines")
    val person2 = Person("Nicole", 1995, "Philippines")
    val person2Same = Person("Nicole", 1995, "Philippines")

    val person3 = Person("Michael Scott", 1965, "USA")
    val person4 = Person("Jim Halpert", 1978, "USA")
    val person5 = Person("Pam Beesly", 1979, "USA")
    val person6 = Person("Dwight Schrute", 1970, "USA")

    val person7 = Person("David Brent", 1962, "UK")
    val person8 = Person("Tim Canterbury", 1978, "UK")
    val person9 = Person("Dawn Tinsley", 1982, "UK")
    val person10 = Person("Gareth Keenan", 1971, "UK")

    var personList = listOf(person1, person1Same, person2, person2Same, person3,
                            person4, person5, person6, person7, person8, person9, person10)

    println("Original List of People:")
    printPeopleList(personList)

    val duplicates = returnDuplicates(personList)
    println("\nPeople with Duplicates:")
    printPeopleList(duplicates)

    personList = removeDuplicates(personList)
    println("\nRemoving duplicates...")
    printPeopleList(personList)

    println("\nThe average age is ${String.format("%.2f", returnAverageAge(personList))}")

    val ageLimit = 50
    val peopleUnderTheAgeOf = returnPeopleUnderAgeOf(personList, ageLimit)
    println("\nPeople with ages less than $ageLimit:")
    printPeopleList(peopleUnderTheAgeOf)

    val countryList = returnAllCountries(personList)
    println("\nList of all countries:")
    printCountries(countryList)
}

fun printPeopleList(personList: List<Person>) {
    personList.forEach{ person ->
        println(person)
    }
}

fun removeDuplicates(personList: List<Person>): List<Person> {
    return personList.distinct().toList()
}

fun returnDuplicates(personList: List<Person>): List<Person> {
    val duplicatesMap = personList.groupingBy { it }.eachCount().filter { it.value > 1 }
    return  duplicatesMap.keys.toList()
}

fun returnAverageAge(personList: List<Person>): Double {
    val ageList = personList.mapTo(arrayListOf()) { it.age }

    return ageList.average()
}

fun returnPeopleUnderAgeOf(personList: List<Person>, age: Int): List<Person> {
    return personList.filter { it.age < age }
}

fun returnAllCountries(personList: List<Person>): List<String> {
    val countryMap = mutableMapOf<String, Int>()

    personList.forEach { person ->
        countryMap[person.nationality] = countryMap.getOrDefault(person.nationality,0) + 1
    }

    return countryMap.keys.toList()
}

fun printCountries(countryList: List<String>) {
    countryList.forEach{ country ->
        println(country)
    }
}
