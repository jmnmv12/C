// Generated from hello.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link helloParser}.
 */
public interface helloListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link helloParser#top}.
	 * @param ctx the parse tree
	 */
	void enterTop(helloParser.TopContext ctx);
	/**
	 * Exit a parse tree produced by {@link helloParser#top}.
	 * @param ctx the parse tree
	 */
	void exitTop(helloParser.TopContext ctx);
	/**
	 * Enter a parse tree produced by {@link helloParser#greetings}.
	 * @param ctx the parse tree
	 */
	void enterGreetings(helloParser.GreetingsContext ctx);
	/**
	 * Exit a parse tree produced by {@link helloParser#greetings}.
	 * @param ctx the parse tree
	 */
	void exitGreetings(helloParser.GreetingsContext ctx);
	/**
	 * Enter a parse tree produced by {@link helloParser#bye}.
	 * @param ctx the parse tree
	 */
	void enterBye(helloParser.ByeContext ctx);
	/**
	 * Exit a parse tree produced by {@link helloParser#bye}.
	 * @param ctx the parse tree
	 */
	void exitBye(helloParser.ByeContext ctx);
	/**
	 * Enter a parse tree produced by {@link helloParser#names}.
	 * @param ctx the parse tree
	 */
	void enterNames(helloParser.NamesContext ctx);
	/**
	 * Exit a parse tree produced by {@link helloParser#names}.
	 * @param ctx the parse tree
	 */
	void exitNames(helloParser.NamesContext ctx);
}