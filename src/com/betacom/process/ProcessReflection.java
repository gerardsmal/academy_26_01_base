package com.betacom.process;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

import com.betacom.interfaces.ProcessInterface;

public class ProcessReflection implements ProcessInterface{

	@Override
	public boolean execute() throws Exception {
		System.out.println("Begin ProcessReflection");
		
		String packageName = "com.betacom.objects";
		String className   = "MyClassReflection";
		
		try {
			Class cl = Class.forName(packageName + "." + className); 
			System.out.println("Class " + className + " found");
			
			/*
			 * retrieve contructors for selected class
			 */
			Constructor[] ctore = cl.getConstructors();
			Constructor  selectedConstructor = null;
			int constructorToSelect = 0;
			Object myClass = null;
			
			System.out.println("numero di contructors trovati:" + ctore.length);
			
			for (Constructor ctore1:ctore) {
				/*
				 * search parameters number for all constructors
				 */
				System.out.println("..Parameters number for constuctor:" + ctore1.getParameterCount());
				
				if (ctore1.getParameterCount() == constructorToSelect) {
					selectedConstructor = ctore1;
				}
				
				Type[] type = ctore1.getGenericParameterTypes();
				for (Type t:type) {
					System.out.println("....Parameter type:" + t);
				}
			}

			/*
			 * new instance
			 */
			if (constructorToSelect == 0) {
				myClass = selectedConstructor.newInstance();
				System.out.println("select constructor without parameter");
			}
			
			if (constructorToSelect == 2) {
				myClass = selectedConstructor.newInstance(10, "Description numero 1");
				System.out.println("select constructor with 2 parameters");
			}
		
			if (constructorToSelect == 3) {
				myClass = selectedConstructor.newInstance(10, "Description numero 2", 20);
				System.out.println("select constructor with 3 parameters");
			}
			
			
			/*
			 * introspection methods
			 */
			Method[] methods = myClass.getClass().getMethods();
			for (Method method:methods) {
				System.out.println("... method found:" + method.getName());
				
				if ("setId".equals(method.getName())) {
					method.invoke(myClass, 99);
				}

				if ("setDesc".equals(method.getName())) {
					method.invoke(myClass, "description caricato dentro loop");
				}

				if ("setP1".equals(method.getName())) {
					method.invoke(myClass, 99999);
				}

			}
			
			String methodName = "toString";
			Method metodo = myClass.getClass().getMethod(methodName);
			String msg = (String)metodo.invoke(myClass);
			
			System.out.println(msg);

		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException:" + e.getMessage() );
		} catch (IllegalArgumentException e) {
			System.out.println("IllegalArgumentException:" + e.getMessage() );
		}
		 
		return false;
	}

}
