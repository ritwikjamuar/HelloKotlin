fun main ( args : Array < String > ) {
	println ( addTwoNumbers ( 3, 2 ) )
	dummy ()
	println ( minMaxFloat() + minMaxDouble () + minMaxLong () + minMaxShort () )
	doubleAdd ()
	characterTest()
	explicitConversion ()
	valVsVar ()
	stringSubString ()
	containsInArray ()
	arrayDynamics ()
	nullability ()
}

fun dummy () {
	val name = "Ritwik"
	val age = 25
	val bigInt = Int.MAX_VALUE
	val smallInt = Int.MIN_VALUE
	println ( "Name : $name\nAge : $age\nBigInt : $bigInt\nSmallInt : $smallInt" )
}

fun addTwoNumbers ( a : Int, b : Int ) : Int {
	return a + b
}

fun minMaxFloat () : String {
	val floatMin : Float = Float.MIN_VALUE
	val floatMax : Float = Float.MAX_VALUE
	return "FloatMin : $floatMin\nFloatMax : $floatMax\n"
}

fun minMaxDouble () : String {
	val doubleMin : Double = Double.MIN_VALUE
	val doubleMax : Double = Double.MAX_VALUE
	return "DoubleMin : $doubleMin\nDoubleMax : $doubleMax\n"
}

fun minMaxLong () : String {
	val longMax : Long = Long.MAX_VALUE
	val longMin : Long = Long.MIN_VALUE
	return "LongMin : $longMax\nLongMin : $longMin\n"
}

fun minMaxShort () : String {
	val shortMin : Short = Short.MIN_VALUE
	val shortMax : Short = Short.MAX_VALUE
	return "ShortMin : $shortMin\nShortMax : $shortMax\n"
}

fun doubleAdd () {
	val doubleA = 1.23456789
	val doubleB = 9.87654321
	println ( "Double Sum : ${doubleA+doubleB}\n" )
}

fun characterTest () {
	val charA = 'R'
	@Suppress ( "USELESS_IS_CHECK" ) println ( "A is character : ${charA is Char}\n" )
}

fun explicitConversion () {
	println ( "3.14 to Int ${3.14.toInt ()}" )
	println ( "A to Int ${'A'.toInt ()}" )
	println ( "97 to Char ${97.toChar ()}" )
}

fun valVsVar () {
	var fName = "Aero"
	var lName = "Smith"

	lName = "Dynamics"
	println ( fName + lName )

	// Implicit Comparision
	println ( "\n${fName.equals ( lName )}" )

	// Explicit Comparision
	println ( "\n${"A".equals ( lName )}" )
	println ( fName.equals ( "Aero" ) )
}

fun stringSubString () {
	var str = "Hello String"
	str = str.substring ( 2, 4 )
	println ( "\n$str" )
	println ( "${str.contains ( "Hello" )}" )
}

fun containsInArray () {
	var myArray = arrayOf ( 1, "Kotlin", 3.14 )
	if ( myArray.contains ( "Kotlin" ) ) {
		print ( "myArray is Dynamic\n" )
		print ( "$myArray\n\n" )
	}
}

fun arrayDynamics () {
}

fun nullability () {
	var blueColor = null
	println ( blueColor )

	var rainbowColor : String? = null
	println ( rainbowColor )

	/*Below statements is invalid because we can't assign null value to a non-null data type.*/
	// val str : String = null
	// println ( str )

	val amount : Double? = 10.11
	println ( amount )

	var listStr : List < String ? > ? = listOf ( null, null )
	var listStr2 : List < String > ? = null
	println ( "$listStr\n$listStr2" )
	println ( "size ( listStr ) : ${listStr?.size}\nsize ( listStr2 ) : ${listStr2?.size}" )
	listStr = null

	// Null Checks
	var nullTest : Int ? = null
	if ( nullTest == null ) {
		print ( "\n$nullTest" )
		// return 0
	} else {
		nullTest += 1
	}
}