package com.jayeshtajane.salarymanager.modal.attendence;

import java.util.ArrayList;

public class Attendence {
	private String attendence;
	private String attendneceDate;
		
	public Attendence(String attendence, String attendneceDate) {
		super();
		this.attendence = attendence;
		this.attendneceDate = attendneceDate;
	}
	
	public void formatAttendence() {
		char[] arr = this.attendence.toCharArray();
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "--");
		}
	}
	public void save() {
		formatAttendence();
		System.out.println("INFO : Attendence saved");
	}
}
