package spring.blog;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import spring.blog.models.User;
import spring.blog.repositories.UserRepository;

/**
 * 
 * Taken from 
 * 
 * http://javasampleapproach.com/testing/datajpatest-with-spring-boot 
 *
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTests {
	
	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private UserRepository userRepository;
	
	@Test
	public void should_find_no_users_if_repository_is_empty() throws Exception {
		List<User> users = this.userRepository.findAll();		
		assertThat(users).isEmpty();
	}	
	
	@Test
	public void should_store_a_user() throws Exception {
		// Create a dummy user
		User bamba = new User( 1L, "bamba", "Bamba Athj");
		// We need to set a password or it will throw out an exception
		bamba.setPasswordHash("password1");
		// Save changes
		bamba = this.userRepository.save( bamba);
		// Make assertions		
		assertThat(bamba.getUserName()).isEqualTo("bamba2001");
		assertThat(bamba.getFullName()).isEqualTo("Bamba Athj");
		assertThat(bamba.getPasswordHash()).isEqualTo("password1");
		assertThat(bamba).hasFieldOrPropertyWithValue("userName", "bamba2001");
	}
	
	@Test
	public void should_delete_all_users() throws Exception {
		// Create dummy users
		User bamba = new User( 10L, "athj", "Fourya Lô");
		User fourya = new User( 20L, "fourya", "Fourya Lô");
		// We need to set a password or it will throw out an exception
		bamba.setPasswordHash("password1");
		fourya.setPasswordHash("password2");
/*		
		// ==============================================================================
		// TODO!, no need to use these as we're trying TestEntityManager, just leaving it.
		// ==============================================================================
		// To save them individually
		//this.userRepository.save( bamba );
		//this.userRepository.save( fourya );
		// ==============================================================================
		// To save them in one step
		List<User> users = new ArrayList<User>(){
			private static final long serialVersionUID = -3009157732242241606L;
		{ add(bamba); add(fourya); }};
		this.userRepository.saveAll( users );
		// ==============================================================================
*/		
		
		// Need to explore more on how to use TestEntityManager
		// use merge instead of persist
		// https://stackoverflow.com/questions/24721688/org-hibernate-persistentobjectexception-detached-entity-passed-to-persist-whe
		this.entityManager.merge(bamba);
		this.entityManager.merge(fourya);
		
		// Remove after inserting		
		this.userRepository.deleteAll();
		
		assertThat(this.userRepository.findAll()).isEmpty();		
	}

}
