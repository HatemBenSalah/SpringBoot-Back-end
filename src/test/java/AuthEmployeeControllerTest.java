import com.fasterxml.jackson.databind.ObjectMapper;
import com.hms.request.LoginRequest;
import com.hms.request.SignupRequest;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
public class AuthEmployeeControllerTest extends AbstractTest{
    @Override
    @Before
    public void setUp() {
        super.setUp();
    }
    @Test
    public void authentificateEmployeeWithValidEmailAndPassword() throws Exception {
        LoginRequest request=new LoginRequest();
        request.setEmail("employee1@gmail.com");
        request.setPassword("kaka0000");
        String uri = "/api/authemployee/signin";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(request)))
                .andExpect(status().isOk()).andReturn();
    }
    @Test
    public void authentificateEmployeeWithValidEmailAndInvalidPassword() throws Exception {
        LoginRequest request=new LoginRequest();
        request.setEmail("employee1@gmail.com");
        request.setPassword("kaka0000");
        String uri = "/api/authemployee/signin";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(request)))
                .andExpect(status().isOk()).andReturn();
    }

    @Test
    public void authentificateEmployeeInValidEmailAndValidPassword() throws Exception {
        LoginRequest request=new LoginRequest();
        request.setEmail(null);
        request.setPassword("kaka0000");
        String uri = "/api/authemployee/signin";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(request)))
                .andExpect(status().isBadRequest()).andReturn();
    }
    @Test
    public void authentificateEmployeeInValidEmailAndInValidPassword() throws Exception {
        LoginRequest request=new LoginRequest();
        request.setEmail(null);
        request.setPassword(null);
        String uri = "/api/authemployee/signin";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(request)))
                .andExpect(status().isBadRequest()).andReturn();
    }
    @Test
    public void authentificateEmployeeWithEmptyEmailAndEmptyPassword() throws Exception {
        LoginRequest request=new LoginRequest();
        request.setEmail(null);
        request.setPassword(null);
        String uri = "/api/authemployee/signin";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(request)))
                .andExpect(status().isBadRequest()).andReturn();
    }

    @Test
    public void registerEmployeeWithEmptyAllData() throws Exception {
        SignupRequest request=new SignupRequest();

        String uri = "/api/authemployee/signup";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(request)))
                .andExpect(status().isBadRequest()).andReturn();
    }
    @Test
    public void registerEmployeeWithAllData() throws Exception {
        SignupRequest request=new SignupRequest();
        request.setPassword("kaka0000");
        request.setEmail("test@yahoo.com");
        request.setAdresse("mahdia");
        request.setFirstName("testname");
        request.setLastName("testlastname");
        request.setPhone("97979797");
        request.setCin("1111111");
        request.setRole("employee");
        request.setEmployeservice("plombier");
        String uri = "/api/authemployee/signup";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(request)))
                .andExpect(status().isBadRequest()).andReturn();
    }
    @Test
    public void registerEmployeeWithEmptyPassword() throws Exception {
        SignupRequest request=new SignupRequest();
        request.setPassword(null);
        request.setEmail("test@yahoo.com");
        request.setAdresse("mahdia");
        request.setFirstName("testname");
        request.setLastName("testlastname");
        request.setPhone("97979797");
        request.setCin("1111111");
        request.setRole("employee");
        request.setEmployeservice("plombier");
        String uri = "/api/authemployee/signup";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(request)))
                .andExpect(status().isBadRequest()).andReturn();
    }
    @Test
    public void registerEmployeeWithEmptyEmail() throws Exception {
        SignupRequest request=new SignupRequest();
        request.setPassword("kaka0000");
        request.setEmail(null);
        request.setAdresse("mahdia");
        request.setFirstName("testname");
        request.setLastName("testlastname");
        request.setPhone("97979797");
        request.setCin("1111111");
        request.setRole("employee");
        request.setEmployeservice("plombier");
        String uri = "/api/authemployee/signup";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(request)))
                .andExpect(status().isBadRequest()).andReturn();
    }
    @Test
    public void registerEmployeeEmptyLocation() throws Exception {
        SignupRequest request=new SignupRequest();
        request.setPassword("kaka0000");
        request.setEmail("test@yahoo.com");
        request.setAdresse(null);
        request.setFirstName("testname");
        request.setLastName("testlastname");
        request.setPhone("97979797");
        request.setCin("1111111");
        request.setRole("employee");
        request.setEmployeservice("plombier");
        String uri = "/api/authemployee/signup";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(request)))
                .andExpect(status().isBadRequest()).andReturn();
    }
    @Test
    public void registerEmployeeWithEmptyFirsname() throws Exception {
        SignupRequest request=new SignupRequest();
        request.setPassword("kaka0000");
        request.setEmail("test@yahoo.com");
        request.setAdresse("mahdia");
        request.setFirstName(null);
        request.setLastName("testlastname");
        request.setPhone("97979797");
        request.setCin("1111111");
        request.setRole("employee");
        request.setEmployeservice("plombier");
        String uri = "/api/authemployee/signup";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(request)))
                .andExpect(status().isBadRequest()).andReturn();
    }
    @Test
    public void registerEmployeeWithNullLastname() throws Exception {
        SignupRequest request=new SignupRequest();
        request.setPassword("kaka0000");
        request.setEmail("test@yahoo.com");
        request.setAdresse("mahdia");
        request.setFirstName("testname");
        request.setLastName(null);
        request.setPhone("97979797");
        request.setCin("1111111");
        request.setRole("employee");
        request.setEmployeservice("plombier");
        String uri = "/api/authemployee/signup";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(request)))
                .andExpect(status().isBadRequest()).andReturn();
    }
    @Test
    public void registerEmployeeWithEmptyPhone() throws Exception {
        SignupRequest request=new SignupRequest();
        request.setPassword("kaka0000");
        request.setEmail("test@yahoo.com");
        request.setAdresse("mahdia");
        request.setFirstName("testname");
        request.setLastName("testlastname");
        request.setPhone(null);
        request.setCin("1111111");
        request.setRole("employee");
        request.setEmployeservice("plombier");
        String uri = "/api/authemployee/signup";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(request)))
                .andExpect(status().isBadRequest()).andReturn();
    }
    @Test
    public void registerEmployeeWithEmptyCin() throws Exception {
        SignupRequest request=new SignupRequest();
        request.setPassword("kaka0000");
        request.setEmail("test@yahoo.com");
        request.setAdresse("mahdia");
        request.setFirstName("testname");
        request.setLastName("testlastname");
        request.setPhone("97979797");
        request.setCin(null);
        request.setRole("employee");
        request.setEmployeservice("plombier");
        String uri = "/api/authemployee/signup";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(request)))
                .andExpect(status().isBadRequest()).andReturn();
    }
    @Test
    public void registerEmployeeWithEmptyRole() throws Exception {
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
        String uri = "/api/authemployee/signup";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(request)))
                .andExpect(status().isBadRequest()).andReturn();
    }
    @Test
    public void registerEmployeeWithEmptyService() throws Exception {
        SignupRequest request=new SignupRequest();
        request.setPassword("kaka0000");
        request.setEmail("test@yahoo.com");
        request.setAdresse("mahdia");
        request.setFirstName("testname");
        request.setLastName("testlastname");
        request.setPhone("97979797");
        request.setCin("1111111");
        request.setRole("employee");
        request.setEmployeservice(null);
        String uri = "/api/authemployee/signup";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(request)))
                .andExpect(status().isBadRequest()).andReturn();
    }
    @Test
    public void registerEmployeeWithAllDataNull() throws Exception {
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
        String uri = "/api/authemployee/signup";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(request)))
                .andExpect(status().isBadRequest()).andReturn();
    }
    @Test
    public void registerEmployeeWithOnlyPasswordAndEmailNotNull() throws Exception {
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
        String uri = "/api/authemployee/signup";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(request)))
                .andExpect(status().isBadRequest()).andReturn();
    }
    @Test
    public void registerEmployeeWithOnlyPasswordNotNull() throws Exception {
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
        String uri = "/api/authemployee/signup";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(request)))
                .andExpect(status().isBadRequest()).andReturn();
    }
    @Test
    public void registerEmployeeWithOnlyEmailNotNull() throws Exception {
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
        String uri = "/api/authemployee/signup";
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
