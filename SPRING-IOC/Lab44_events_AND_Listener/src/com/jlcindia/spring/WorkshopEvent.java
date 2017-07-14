package com.jlcindia.spring;

import org.springframework.context.ApplicationEvent;

public class WorkshopEvent extends ApplicationEvent{

	Workshop ws;

	public WorkshopEvent(Object source, Workshop ws) {
		super(source);
		this.ws = ws;
	}

public Workshop getWorkshop() {
	return ws;
	
}


	public String toString() {
		return "WorkshopEvent [ws=" + ws + "]";
	}
	
	
	
}