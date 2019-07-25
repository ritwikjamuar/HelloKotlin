import kotlin.math.pow

fun main (args : Array < String > ) {
	println ( "Select Shape:\n1. Circle\n2. Square\n3. Rectangle\n4. Triangle" )
	var result : Any ? = null
	val choice = readLine () !! .toInt ()
	val startTime : Long ?
	val elapsedTime : Long ?
	when ( choice )  {
		1 -> {
			print ( "Enter Radius of Circle: " )
			val radius : Int = readLine () !! .toInt ()
			startTime = System.currentTimeMillis ()
			result = circle ( radius )
			elapsedTime = System.currentTimeMillis () - startTime
		}

		2 -> {
			print ( "Enter Side of Square : " )
			val side : Int = readLine () !!.toInt ()
			startTime = System.currentTimeMillis ()
			result = square ( side )
			elapsedTime = System.currentTimeMillis () - startTime
		}

		3 -> {
			print ( "Enter Length of Rectangle : " )
			val length : Int = readLine () !!.toInt ()
			print ( "Enter Breadth of Rectangle : " )
			val breadth : Int = readLine () !!.toInt ()
			startTime = System.currentTimeMillis ()
			result = rectangle ( length, breadth )
			elapsedTime = System.currentTimeMillis () - startTime
		}

		4 -> {
			print ( "Enter Base of Triangle : " )
			val breadth : Int = readLine () !!.toInt ()
			print ( "Enter Height of Triangle : " )
			val height : Int = readLine () !!.toInt ()
			startTime = System.currentTimeMillis ()
			result = triangle ( breadth, height )
			elapsedTime = System.currentTimeMillis () - startTime
		}

		else -> {
			startTime = System.currentTimeMillis ()
			println ( "Wrong Choice Entered" )
			elapsedTime = System.currentTimeMillis () - startTime
		}
	}

	if ( result != null ) println ( "Area : $result" )
	print ( "Time Taken : $elapsedTime ms" )
}

fun circle ( radius : Int ) : Double {
	return 3.14159 * radius.toDouble ().pow ( 2.0 )
}

fun square ( side : Int ) : Int {
	return side.toDouble ().pow ( 2.0 ).toInt ()
}

fun rectangle ( length : Int, breadth : Int ) : Int {
	return length * breadth
}

fun triangle ( base : Int, height : Int ) : Double {
	return 0.5 * base * height
}