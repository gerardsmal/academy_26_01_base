package com.betacom.objects;

import java.util.List;

public class GenericResponse<T, U> {
	
	private Boolean rc;
	private U msg;
	List<T> data;
	
	public Boolean getRc() {
		return rc;
	}
	public void setRc(Boolean rc) {
		this.rc = rc;
	}
	public U getMsg() {
		return msg;
	}
	public void setMsg(U msg) {
		this.msg = msg;
	}
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}
	
	@Override
	public String toString() {
		return "GenericResponse [rc=" + rc + ", msg=" + msg + ", data=" + data + "]";
	}
	
	public GenericResponse(Boolean rc, U msg, List<T> data) {
		super();
		this.rc = rc;
		this.msg = msg;
		this.data = data;
	}
	public GenericResponse() {
		super();
	}

}
