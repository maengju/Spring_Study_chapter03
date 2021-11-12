package sample03_Advice;

import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.MethodBeforeAdvice;

public class LoggingAroundAdvice implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation Invocation) throws Throwable {
		//공통
		System.out.println("around -------- insert"); //공통,부가기능
		long start = System.currentTimeMillis();
		
		//핵심
		Object ob = Invocation.proceed();//핵심사항 호출
		
		
		//공통
		long end = System.currentTimeMillis();
		
		System.out.println((end-start)/1000+"sec");
		System.out.println("around ------------- exit"); //공통,부가기능
		
		
		return ob;
	}

	
}
