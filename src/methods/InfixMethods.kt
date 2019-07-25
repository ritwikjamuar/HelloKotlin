package methods

fun main ( args : Array < String > ) {
	// Infix Method:
	// A kind of functional approach to function, where it accepts only one parameter and does it's implementation, and
	// return its result.

	// Some properties of it :
	// 1. It must be a member function of a class or Extensive Functions.
	// 2. It must have only one parameter.
	// 3. The parameter must not accept variable number of arguments and must have no default value.

	// So, there are two ways to declare an 'infix' method.

	// 1. Using member function of a class :
	// Checkout line 135, there's a class named 'Methods.Person' with an infix method.
	// In below lines, two objects of 'Methods.Person' are created.
	val sophia = Person("Sophia")
	val claudia = Person("Claudia")

	// Uncomment the line 25, 26, 27 and 28 to see for yourself how your IDE or Kotlin compiler reacts to compilation.
	// likes sophia claudia
	// sophia claudia likes
	// sophia likes
	// claudia likes

	// Above line is erroneous because above declaration does not confer to Infix Notation.

	// An Infix Notation is represented like below :
	//             ( Operand ) ( Operator ) ( Operand )
	// Ex -             2            +           3
	// Ex -             3            %           2

	// As you can see for lines 25-28, None of any statements confer to Infix Notation.
	// How you ask?
	// Consider 'sophia' and 'claudia' as your operands.
	// Consider 'likes' as your operator.
	// Then :
	//             ( Operand ) ( Operator ) ( Operand )
	//                likes       sophia      claudia    => WRONG
	//                sophia      claudia      likes     => WRONG
	//                sophia       likes                 => WRONG
	//                claudia      likes                 => WRONG

	// So, how to correctly use the infix method? => By conforming to Infix Notation.
	// Key point to remember is to use your infix method as an operator of some kind.

	// Using one of the reference of the object, we used the infix method 'likes'.
	sophia likes claudia

	// Using the reference objects to use method 'showLikes ()'.
	sophia.showLikes ()
	claudia.showLikes ()

	// 2. Using an Extensive Method :

	// Adding the implementation 'dislike' where it's implementation is to remove the person
	// from the list of 'likedPerson'.
	// In the below line, an Extensive Method 'dislike' is declared and written down it's implementation.
	infix fun Person.disLike (person : Person) {
		val likedPeople : MutableList <Person> = this.getLikedPeople ()

		// If there are no liked persons for the current person, then show user there's no one to like.
		if ( likedPeople.size == 0 ) {
			println ( "No one to unlike" )
		} else {
			// Store name of person to be un-liked.
			var foundPersonName : String ? = null
			// Position for the person to be un-liked in the list of likedPeople of current user.
			var foundPersonIndex : Int = -1

			// Iterate over all the liked person to find the person in request.
			var index : Int = -1
			for ( p in likedPeople ) {
				index++
				if ( p.getName () == person.getName () ) {
					foundPersonIndex = index
					foundPersonName = p.getName ()
					break
				}
			}

			// If the person hasn't been found, then show message to user that the request person has not been found.
			if ( foundPersonIndex == -1 ) {
				println ( "${person.getName()} not found in ${this.getName()}'s Liked Persons." )
			} else {
				// Else, show that Methods.Person has been removed from current person's 'likedPerson'.
				likedPeople.removeAt ( likedPeople.size - 1 )
				println ( "${this.getName()} un-liked $foundPersonName" )
			}
		}
		println ()
	}

	// Use the operator 'dislike' in Infix Notation.
	sophia disLike claudia
	claudia disLike sophia

	// Some more examples of using Infix Method as Extension Method.
	infix fun Int.times ( str : String ) = str.repeat ( this )
	println ( 2 times "Hello" )
	println ()

	infix fun String.onto ( other: String ) = Pair ( this, other )
	val myPair = "McLaren" onto "Lucas"
	println ( myPair )
	println ()

	// Using built-in Infix Method 'to' to join any two objects.
	val pair = "Ferrari" to "Lamborghini"
	println ( pair )
	println ()

	// In terms of precedence, Infix function calls have lower precedence than :
	// * Arithmetic Operators
	// * Type Casts
	// * 'rangeTo' Operator.

	// The following expressions are equivalent :
	// a) 1 shl 2 + 3 and 1 shl ( 2 + 3 )
	// b) 0 until n * 2 and 0 until (n * 2)
	// c) xs union ys as Set<*> and xs union (ys as Set<*>)

	// On the other hand, infix function call's precedence is higher than that of :
	// * Boolean operators && and ||
	// * is- and in-checks
	// * and some other operators.

	// These expressions are equivalent as well:
	// a) a && b xor c and a && ( b xor c )
	// b) a xor b in c and ( a xor b ) in c
}

/** Class to store information about a person. */
class Person ( private val name : String ) {
	// Mutable List to store other 'Methods.Person'.
	private val likedPeople = mutableListOf <Person> ()

	/** Infix Method to add other 'Methods.Person's to the list 'likedPeople'. */
	infix fun likes ( other : Person) {
		likedPeople.add ( other )
	}

	/** Method to show likes of a person. */
	fun showLikes () {
		if ( likedPeople.size == 0 ) {
			println ( "No Likes from $name" )
		} else {
			println ( "$name's Likes :" )
			for ( people in likedPeople ) {
				println ( people.name )
			}
		}
		println ()
	}

	/** Method to get reference of 'likedPeople'. */
	fun getLikedPeople () : MutableList <Person> {
		return likedPeople
	}

	/** Method to get reference of 'name'. */
	fun getName () : String {
		return name
	}
}