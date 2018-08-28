import java.lang.reflect.Field;

public class UserRepository {
	public static void register(UserModel userModel, ValidationMode validationMode) {
		if (null  == userModel) {
			return;
		}
		if (validationMode == ValidationMode.BRANCHING) {
			validateWithBranching(userModel);
		}
		
		if (validationMode == ValidationMode.ANNOTATION) {
			validateWithAnnotation(userModel);
		}
		
	}
	
	public static void validateWithBranching(UserModel userModel) {
		if (("").equals(userModel.getFirstName())) {
			throw new IllegalArgumentException("First Name is required");
		}
		
		if (("").equals(userModel.getLastName())) {
			throw new IllegalArgumentException("Last Name is required");
		}
	}
	
	public static void validateWithAnnotation(UserModel userModel) {
		final Field[] modelFields = userModel.getClass().getDeclaredFields();

        for (Field modelField : modelFields) {
        	if (modelField.isAnnotationPresent(Required.class)) {
        		modelField.setAccessible(true);
        		try {
        			String value = (String) modelField.get(userModel);
        			if ("".equals(value)) {
                        throw new IllegalArgumentException(modelField + " is required");
        			}
        		}
        		catch(IllegalAccessException  ex) {
        			ex.printStackTrace();
        		}
        	}
        }
	}
	
}
