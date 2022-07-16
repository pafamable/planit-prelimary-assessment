package challenge5

import java.util.*


// model for the Person class
class Person(val name: String,
                  val yearOfBirth: Int,
                  val nationality: String,
             val age: Int = Calendar.getInstance().get(Calendar.YEAR) - yearOfBirth) {

    // equals() and hashcode() is used when comparing between two Person objects

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Person

        if (name != other.name) return false
        if (yearOfBirth != other.yearOfBirth) return false
        if (nationality != other.nationality) return false
        if (age != other.age) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + yearOfBirth
        result = 31 * result + nationality.hashCode()
        result = 31 * result + age
        return result
    }

    override fun toString(): String {
        return "$name $yearOfBirth $nationality $age"
    }
}