package fr.isima.idcontainer.container;

import fr.isima.idcontainer.annotate.InjectField;

import java.lang.reflect.Field;
import java.util.Map;

public class Container {
    private static Container container;
    private static Map<Class<?>,Class<?>> implementationRegistered;
    // private constructor allow to have singleton pattern
    private Container(){}
    public static Container getcontainer(){
        if(container == null){
            container = new Container();
        }
        return container;
    }

    public static void register(Class<?> myclass,Class<?> myimplementation){
        implementationRegistered.put(myclass,myimplementation);
    }

    public Class<?> getInstance(Class<?> myclass){
        return implementationRegistered.get(myclass);
    }

    public Object newInstance(Class<?> myclass){
        Object toCreate = null;
        try {
            toCreate = myclass.getDeclaredConstructor().newInstance();
            linkAttribute(myclass,toCreate);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return toCreate;
    }

    private void linkAttribute(Class<?> myclass, Object instance){
        Field[] fields = myclass.getDeclaredFields();

        for(Field field:fields){
            // this check allow to know if fields should be injected
            if(field.isAnnotationPresent(InjectField.class)){
                Object fieldObj = newInstance(field.getType());
                field.setAccessible(true);
                try {
                    field.set(instance,fieldObj);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
