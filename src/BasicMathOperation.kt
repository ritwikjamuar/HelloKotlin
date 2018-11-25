fun main ( args : Array < String > ) {
	/* NOTE : In Kotlin, the result of expression between same data types will yield result with same data-type,
	 *        disregarding the approximate value
	 *        Ex - 4 / 5 = 0 (.8 is ignored)
	 *             3 + 2 = 5
	 *             22 - 7 = 15
	 *        Decimal Values will be stripped off since data types of both operand is Int
	 *
	 *        Same goes for Double and Float Data-Types.
	 *        Ex- 5.0 / 2.5 = 2.0
	 *            3.2f + 2.0f = 5.2f
	 *            7.2f * 2.0f = 14.4f
	 *
	 *        But also consider this example:
	 *        1.  5.0 / 2 = 2.5
	 *        2.  3.67f + 4 = 7.67f
	 *        3.  12.8 - 0.8f = 12.0
	 *        Data Types also follow precedence when evaluated in an expression:
	 *        Double #2
	 *        Float  #1
	 *        Int    #0
	 *        Thus, in:
	 *        1. Double / Integer = Double
	 *        2. Float + Integer = Float
	 *        3. Double - Float = Double */

	print ( "Enter 1st Number : " )
	val num1 : Int = readLine () !! .toInt ()

	print ( "Enter 2nd Number : " )
	val num2 : Int = readLine () !! .toInt ()

	val result : Int = num1 % num2
	println ( "Result : $result" )
}