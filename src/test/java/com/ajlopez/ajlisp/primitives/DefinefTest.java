package com.ajlopez.ajlisp.primitives;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import com.ajlopez.ajlisp.Environment;
import com.ajlopez.ajlisp.List;
import com.ajlopez.ajlisp.Machine;
import com.ajlopez.ajlisp.forms.FClosure;
import com.ajlopez.ajlisp.parser.LexerException;
import com.ajlopez.ajlisp.parser.ParseException;
import com.ajlopez.ajlisp.parser.Parser;

public class DefinefTest {

	@Test
	public void defineSpecialForm() throws IOException, ParseException, LexerException {
		Environment environment = new Environment();
		environment.setValue("definef", Definef.getInstance());
		environment.setValue("cons", Cons.getInstance());
		environment.setValue("quote", Quote.getInstance());
		
		List list = (List)(new Parser("(definef mycons (a b) (cons a b))")).parseExpression();
		Object result = list.evaluate(environment);

		assertTrue(result instanceof FClosure);
		
		FClosure closure = (FClosure)result;
		
		List arguments = (List)(new Parser("(a (b c)))")).parseExpression();
		result = closure.evaluate(environment, arguments);
		
		assertEquals("(a b c)", Machine.printString(result));
	}

}
