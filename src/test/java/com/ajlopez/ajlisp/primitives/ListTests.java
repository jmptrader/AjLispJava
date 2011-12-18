package com.ajlopez.ajlisp.primitives;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import com.ajlopez.ajlisp.Environment;
import com.ajlopez.ajlisp.List;
import com.ajlopez.ajlisp.Machine;
import com.ajlopez.ajlisp.parser.LexerException;
import com.ajlopez.ajlisp.parser.ParseException;
import com.ajlopez.ajlisp.parser.Parser;

public class ListTests {

	@Test
	public void simpleEvaluate() throws IOException, ParseException, LexerException {
		Environment environment = new Environment();
		List body = (List)(new Parser("(1 2 3)")).parseExpression();
		com.ajlopez.ajlisp.primitives.List prim = com.ajlopez.ajlisp.primitives.List.getInstance();
		Object result = prim.evaluate(environment, body);
		
		assertEquals("(1 2 3)", Machine.printString(result));
	}
}