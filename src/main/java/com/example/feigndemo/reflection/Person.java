package com.example.feigndemo.reflection;

import java.io.Serializable;
import java.lang.reflect.Modifier;
import java.lang.reflect.TypeVariable;

public class Person implements Cloneable, Serializable {
    private int id = -1;
    private String name = "Unknown";

    public Person() {

    }

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Person clone() {
        try {
            return ( Person ) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "Person{" + "id=" + id + ", name='" + name + '\'' + '}';
    }
}

class ClassReflection {

    public static void main(String[] args) {
        String classDescription = getClassDescription(Integer.class);
        System.out.println(classDescription);
    }

    public static String getClassDescription(Class<?> className) {
        StringBuilder classDescription = new StringBuilder();
        int modifierBits = 0;
        String keyword = "";

        if(className.isPrimitive()) {

        } else if (className.isInterface()) {
            modifierBits = className.getModifiers() & Modifier.interfaceModifiers();
            if (className.isAnnotation()) {
                keyword = "@interface";
            } else {
                keyword = "interface";
            }
        } else if (className.isEnum()) {
            modifierBits = className.getModifiers() & Modifier.classModifiers();
            keyword = "enum";
        } else {
            modifierBits = className.getModifiers() & Modifier.classModifiers();
            keyword = "class";
        }

        String modifiers = Modifier.toString(modifierBits);
        classDescription.append(modifiers);
        classDescription.append(" ");
        classDescription.append(keyword);

        String simpleName = className.getSimpleName();
        classDescription.append(" ");
        classDescription.append(simpleName);

        String genericParams = getGenericTypeParams(className);
        classDescription.append(genericParams);

        Class superClass = className.getSuperclass();
        if (superClass != null) {
            String superClassSimplename = superClass.getSimpleName();
            classDescription.append(" extends ");
            classDescription.append(superClassSimplename);
        }

        String interfaces = ClassReflection.getClassInterfaces(className);
        if (interfaces != null) {
            classDescription.append(" implements ");
            classDescription.append(interfaces);
        }

        return classDescription.toString().trim();
    }

    public static String getClassInterfaces(Class<?> cls) {
// Get a comma-separated list of interfaces implemented by the class
        Class<?>[] interfaces = cls.getInterfaces();
        if (interfaces.length == 0) {
            return null;
        }
        String[] names = new String[interfaces.length];
        for (int i = 0; i < interfaces.length; i++) {
            names[i] = interfaces[i].getSimpleName();
        }
        String interfacesList = String.join(", ", names);
        return interfacesList;
    }

    public static String getGenericTypeParams(Class<?> cls) {
        StringBuilder sb = new StringBuilder();
        TypeVariable<?>[] typeParms = cls.getTypeParameters();
        if (typeParms.length == 0) {
            return "";
        }
        String[] paramNames = new String[typeParms.length];
        for (int i = 0; i < typeParms.length; i++) {
            paramNames[i] = typeParms[i].getTypeName();
        }
        sb.append('<');
        String parmsList = String.join(",", paramNames);
        sb.append(parmsList);
        sb.append('>');
        return sb.toString();
    }
}