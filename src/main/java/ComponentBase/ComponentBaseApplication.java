package ComponentBase;

import ComponentBase.product.Product;
import ComponentBase.repository.*;
import ComponentBase.user.Address;
import ComponentBase.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ComponentBase.role.Role;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

import java.util.HashSet;
import java.util.Set;
@EnableAutoConfiguration
@SpringBootApplication
public class ComponentBaseApplication extends SpringBootServletInitializer implements CommandLineRunner {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private OrderRepository orderRepository;

	public static void main(String[] args) {
		SpringApplication.run(ComponentBaseApplication.class, args);

	}
	@Override
	protected SpringApplicationBuilder configure(final SpringApplicationBuilder application) {

		return application.sources(ComponentBaseApplication.class);
	}

	@Override
	public void run(String... args) throws Exception {
		userRepository.deleteAll();
		roleRepository.deleteAll();
		productRepository.deleteAll();
		orderRepository.deleteAll();

		Role adminRole = new Role("admin");
		Role customerRole = new Role("customer");
		roleRepository.save(customerRole);
		roleRepository.save(adminRole);
		Set<Role> roles = new HashSet<>();
		roles.add(adminRole);

		Address address = new Address("46/1","9","soi06","หนองแหย่ง","สันทราย","เชียงใหม่","50210");
		Set<Address> addresses = new HashSet<>();
		addresses.add(address);

		userRepository.save(new User("panit","panit","jaijaroen","panit_j@cmu.ac.th","1234",roles,addresses,"0882686352"));

		//

	}
}
