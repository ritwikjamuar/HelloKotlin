package methods

import kotlin.math.absoluteValue
import kotlin.math.pow

/**Lambda Expressions:
 * It is an anonymous function.
 * We can treat it as a value.
 *
 * What can we do with it?
 * -> Pass it as an arguments to the methods, return them, or do any other thing we could do with a normal object.
 *
 * General Syntax:
 * val lambdaName : Type = { argumentList -> codeBody }
 *
 * Note that codeBody is not optional. It has to be a non-null value.*/

// Below is a Lambda Expression that does nothing, i.e. takes the number as argument and returns the same number.
val none = { number : Int -> number }

// Below is a Lambda Expression that returns the absolute value of the number given as the argument.
val absolute = { number : Int -> number.absoluteValue }

// Below is a Multi-Lined Lambda Expression that takes a number as an argument, multiplies it by 100 and then converts
// the multiplied value to string.
// In essence, Kotlin compiler will understand this something like: (Int) -> (String).
val magnitude = {
	number : Int ->
	val mag = number * 100
	mag.toString ()
}

// Since, Kotlin compiler occasionally doesn't understand what are the types involved in Lambda Conversion, it's better
// to specify the data types the Lambda Expression will be dealing with.
// Below is the Data Type Specified Lambda Expressions.
val square : ( Int ) -> Long = { value -> ( value * value ).toLong () }
val cube : ( Long ) -> Long = { value -> value.toDouble ().pow ( 3.toDouble () ).toLong () }
val squareRoot : ( Int ) -> Double = { value -> value.toDouble ().pow ( 0.5 ) }

// If we don't want our Lambda Expression to return anything, we can use the type 'Unit'.
// Below is the use-case example of 'Unit' in Lambda Expression.
val printer : ( Int ) -> Unit = { value -> println ( value ) }

// Lambda Expression can also be used as a Class Extension.
// The pattern we use here is slightly different to the other lambdas we have defined.
// Our brackets still contain our arguments but before our brackets,
// we have the type that we’re going to attach this lambda to.
fun extendString ( arg : String, num : Int ) : String {
	val another : String.( Int ) -> String = { "$this $it" }

	return arg.another ( num )
}

// In the Lambda Expression, the final value is one that is the last statement in the expression declaration.
// In the below expression, String values 'Fail', 'Pass', 'Distinction' and Boolean value 'false' appears to be the last
// statement of this anonymous method.
val calculateGrade = {
	grade : Int ->
	when ( grade ) {
		in 0..40 -> "Fail"
		in 41..70 -> "Pass"
		in 71..100 -> "Distinction"
		else -> false
	}
}

// The above expression is equivalent to the below implementation in the form of method:
/*val calculateGrade = fun ( grade: Int ): String {
	if ( grade < 0 || grade > 100 ) {
		return "Error"
	} else if ( grade < 40 ) {
		return "Fail"
	} else if ( grade < 70 ) {
		return "Pass"
	}

	return "Distinction"
}*/

// Declared an array of Integers for demonstration purpose starting from line 101.
val array = arrayOf ( 1, 2, 3, 4, 5 )

// We can pass Lambda Declarations as an argument to the method.
// In this method, the argument is a Lambda Expression, and we have specified the type of Lambda Expression.
// If we pass any other Lambda Expression that does not conform to the expression we have specified
// in the method argument, then the Kotlin Compiler will throw an error, stating the mismatch in argument.
// This method is called in the line 126.
fun getSquareFour ( lambda : ( Int ) -> Long ) : Long {
	return lambda ( 4 )
}

fun main ( args : Array < String > ) {
	val noneThree = none ( 3 )
	val absoluteThree = absolute ( -3 )
	val magnitudeThree = magnitude ( 3 )
	val squareThree = square ( 3 )
	val cubeThree = cube ( 3 )
	val rootThree = squareRoot ( 3 )

	println ( noneThree )
	println ( absoluteThree )
	println ( magnitudeThree )
	println ( squareThree )
	println ( cubeThree )
	println ( rootThree )
	printer ( 3 )
	println ( extendString ( "Hello", 3 ) )
	println ( calculateGrade ( 60 ) )

	// A shorthand of a single argument lambda is to use the keyword ‘it’.
	// This value represents any lone that argument we pass to the lambda function.

	// We will fetch all the items of the 'array' defined in line 81, and multiply the item by 4.

	// Below is the Longhand Lambda Expression.
	// In this, we define what an item is and perform operation on the basis of 'item'.
	array.forEach { item -> println ( item * 4 ) }

	// Kotlin provides 'it' keyword, which facilitates the Shorthand Lambda Expression.
	// In this, it represent the each item of the 'array'.
	array.forEach { println ( it * 4 ) }

	// Calling the Method with Lambda Expression as an argument.
	// Note that the Lambda Expression 'square' is also an Lambda Object.
	// This way we can pass Objects as Lambda Expression.
	println ( getSquareFour ( square ) )
}