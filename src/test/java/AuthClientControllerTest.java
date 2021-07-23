import com.fasterxml.jackson.databind.ObjectMapper;
import com.hms.request.LoginRequest;
import com.hms.request.SignupRequest;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
public class AuthClientControllerTest extends AbstractTest {
    @Override
    @Before
    public void setUp() {
        super.setUp();
    }
    @Test
    public void authentificateClientWithValidEmailAndPassword() throws Exception {
        LoginRequest request=new LoginRequest();
        request.setEmail("client1@gmail.com");
        request.setPassword("kaka0000");
        String uri = "/api/auth/signin";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(request)))
                .andExpect(status().isOk()).andReturn();
    }
    @Test
    public void authentificateClientWithValidEmailAndInvalidPassword() throws Exception {
        LoginRequest request=new LoginRequest();
        request.setEmail("client1@gmail.com");
        request.setPassword("kaka0000");
        String uri = "/api/auth/signin";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(request)))
                .andExpect(status().isOk()).andReturn();
    }

    @Test
    public void authentificateClientInValidEmailAndValidPassword() throws Exception {
        LoginRequest request=new LoginRequest();
        request.setEmail(null);
        request.setPassword("kaka0000");
        String uri = "/api/auth/signin";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(request)))
                .andExpect(status().isBadRequest()).andReturn();
    }
    @Test
    public void authentificateClientInValidEmailAndInValidPassword() throws Exception {
        LoginRequest request=new LoginRequest();
        request.setEmail(null);
        request.setPassword(null);
        String uri = "/api/auth/signin";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(request)))
                .andExpect(status().isBadRequest()).andReturn();
    }
    @Test
    public void authentificateClientWithEmptyEmailAndEmptyPassword() throws Exception {
        LoginRequest request=new LoginRequest();
        request.setEmail(null);
        request.setPassword(null);
        String uri = "/api/auth/signin";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(request)))
                .andExpect(status().isBadRequest()).andReturn();
    }

    @Test
    public void registerClientWithEmptyAllData() throws Exception {
        SignupRequest request=new SignupRequest();

        String uri = "/api/auth/signup";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(request)))
                .andExpect(status().isBadRequest()).andReturn();
    }
    @Test
    public void registerClientWithAllData() throws Exception {
        SignupRequest request=new SignupRequest();
        request.setPassword("kaka0000");
        request.setEmail("test@yahoo.com");
        request.setAdresse("mahdia");
        request.setFirstName("testname");
        request.setLastName("testlastname");
        request.setPhone("97979797");
        request.setCin("1111111");
        request.setRole("Client");
        request.setEmployeservice("plombier");
        String uri = "/api/auth/signup";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(request)))
                .andExpect(status().isBadRequest()).andReturn();
    }
    @Test
    public void registerClientWithEmptyPassword() throws Exception {
        SignupRequest request=new SignupRequest();
        request.setPassword(null);
        request.setEmail("test@yahoo.com");
        request.setAdresse("mahdia");
        request.setFirstName("testname");
        request.setLastName("testlastname");
        request.setPhone("97979797");
        request.setCin("1111111");
        request.setRole("Client");
        request.setEmployeservice("plombier");
        String uri = "/api/auth/signup";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(request)))
                .andExpect(status().isBadRequest()).andReturn();
    }
    @Test
    public void registerClientWithEmptyEmail() throws Exception {
        SignupRequest request=new SignupRequest();
        request.setPassword("kaka0000");
        request.setEmail(null);
        request.setAdresse("mahdia");
        request.setFirstName("testname");
        request.setLastName("testlastname");
        request.setPhone("97979797");
        request.setCin("1111111");
        request.setRole("Client");
        request.setEmployeservice("plombier");
        String uri = "/api/auth/signup";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(request)))
                .andExpect(status().isBadRequest()).andReturn();
    }
    @Test
    public void registerClientEmptyLocation() throws Exception {
        SignupRequest request=new SignupRequest();
        request.setPassword("kaka0000");
        request.setEmail("test@yahoo.com");
        request.setAdresse(null);
        request.setFirstName("testname");
        request.setLastName("testlastname");
        request.setPhone("97979797");
        request.setCin("1111111");
        request.setRole("Client");
        request.setEmployeservice("plombier");
        String uri = "/api/auth/signup";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(request)))
                .andExpect(status().isBadRequest()).andReturn();
    }
    @Test
    public void registerClientWithEmptyFirsname() throws Exception {
        SignupRequest request=new SignupRequest();
        request.setPassword("kaka0000");
        request.setEmail("test@yahoo.com");
        request.setAdresse("mahdia");
        request.setFirstName(null);
        request.setLastName("testlastname");
        request.setPhone("97979797");
        request.setCin("1111111");
        request.setRole("Client");
        request.setEmployeservice("plombier");
        String uri = "/api/auth/signup";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(request)))
                .andExpect(status().isBadRequest()).andReturn();
    }
    @Test
    public void registerClientWithNullLastname() throws Exception {
        SignupRequest request=new SignupRequest();
        request.setPassword("kaka0000");
        request.setEmail("test@yahoo.com");
        request.setAdresse("mahdia");
        request.setFirstName("testname");
        request.setLastName(null);
        request.setPhone("97979797");
        request.setCin("1111111");
        request.setRole("Client");
        request.setEmployeservice("plombier");
        String uri = "/api/auth/signup";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(request)))
                .andExpect(status().isBadRequest()).andReturn();
    }
    @Test
    public void registerClientWithEmptyPhone() throws Exception {
        SignupRequest request=new SignupRequest();
        request.setPassword("kaka0000");
        request.setEmail("test@yahoo.com");
        request.setAdresse("mahdia");
        request.setFirstName("testname");
        request.setLastName("testlastname");
        request.setPhone(null);
        request.setCin("1111111");
        request.setRole("Client");
        request.setEmployeservice("plombier");
        String uri = "/api/auth/signup";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(request)))
                .andExpect(status().isBadRequest()).andReturn();
    }
    @Test
    public void registerClientWithEmptyCin() throws Exception {
        SignupRequest request=new SignupRequest();
        request.setPassword("kaka0000");
        request.setEmail("test@yahoo.com");
        request.setAdresse("mahdia");
        request.setFirstName("testname");
        request.setLastName("testlastname");
        request.setPhone("97979797");
        request.setCin(null);
        request.setRole("Client");
        request.setEmployeservice("plombier");
        String uri = "/api/auth/signup";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(request)))
                .andExpect(status().isBadRequest()).andReturn();
    }
    @Test
    public void registerClientWithEmptyRole() throws Exception {
        SignupRequest request=new SignupRequest();
        request.setPassword("kaka0000");
        request.setEmail("test@yahoo.com");
        request.setAdresse("mahdia");
        request.setFirstName("testname");
        request.setLastName("testlastname");
        request.setPhone("97979797");
        request.setCin("1111111");
        request.setRole(null);
        request.setEmployeservice("plombier");
        String uri = "/api/auth/signup";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(request)))
                .andExpect(status().isBadRequest()).andReturn();
    }
    @Test
    public void registerClientWithEmptyService() throws Exception {
        SignupRequest request=new SignupRequest();
        request.setPassword("kaka0000");
        request.setEmail("test@yahoo.com");
        request.setAdresse("mahdia");
        request.setFirstName("testname");
        request.setLastName("testlastname");
        request.setPhone("97979797");
        request.setCin("1111111");
        request.setRole("Client");
        request.setEmployeservice(null);
        String uri = "/api/auth/signup";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(request)))
                .andExpect(status().isBadRequest()).andReturn();
    }
    @Test
    public void registerClientWithAllDataNull() throws Exception {
        SignupRequest request=new SignupRequest();
        request.setPassword(null);
        request.setEmail(null);
        request.setAdresse(null);
        request.setFirstName(null);
        request.setLastName(null);
        request.setPhone(null);
        request.setCin(null);
        request.setRole(null);
        request.setEmployeservice(null);
        String uri = "/api/auth/signup";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(request)))
                .andExpect(status().isBadRequest()).andReturn();
    }
    @Test
    public void registerClientWithOnlyPasswordAndEmailNotNull() throws Exception {
        SignupRequest request=new SignupRequest();
        request.setPassword("kaka0000");
        request.setEmail("test@yahoo.com");
        request.setAdresse(null);
        request.setFirstName(null);
        request.setLastName(null);
        request.setPhone(null);
        request.setCin(null);
        request.setRole(null);
        request.setEmployeservice(null);
        String uri = "/api/auth/signup";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(request)))
                .andExpect(status().isBadRequest()).andReturn();
    }
    @Test
    public void registerClientWithOnlyPasswordNotNull() throws Exception {
        SignupRequest request=new SignupRequest();
        request.setPassword("kaka0000");
        request.setEmail(null);
        request.setAdresse(null);
        request.setFirstName(null);
        request.setLastName(null);
        request.setPhone(null);
        request.setCin(null);
        request.setRole(null);
        request.setEmployeservice(null);
        String uri = "/api/auth/signup";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(request)))
                .andExpect(status().isBadRequest()).andReturn();
    }
    @Test
    public void registerClientWithOnlyEmailNotNull() throws Exception {
        SignupRequest request=new SignupRequest();
        request.setPassword(null);
        request.setEmail("test@yahoo.com");
        request.setAdresse(null);
        request.setFirstName(null);
        request.setLastName(null);
        request.setPhone(null);
        request.setCin(null);
        request.setRole(null);
        request.setEmployeservice(null);
        String uri = "/api/auth/signup";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(request)))
                .andExpect(status().isBadRequest()).andReturn();
    }
    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
