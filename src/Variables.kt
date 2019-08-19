// Single Line Comment.
/*
 * Multi-line comment in Kotlin
 */

@Suppress (
		"CanBeVal",
		"RedundantExplicitType",
		"UNUSED_VARIABLE",
		"ConvertToStringTemplate",
		"SpellCheckingInspection"
) fun main (args : Array < String > ) {
	var favoriteLanguage = "Java" // To declare a variable use the built-in keyword 'var' followed by variable name.
	println ( favoriteLanguage ) // Use the variable name to print the value contained in the variable.

	// JAVA_EQUIVALENT : Object shoeSize = 10;
	var shoeSize = 10 // This way we can declare a variable with any value type
	println ( shoeSize )

	// But, if we want to declare a variable with specific data type, then one can specify the type as below.
	// JAVA_EQUIVALENT : String favoriteBike = "Yamaha YZF-R3";
	var favoriteBike : String = "Yamaha YZF-R3"
	println ( favoriteBike )

	// Below statement tells us that using the reference of variable already created, we can change it's value.
	// This also states that the variable is mutable in nature.
	favoriteLanguage = "Kotlin"
	println ( favoriteLanguage )

	// Thus, we declare the constant using the built-in keyword 'val' followed by constant name.
	val favoriteMotoGPBiker = "Valentino Rossi"
	println ( favoriteMotoGPBiker )

	// We can also declare the data-type of constant similarly fashioned with specifying data-type of variable.
	// JAVA_EQUIVALENT : final String favoriteF1Racer = "Ayrton Senna";
	val favoriteF1Racer : String = "Ayrton Senna"
	println ( favoriteF1Racer )

	// JAVA_EQUIVALENT : final double pi = 3.14159;
	val pi : Double = 3.14159
	println ( pi )

	/* We can make a variable as optional.
	 * But, what is an optional variable?
	 *
	 * In many programming languages, if a variable exhibits null value (ie. the variable is not referencing to
	 * anywhere in the physical memory) and that variable is accessed by some other variables or methods, this action
	 * causes Run Time Exception of accessing 'null' value, notably NullPointerException in Java.
	 *
	 * To overcome the nullability of any variable, Kotlin introduced Optional Variable, which tells JVM that
	 * Optional Variable can have null values and there's no need to raise an exception.*/
	var currentGirlfriend : String?
	currentGirlfriend = null
	println ( currentGirlfriend )

	/* When making a constant as optional, Kotlin provides us to initialize the value once.*/
	val totalGirlfriends : Int ?
	totalGirlfriends = 0
	println ( totalGirlfriends )

	// This is one way of concatenating multiple data-types (either constant or variable values).
	println ( "The value of Pi is " + pi )

	// This is another way of concatenating, using Templates in Kotlin.
	println ( "The value of Pi is $pi" )

	// Using 'readLine ()' method, we can get the console input from the User.
	// JAVA_EQUIVALENT : Object age = new Scanner ( System.in ).read ()
	print ( "Enter age : " )
	var age = readLine ()
	println ( "My age is $age" )

	print ( "Enter age : " )
	// var age2 : Int ? = readLine ()
	// Above statement raises an error during compilation
	// This is because 'readLine ()' returns String, but the variable is declared as Integer
	// causing mismatch in data-types of variable 'age2'.

	// var age2 : Int ? = readLine ().toInt ()
	// Also, above statement raises an error during compilation.
	// This is because this call to 'readLine ()' is not safe (ie. readLine () can return null value).
	// So this method has to be called safely, or asserting this call that it will return desired value.

	var age2 : Int ? = readLine () !! .toInt ()
	// In the above statement, we have asserted that 'readLine ()' will not be null, and thus qualifies as
	// a correct statement in Kotlin. However, this does not guarantees that the expected value will be returned
	// by the method, and thus can cause RunTimeException.
	// Try entering a character or a String or anything other than an Integer value, and the code will encounter
	// NumberFormatException.
	// So, asserting statements should be handled via Exception Handling in Kotlin.

	println ( "Age is : $age2" )

	// In order to specify a float value, we have to put 'f' after the decimal value, else the value will be considered
	// as Double.
	var rootThree : Float = 1.732f
	var rootTwo : Double = 1.41454

	println ( "Square Root of 3 is $rootThree" )
	println ( "Square Root of 2 us $rootTwo" )

	// In the below code, if one sets a variable to be optional and not initialized, then Kotlin compiler will raise
	// an error stating that the variable must be initialized before accessing it.
	var myName : String ?
	// println ( "My Name is $myName" )

	// In the below code, although our variable is optional, but it has been initialized. Thus the code will run
	// and show the value.
	var myMobile : String ? = null
	println ( "My Mobile is $myMobile" )

	// In the below code, after initializing optional value with 'null', while accessing the value, if we assert
	// using '!!', the statement will raise KotlinNullPointerException, because we are asserting that the value is
	// a valid, non-null value, but it was not, as evident by the first statement.
	// To see the effect, uncomment line 117.
	var mySalary : String ? = null
	// println ( "My Salary is " + mySalary !! )

	// We can convert the values inside the variable of a particular data-type, by using DataType's method
	// toString (), toByte (), toFloat (), etc.
	var priceOfLaptop : Int = 200000
	var priceOfLaptopInString : String = priceOfLaptop.toString ()
	println ( "Price of Laptop is $priceOfLaptopInString" )

	// But, be careful while converting String to Int, as any string that consist other than number will make the
	// code crash by raising NumberFormatException.
	// To try the exception, change the favoriteRaceNumber to anything other than numeric characters.
	var favoriteRaceNumber : String = "11"
	var favoriteBikeBrandInInt : Int = favoriteRaceNumber.toInt ()
	println ( "Favorite Race Number : $favoriteBikeBrandInInt" )

	// When Converting Integer Value to Single Precision Value, '.0' will be added as a result.
	var topSpeedOfKawasakiNinjaH2R : Int = 400
	var topSpeedOfKawasakiNinjaH2RInFloat : Float = topSpeedOfKawasakiNinjaH2R.toFloat ()
	println ( "Top Speed of Kawasaki Ninja H2R is $topSpeedOfKawasakiNinjaH2RInFloat" )

	// When converting Double Precision Value to Integer Value, the remaining value from '.' will be stripped off
	// as a result.
	var topSpeedOfKoenigseggAgeraR : Double = 467.98
	var topSpeedOfKoenigseggAgeraRInInt : Int = topSpeedOfKoenigseggAgeraR.toInt()
	println ( "Top Speed of Koenigsegg Agera R is $topSpeedOfKoenigseggAgeraRInInt" )
 }