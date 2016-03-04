package reflection;

/**
 * Created by User on 04.03.2016.
 */
public enum Types {
    BYTE,
    BOOLEAN,
    SHORT,
    CHAR,
    INT,
    FLOAT,
    LONG,
    DOUBLE,
    STRING;

    public static Types getType(Class<?> cl){
        String className = cl.getSimpleName().toUpperCase();
        return Types.valueOf(className);
    }
}
