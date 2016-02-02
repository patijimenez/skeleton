package mx.gob.inadem.document;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author iamedu
 */
public class DocumentUtil {

    public static String getName(String path) {
        if(path == null || path.isEmpty()) {
            return "";
        }
        String[] parts = convertToPathParts(path);
        return parts[parts.length - 1];
    }
    
    public static String[] getParentParts(String path) {
        if(path == null || path.isEmpty()) {
            return new String[0];
        }
        String[] parts = convertToPathParts(path);
        String[] result = new String[parts.length - 1];
        System.arraycopy(parts, 0, result, 0, parts.length - 1);
        return result;
    }
    
    public static String convertToPath(String... parts) {
        StringBuilder builder = new StringBuilder();
        
        builder.append("/");
        
        for(int i = 0; i < parts.length; i++) {
            builder.append(parts[i]);
            if(i < parts.length - 1) {
                builder.append("/");
            }
        }
        
        return builder.toString();
    }
    
    public static String[] convertToPathParts(String path) {
        if (path == null) {
            return new String[0];
        }
        path = path.trim();

        if(path.startsWith("/")) {
            path = path.substring(1);
        }
        
        if (path.isEmpty()) {
            return new String[0];
        }
        
        return path.split("/");
    }

    public static String[] getDatePathParts(Date date) {
        SimpleDateFormat dt = new SimpleDateFormat("yyyy/MM/dd");
        return convertToPathParts(dt.format(date));
    }

    public static String getParent(String documentPath) {
        return convertToPath(getParentParts(documentPath));
    }

    public static String getName(String... documentPath) {
        return getName(convertToPath(documentPath));
    }

    public static String getParent(String... documentPath) {
        return getParent(convertToPath(documentPath));
    }
}
