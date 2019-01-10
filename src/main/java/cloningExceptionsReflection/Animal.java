package cloningExceptionsReflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Animal {
	private String name;
	private int old;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getOld() {
		return old;
	}

	public void setOld(int old) {
		this.old = old;
	}

	private Animal() {
		name = "Unknown";
		old = -1;
	}

	public Animal(String name, int old) {
		this.name = name;
		this.old = old;
	}

	@Override
	public String toString() {
		return "Animal [name=" + name + ", old=" + old + "]";
	}

	private void someInternalLogic() {
		old += 999;
		name += "!!!!";
	}
}


