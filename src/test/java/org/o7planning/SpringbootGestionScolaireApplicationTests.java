package org.o7planning;

import org.junit.jupiter.api.Test;
import org.o7planning.repository.ProfesseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootGestionScolaireApplicationTests {

	@Autowired
	private ProfesseurRepository professeurRepository;
	
	@Test
	public void testCreateProfesseur() {
		
	}

}
