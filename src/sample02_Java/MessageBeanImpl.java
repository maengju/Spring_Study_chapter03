package sample02_Java;

public class MessageBeanImpl implements MessageBean {

	@Override
	public void study() {
		
		
		System.out.println("나는 한다 공부를 수업시간에");
		
		
	}

	@Override
	public String game() {
		
		System.out.println("나는 한다. 몰래 게임을 수업시간에");
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "아ㅋㅋ 몰겜은 ㅇㅈ이지 ㅋㅋ";
	}

}
