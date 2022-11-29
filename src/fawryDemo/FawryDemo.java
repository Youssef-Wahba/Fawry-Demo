package fawryDemo;

public class FawryDemo {

	public static void main(String[] args) {
		UserManage m=new UserManage();
		if(m.signUpUser(new User("asdfaasdasdfasdddddddddd","youssddssasdfasdfasdfef","aasdasd"))) {
			System.out.println("signed up ");
		}else System.out.println("not signed up ");
	}

}