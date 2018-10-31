package com.learn.isAnnotationPresent;

import java.lang.reflect.Method;

public class PackageDemo {

	// set values for the annotation
	@Demo(str = "Demo Annotation", val = 100)
	// a method to call in the main
	public static void example() {
		PackageDemo ob = new PackageDemo();

		try {
			Class c = ob.getClass();

			// get the method example
			Method m = c.getMethod("example");

			// get the annotation for class Demo
			Demo annotation = m.getAnnotation(Demo.class);

			// print the annotation
			System.out.println(annotation.str() + " " + annotation.val());
		} catch (NoSuchMethodException exc) {
			exc.printStackTrace();
		}
	}

	public static void main(String args[]) throws ClassNotFoundException, NoSuchMethodException, SecurityException {
		example();
		Package p=Package.getPackage("com.learn.isAnnotationPresent");
		System.out.println(p.isAnnotationPresent(Demo.class));
		Class c=Class.forName("com.learn.isAnnotationPresent.PackageDemo");
		Method m = c.getMethod("example");
		System.out.println(c.isAnnotationPresent(Demo.class));
		System.out.println(m.isAnnotationPresent(Demo.class));
		Package[] pack = Package.getPackages();
		// check if annotation hello exists
		for (int i = 0; i < pack.length; i++) {
			System.out.println("" + pack[i].isAnnotationPresent(Demo.class));
		}
	}
}