package fawryDemo;

import java.io.IOException;

public class FormHandler {
	FileHandler fH=new FileHandler();
	String[] requirements;
	String serviceName;
	FormHandler(String serviceName ,String requirements[]){
		this.requirements=requirements;
		this.serviceName=serviceName;
	}
	void fillForm() throws IOException {
		for(int i=0;i<requirements.length;i++) {
			fH.appendInFile(serviceName.toLowerCase()+".txt", requirements[i]);	
		}
	}
}
