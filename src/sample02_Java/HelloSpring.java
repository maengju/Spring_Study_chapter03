package sample02_Java;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class HelloSpring {

	public static void main(String[] args) {
		MessageBean messageBean = new MessageBeanImpl();
		
		//자바로 구현
		MessageBean proxy = (MessageBean) Proxy.newProxyInstance(
				MessageBeanImpl.class.getClassLoader()	//내가 사용할 파일의 클래스로더 생성 (타깃)
				, new Class[] {MessageBean.class} //모든 JoinPoint 여기안에
				, new InvocationHandler() {
					
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						System.out.println("입실"); // 공통모듈,부가기능  before
						
						Object ob = method.invoke(messageBean, args); //핵심사항 호출 메소드
						
						System.out.println("퇴실"); //After
						return  ob;
					}
				}); //Proxy설정
		
		proxy.study();
		System.out.println("---------------------------------------------------------");
		System.out.println("result = "+proxy.game());
		
	
	}

}
