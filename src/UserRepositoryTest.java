import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


class UserRepositoryTest {
	static UserModel userModel;
	 	
	@BeforeAll
	static void init() {
		userModel = new UserModel();
	}
	
	@Test
	void testValidateWithBranchingMissingValue() {
			
		assertThrows(IllegalArgumentException.class, () -> {
			UserRepository.register(userModel, ValidationMode.BRANCHING);
	    });	
	}
	
	@Test
	void testValidateWithAnnotationMissingValue() {
		
		assertThrows(IllegalArgumentException.class, () -> {
			UserRepository.register(userModel, ValidationMode.ANNOTATION);
	    });	
	}

}
