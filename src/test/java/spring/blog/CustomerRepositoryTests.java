package spring.blog;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import spring.blog.models.Customer;
import spring.blog.repositories.CustomerRepository;

/**
 * 
 * http://javasampleapproach.com/testing/datajpatest-with-spring-boot
 *
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class CustomerRepositoryTests {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	CustomerRepository repository;

	@Test
	public void should_find_no_customers_if_repository_is_empty() {
		Iterable<Customer> customers = repository.findAll();

		assertThat(customers).isEmpty();
	}

	@Test
	public void should_store_a_customer() {
		Customer customer = repository.save(new Customer("Bamba", "Athj"));

		assertThat(customer).hasFieldOrPropertyWithValue("firstName", "Bamba");
		assertThat(customer).hasFieldOrPropertyWithValue("lastName", "Athj");
	}

	@Test
	public void should_delete_all_customer() {
		entityManager.persist(new Customer("Bamba", "Athj"));
		entityManager.persist(new Customer("Fourya", "Lô"));

		repository.deleteAll();

		assertThat(repository.findAll()).isEmpty();
	}

	@Test
	public void should_find_all_customers() {
		Customer customer1 = new Customer("Bamba", "Athj");
		entityManager.persist(customer1);

		Customer customer2 = new Customer("Fourya", "Lô");
		entityManager.persist(customer2);

		Customer customer3 = new Customer("Robert", "Adonsou");
		entityManager.persist(customer3);

		Iterable<Customer> customers = repository.findAll();

		assertThat(customers).hasSize(3).contains(customer1, customer2, customer3);
	}

}