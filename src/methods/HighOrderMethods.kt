package methods

/**
 * High Order Methods:
 * It is a type of method that can accept another method as an argument, or return a method or both.
 * Most of the time, Lambda Expressions are the arguments or return types of this type of method.
 *
 * NOTE :   To pass a method as an argument of High Order Method, use the symbol '::' before the method name.
 *          What '::' actually tells us is the reference of the function.
 *          Since, in Kotlin, methods are treated as an Object of its own,
 *          thus it is the reason we can pass a method as an argument,
 *          or return a method from another method, or both, as opposed to Java.
 *          This can be seen as an evidence if you get the bytecode of your Kotlin File.
 *          If you are using IntelliJ IDEA, Goto menu "Tools -> Kotlin -> Show Kotlin Bytecode".
 **/

// In the below High Order Method, we are passing two things:
// a) A String 'str'
// b) A Lambda Expression 'func' that is synonymous to the method 'printer'
// 'str' is then provided as the argument of 'func' which is basically reference of 'printer'.
fun highOrderMethod1 ( str : String, func : ( String ) -> Unit ) {
	print ( "To be or not to be " )
	func ( str )
}

// This method prints a given string as an argument in console.
fun printer ( str : String ) {
	println ( str )
}

// In the below High Order Method, we have specified the return type as a Lambda Expression.
// The specified Lambda Expression is synonymous to the method 'multiplier'.
// At the end, we are returning the method 'multiplier' using '::' reference.
fun highOrderMethod2 () : ( (Int, Int ) -> Long ) {
	return ::multiplier
}

// This method multiplies two Int and returns the result as a Long value
fun multiplier ( num1 : Int, num2 : Int ) : Long {
	return ( num1 * num2 ).toLong ()
}

// In the below High Order Method, we have specified the argument as a method in the form of Lambda Expression.
// This Lambda Expression is telling that any method synonymous to this expression will not have any argument,
// neither it will return anything as specified by 'Unit'.
fun highOrderMethod3 ( abc : () -> Unit ) {
	abc ()
}

// This is one method that does not have any parameter nor any returning statement.
fun nothing () {
	println ( "This does nothing" )
}

fun main ( args : Array < String > ) {
	// In the below statement, we are calling the method 'highOrderMethod1' with two arguments.
	// a) 'An Idiot', which is a String.
	// b) 'printer', which is a method.
	highOrderMethod1 ( "An Idiot", ::printer )

	// In the below statement, we are storing the returned method in the value 'mul'.
	// Using mul as a reference to the returned method, we can then call the method with defined arguments types.
	val mul = highOrderMethod2 ()
	println ( mul ( 3, 4 ) )

	// This is the referential way of passing a method.
	highOrderMethod3 ( ::nothing )

	// This is another way to pass the method, i.e. by defining the method in the argument.
	highOrderMethod3 {
		val name = "Lambda"
		println ( name )
	}
}