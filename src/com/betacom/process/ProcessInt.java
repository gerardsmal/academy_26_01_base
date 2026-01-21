package com.betacom.process;

import java.util.ArrayList;

import com.betacom.interfaces.ProcessInterface;
import com.betacom.interfaces.SampleInterface;
import com.betacom.interfaces.SampleInterface1;
import com.betacom.objects.ClassInterface;
import com.betacom.objects.ClasseInterface1;

public class ProcessInt implements ProcessInterface{

	@Override
	public boolean execute() throws Exception {

		System.out.println("Begin MainInterface");
		
		Object sI = new ClassInterface();
		identificate(sI);		
		
		SampleInterface si = (SampleInterface)sI;
		
		si.interface1("primo");
		si.interface2("secondo");
		
		
		SampleInterface1 sI1 = new ClasseInterface1();
		sI1.test1("test 1");
		sI1.test1("test 2");

		SampleInterface1 sII = new ClassInterface();
		sII.test1("pppp");
		sII.test2("zzz");
		
		ClassInterface cl = new ClassInterface();
		cl.interface1("zzz");
		cl.interface2("yyy");
		cl.test1("tttt");
		cl.test2("zzz");

		
		ClasseInterface1 cl1 = new ClasseInterface1();
		cl1.test1("tttt");
		cl1.test2("zzz");


		ArrayList<Object> lO = new ArrayList<Object>();
		lO.add(cl);
		lO.add(cl1);
		
		for (Object obj:lO) {
			if (obj instanceof SampleInterface) {
				SampleInterface oo = (SampleInterface)obj;
				oo.interface1("Da loop");
				oo.interface2("Da loop");
			}
			if (obj instanceof SampleInterface1) {
				SampleInterface1 oo = (SampleInterface1)obj;
				oo.test1("Da loop");
				oo.test2("Da loop");
			}
		}
		
		return true;
	}

	private void identificate(Object o) {
		if (o instanceof SampleInterface) {
			System.out.println("Object implement SampleInterface");
		}
		
		if (o instanceof SampleInterface1) {
			System.out.println("Object implement SampleInterface1");
		}
		
	}

}
