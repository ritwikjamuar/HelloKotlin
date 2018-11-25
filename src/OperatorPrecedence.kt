fun main ( args : Array < String > ) {
	/* In Kotlin, the order precedence is as below (in decreasing order):
	 * ()     #3
	 * ^      #2
	 * * /    #1
	 * + -    #0
	 *
	 * NOTE : The associativity of Order is Left to Right.
	 *        Meaning, for operations with same level of operation, the first operation found from left is going to be
	 *        evaluated. */

	val expression1 : Double = 2 * 3 + 4 / 7 * Math.pow ( 2.0, 3.0 ) - ( 3 - 1 )
	println ( expression1 )

	/* Result Explanation:
	 *    2 * 3 + 4 / 7 * 2 ^ 3 - ( 3 - 1 ) ## Precedence #3 -----------------------------------------------------------
	 *                            --------- <= Brackets holds the highest precedence, so the expression under bracket
	 *                                         will be evaluated first.
	 * => 2 * 3 + 4 / 7 * 2 ^ 3 - 2         ## Precedence #2 -----------------------------------------------------------
	 *                    -----             <= Power holds the highest precedence, so this will be evaluated.
	 * => 2 * 3 + 4 / 7 * 8 - 2             ## Precedence #1 -----------------------------------------------------------
	 *    -----                             <= Multiplication and Division both holds the same precedence, but since
	 *                                         the associativity is from left to right, and multiplication being the
	 *                                         first expression before division in same precedence level, so,
	 *                                         multiplication expression will be evaluated/
	 * => 6 + 4 / 7 * 8 - 2                 ## Precedence #1 -----------------------------------------------------------
	 *        -----                         <= Here, division is found before multiplication expression, and following
	 *                                         left-to-right associativity, division will be evaluated.
	 * => 6 + 0 * 8 - 2                     ## Precedence #1 -----------------------------------------------------------
	 *        -----                         <= Here, multiplication is the last operation in the same precedence level,
	 *                                         so, it'll be evaluated.
	 * => 6 + 0 - 2                         ## Precedence #0 -----------------------------------------------------------
	 *    -----                             <= According to left-to-right associativity, we have found addition first
	 *                                         before subtraction, so addition will be evaluated.
	 * => 6 - 2                             ## Precedence #0 -----------------------------------------------------------
	 * => 4                                 <= ANSWER */

	val expression2 : Double = 4 + 3 - 2 / Math.pow ( 1.0, 6.0 ) * ( 5 * 3 + 2 )
	println ( expression2 )

	/* Result Explanation:
	 *    4 + 3 - 2 / 1 ^ 6 * ( 5 * 3 + 2 ) ## Precedence #3 -----------------------------------------------------------
	 *                        ------------- <= Brackets holds the highest precedence, but inside the bracket, there are
	 *                          -----          2 operators (can be more in some cases), so, we have to precedent the
	 *                                         operation inside the bracket, with multiplication expression holding the
	 *                                         highest precedence, so multiplication inside bracket will be evaluated.
	 * => 4 + 3 - 2 / 1 ^ 6 * ( 15 + 2 )    ## Precedence #3 -----------------------------------------------------------
	 *                        ----------    <= With only one expression inside the bracket, which is addition, so it
	 *                                         will be evaluated.
	 * => 4 + 3 - 2 / 1 ^ 6 * 17            ## Precedence #2 -----------------------------------------------------------
	 *                -----                 <= Power expression holds the highest precedence, so it will be evaluated.
	 * => 4 + 3 - 2 / 1 * 17                ## Precedence #1 -----------------------------------------------------------
	 *            -----                     <= Division and Multiplication expressions have the highest precedence, but
	 *                                         by following left-to-right associativity, Division expression will be
	 *                                         evaluated first.
	 * => 4 + 3 - 2 * 17                    ## Precedence #1 -----------------------------------------------------------
	 *            ------                    <= Multiplication is the only expression left in this precedence level, so
	 *                                         it will be evaluated.
	 * => 4 + 3 - 34                        ## Precedence #0 -----------------------------------------------------------
	 *    -----                             <= According to left-to-right associativity, we have found addition first
	 *                                         before subtraction, so addition will be evaluated.
	 * => 7 - 34                            ## Precedence #0 -----------------------------------------------------------
	 * => -27                               <= ANSWER */
}