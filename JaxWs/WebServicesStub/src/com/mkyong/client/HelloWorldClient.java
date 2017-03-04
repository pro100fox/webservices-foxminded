package com.mkyong.client;

import com.mkyong.ws.HelloWorld;
import com.mkyong.ws.HelloWorldImplService;

public class HelloWorldClient{
	
	public static void main(String[] args) {
	   
		HelloWorldImplService helloService = new HelloWorldImplService();
		HelloWorld hello = helloService.getHelloWorldImplPort();
	
		System.out.println(hello.getHelloWorldAsString("mkyong"));
		
    }

}
