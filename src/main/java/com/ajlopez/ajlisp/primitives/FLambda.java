package com.ajlopez.ajlisp.primitives;

import com.ajlopez.ajlisp.Environment;
import com.ajlopez.ajlisp.IForm;
import com.ajlopez.ajlisp.List;
import com.ajlopez.ajlisp.forms.Bind;
import com.ajlopez.ajlisp.forms.FClosure;

public class FLambda implements IForm {
	private static FLambda instance = new FLambda();
	
	private FLambda() {		
	}
	
	public static FLambda getInstance() {
		return instance;		
	}
	
	public Object evaluate(Environment environment, List arguments) {
		Object parameters = arguments.first();
		List body = (List)arguments.rest();
		
		Bind bind = new Bind(parameters, body);
		FClosure closure = new FClosure(environment, bind);
		
		return closure;
	}
}