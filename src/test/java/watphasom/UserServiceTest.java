package watphasom;

import watphasom.user.*;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


/**
 * Created by panit on 5/18/2016.
 */
public class UserServiceTest {


    @Test
    public void getAll(){
        UserDao u = mock(UserDaoImpl.class);
        when(u.getAll()).thenReturn(Arrays.asList(
                new User("panit","1234","panit_j@outlook.co.th","46/1 หมู่ 9 หนองแหย่ง สันทราย เชียงใหม่ 50210","0882686352")
                ,new User("Payu","346345","Abacs@aedb","Mar","t534345")
                ,new User("Jhon","873533","asvas@brwbs","Moon","fnffg534")
        ));
        UserService userService = new UserServiceImpl(u);
        List<User> users = userService.getAll();
        assert users.get(0).getUsername().equals("panit");
        assert users.get(1).getUsername().equals("Payu");
        assert users.get(2).getUsername().equals("Jhon");

    }
    @Test
    public void getByUsername(){
        UserDao u = mock(UserDaoImpl.class);
        when(u.findByUsername("panit")).thenReturn(new User("panit","1234","panit_j@outlook.co.th","46/1 หมู่ 9 หนองแหย่ง สันทราย เชียงใหม่ 50210","0882686352"));
        UserService userService = new UserServiceImpl(u);
        User user = userService.findByUsername("panit");
        assertThat(user,is(notNullValue()));
        assertThat(user.getUsername(),is(equalTo("panit")));
        assertThat(user.getAddress(),is(equalTo("46/1 หมู่ 9 หนองแหย่ง สันทราย เชียงใหม่ 50210")));
        assertThat(user.getEmail(),is(equalTo("panit_j@outlook.co.th")));
    }
}
