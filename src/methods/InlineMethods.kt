package methods

// SOURCE : https://medium.com/@BladeCoder/exploring-kotlins-hidden-costs-part-1-fbb9935d9b62

// Let's use High Order Methods for explaining why Inline Methods are required
// and how they curb the performance bottleneck.

// Below is a High Order Method that takes two arguments:
// a)   'num', which is an Integer.
// b)   'func', which is a method synonymous to the Lambda Expression '() -> Unit' where it tells us about
//      a function with no parameter, denoted by () and no return type as well, denoted by 'Unit'.
// This high order method executes the method 'func' and then returns an Integer value.
inline fun someMethod ( num : Int, func : () -> Unit ) : Int {
	func ()
	return 2 * num
}

// This is another method that does print some text in the console. This method does not have any argument
// nor any return types.
fun doSomething () {
	println ( "Just done something" )
}

fun main ( args : Array < String > ) {
	// Kotlin is a modern language, that comes with various syntactical sugar.
	// By now, it is evident that Lambda Expression is used extensively on Kotlin for supporting Functional Programming.

	// Taking Android Development for example, the devices below Lollipop contains Java 6 or below as the compiler.
	// And, in Java 6, Lambda Expression is not supported. The obvious question would then be, if Kotlin supports
	// Lambda Expressions and Java 6 does not, then how Kotlin bytecode is transformed to support Lambda Expressions
	// that is backward compatible with Java 6 and below.

	// Answer to this is that JVM compiles Lambda Expression and Anonymous Methods as 'Functions' object in Java.

	// If you are using IntelliJ IDEA, you can see the Decompiled Version of this Kotlin File to Java equivalent
	// as below:
	// Goto 'Tools -> Kotlin -> Show Kotlin Bytecode'
	// A pane on the right would open show in the Bytecode of this file.
	// Click of 'Decompile', and the IDE will open Decompiled Kotlin File as 'InlineMethods.decompiled.java'
	// or something similar.
	// In this file, you will see the usage of 'Function' in Java. As evident, this 'Function' is the object.

	// When DEX file is created in Android Build, each lambda expression compiled as a Function will actually add
	// 3 or 4 methods to the total methods count.

	/*
	The good news is that new instances of these Function objects are only created when necessary.
	In practice, this means:
	a)  For capturing expressions, a new Function instance will be created every time a lambda is passed as argument
		then garbage-collected after execution.
	b)  For non-capturing expressions (pure functions), a singleton Function instance will be created and reused
		during the next calls.
	*/

	// Since the caller code of our example uses a non-capturing lambda,
	// it is compiled as a singleton and not an inner class.

	// So, Avoid calling standard (non-inline) higher-order functions repeatedly if they are invoking capturing lambdas
	// in order to reduce pressure on the garbage collector.

	/*
	Contrary to Java 8 which has about 43 different specialized function interfaces to avoid boxing and unboxing
	as much as possible, the Function objects compiled by Kotlin only implement fully generic interfaces,
	effectively using the Object type for any input or output value.

	This means that calling a function passed as argument in a higher-order function will actually involve
	systematic boxing and unboxing when the function involves primitive types (like Int or Long) for input values
	or the return value. This may have a non-negligible impact on performance, especially on Android.

	Be careful when writing a standard (non-inline) higher-order function involving an argument function using
	primitive types for input or output values.
	Calling this argument function repeatedly will put more pressure on the garbage collector
	through boxing and unboxing operations.
	*/

	// Above are some of the cost that incur when using High Order Methods.

	println ( someMethod ( 3, ::doSomething ) )

	// This is where Inline Methods comes to rescue.
	// If we make an High Order Method as 'inline', it will make the compiler to inline that High Order Method
	// directly inside the caller code, avoiding the call directly.
	// For higher-order functions the benefits are even greater
	// because the body of the lambda expressions passed as arguments will be inlined as well.

	/*
	The practical effects are:
	a)  No Function objects will be instantiated when the lambda is declared.
	b)  No boxing or unboxing will be applied to the lambda input and output values targeting primitive types.
	c)  No methods will be added to the total methods count.
	d)  No actual function call will be performed.
		This can improve performance for CPU-heavy code where the function is used many times.

	Inline Methods comes with a few caveats:
	a)  An inline Method can not call itself directly or through another inline function.
	b)  A public Inline Method declared in a class can only access the public functions and fields of that class.
	c)  The code will grow in size.
		Inlining a long method referenced many times can make the generated code significantly larger,
		even more if this long method is itself referencing other long inline method.
	 */
}