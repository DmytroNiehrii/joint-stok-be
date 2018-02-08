package com.jointstock.jointstokbe;

import com.jointstock.jointstokbe.model.User;
import com.jointstock.jointstokbe.model.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import static org.hamcrest.CoreMatchers.*;

import javax.persistence.EntityManager;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional(transactionManager = "userTransactionManager")
public class JointStokBeApplicationTests {
	@Autowired UserRepository repository;
	@Autowired @Qualifier("userEntityManagerFactory") EntityManager em;

	@Test
	public void findsCustomerByLastname() {

		Optional<User> result = repository.findByLastname("Smith");

		assertThat(result, is(not(Optional.empty())));
		assertThat(result.get().getFirstname(), is("John"));
		assertThat("Dave", is("Dave"));
	}



}
