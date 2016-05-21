package watphasom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import watphasom.bankTranfer.BankTranfer;
import watphasom.image.ImageUtil;
import watphasom.order.Order;
import watphasom.order.SelectedProduct;
import watphasom.product.Product;
import watphasom.repository.*;
import watphasom.role.Role;
import watphasom.transportation.Transportation;
import watphasom.transportation.TransportationType;
import watphasom.user.User;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


@EnableAutoConfiguration
@SpringBootApplication
public class WatPhasomApplication implements CommandLineRunner {
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	RoleRepository roleRepository;
	@Autowired
	TransportationRepository transportationRepository;
	@Autowired
	TransportationTypeRepository transportationTypeRepository;
	@Autowired
	BankTranferRepository bankTranferRepository;
	@Autowired
	OrderRepository orderRepository;


	public static void main(String[] args) {
		SpringApplication.run(WatPhasomApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		productRepository.deleteAll();
		userRepository.deleteAll();
		roleRepository.deleteAll();
		transportationTypeRepository.deleteAll();
		transportationRepository.deleteAll();
		bankTranferRepository.deleteAll();
		orderRepository.deleteAll();


		transportationTypeRepository.save(Arrays.asList(
				new TransportationType("EMS"),
				new TransportationType("WatPhasom")
		));
		transportationRepository.save(Arrays.asList(
				new Transportation(transportationTypeRepository.findByName("EMS")),
				new Transportation(transportationTypeRepository.findByName("WatPhasom"))
		));

		bankTranferRepository.save(Arrays.asList(
				new BankTranfer(ImageUtil.resizeImage(ImageUtil.getImage("pic/bank_transfer.gif")))
		));

		roleRepository.save(Arrays.asList(
				new Role("customer"),
				new Role("admin"),
				new Role("retailer"),
				new Role("wholesaler")
		));
		userRepository.save(Arrays.asList(
				new User("Master","123456","email@email.com","Hogward","4656631",roleRepository.findByRoleName("admin"))
				,new User("TestUser","123456","testemail@email.com","saudi arabia","978947",roleRepository.findByRoleName("customer"))
				,new User("retailer","123456","testemail01@email.com","saudi arabia","978943",roleRepository.findByRoleName("retailer"))
				,new User("wholesaler","123456","testemail02@email.com","saudi arabia","967936",roleRepository.findByRoleName("wholesaler"))
		));
		productRepository.save(Arrays.asList(
				new Product("rice","very good tast",40,50,60,ImageUtil.resizeImage(ImageUtil.getImage("pic/116682.jpg")),"food","rice"),
				new Product("Heavy rice","very very good tast",40,50,60,ImageUtil.resizeImage(ImageUtil.getImage("pic/116682.jpg")),"food","rice")
		));
		SelectedProduct a = new SelectedProduct(productRepository.findByNameContaining("rice").get(0),2);
		SelectedProduct b = new SelectedProduct(productRepository.findByNameContaining("Heavy").get(0),3);
		Set<SelectedProduct> selectedProductSet01 =new HashSet<>();
		Set<SelectedProduct> selectedProductSet02 =new HashSet<>();
		selectedProductSet01.add(a);
		selectedProductSet02.add(a);
		selectedProductSet02.add(b);
		orderRepository.save(Arrays.asList(new Order(selectedProductSet01,userRepository.findByUsername("Master")),
				new Order(selectedProductSet02,userRepository.findByUsername("TestUser"))
		));
	}

}
