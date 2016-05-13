package ComponentBase;

import ComponentBase.message.Message;
import ComponentBase.order.Order;
import ComponentBase.order.SelectedProduct;
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

import java.util.Date;
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

		Address address = new Address("46/1","9","ซอย06","หนองแหย่ง","สันทราย","เชียงใหม่","50210");
		Set<Address> addresses = new HashSet<>();
		addresses.add(address);
		User user = new User("panit","panit","jaijaroen","panit_j@cmu.ac.th","1234",roles,addresses,"0882686352");
		User userAdmin = new User("admin","admin","admin","admin@admin.com","1234",roles,addresses,"876846545");
		Message userAddAddress = new Message("Welcome","Welcome to Watphasom Online Shop");
		user.getMessages().add(userAddAddress);
		userAdmin.getMessages().add(userAddAddress);
		userRepository.save(user);
		userRepository.save(userAdmin);

		Product sampleProduct01 = new Product("ข้าวฮาง","first",80.00,70.00,60.00,"food","rice");
		Product sampleProduct02 = new Product("ข้าวฮ่าง","Secound",80.00,70.00,60.00,"food","rice");
		Product sampleProduct03 = new Product("ข้าวฮ้าง","thired",80.00,70.00,60.00,"food","rice");
		productRepository.save(sampleProduct01);
		productRepository.save(sampleProduct02);
		productRepository.save(sampleProduct03);
		productRepository.save(new Product("ข้าวฮง","description",80.00,70.00,60.00,"food","rice"));
		productRepository.save(new Product("ข้าวฮุง","description",80.00,70.00,60.00,"food","rice"));
		productRepository.save(new Product("ข้าวฮาว","description",80.00,70.00,60.00,"food","rice"));

		Date date = new Date();
		Set<SelectedProduct> selectedProducts = new HashSet<>();
		selectedProducts.add(new SelectedProduct(1,sampleProduct01));
		selectedProducts.add(new SelectedProduct(2,sampleProduct02));
		selectedProducts.add(new SelectedProduct(3,sampleProduct03));

		orderRepository.save(new Order(date,selectedProducts,user.getId(),"EMS"));
	}
}
