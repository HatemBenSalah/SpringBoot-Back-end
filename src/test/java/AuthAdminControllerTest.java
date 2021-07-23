import com.fasterxml.jackson.databind.ObjectMapper;
import com.hms.request.LoginRequest;
import com.hms.request.SignupRequest;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
public class AuthAdminControllerTest  extends AbstractTest{
    @Override
    @Before
    public void setUp() {
        super.setUp();
    }
    @Test
    public void authentificateAdminWithValidEmailAndPassword() throws Exception {
        LoginRequest request=new LoginRequest();
        request.setEmail("hms@gmail.com");
        request.setPassword("kaka0000");
        String uri = "/api/authAdmin/signin";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(request)))
                .andExpect(status().isOk()).andReturn();
    }

    @Test
    public void authentificateAdminWithValidEmailAndInvalidPassword() throws Exception {
        LoginRequest request=new LoginRequest();
        request.setEmail("hms@gmail.com");
        request.setPassword(null);
        String uri = "/api/authAdmin/signin";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(request)))
                .andExpect(status().isBadRequest()).andReturn();
    }

    @Test
    public void authentificateAdminInValidEmailAndValidPassword() throws Exception {
        LoginRequest request=new LoginRequest();
        request.setEmail(null);
        request.setPassword("kaka0000");
        String uri = "/api/authAdmin/signin";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(request)))
                .andExpect(status().isBadRequest()).andReturn();
    }
    @Test
    public void authentificateAdminInValidEmailAndInValidPassword() throws Exception {
        LoginRequest request=new LoginRequest();
        request.setEmail(null);
        request.setPassword(null);
        String uri = "/api/authAdmin/signin";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(request)))
                .andExpect(status().isBadRequest()).andReturn();
    }
    @Test
    public void authentificateAdminWithEmptyEmailAndEmptyPassword() throws Exception {
        LoginRequest request=new LoginRequest();
        request.setEmail(null);
        request.setPassword(null);
        String uri = "/api/authAdmin/signin";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(request)))
                .andExpect(status().isBadRequest()).andReturn();
    }

    @Test
    public void registerAdminWithEmptyAllData() throws Exception {
        SignupRequest request=new SignupRequest();

        String uri = "/api/authAdmin/signup";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(request)))
                .andExpect(status().isBadRequest()).andReturn();
    }
    @Test
    public void registerAdminWithAllData() throws Exception {
        SignupRequest request=new SignupRequest();
        request.setPassword("kaka0000");
        request.setEmail("test@yahoo.com");
        request.setAdresse("mahdia");
        request.setFirstName("testname");
        request.setLastName("testlastname");
        request.setPhone("97979797");
        request.setCin("1111111");
        request.setRole("admin");
        request.setEmployeservice("plombier");
        String uri = "/api/authAdmin/signup";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(request)))
                .andExpect(status().isBadRequest()).andReturn();
    }
    @Test
    public void registerAdminWithEmptyPassword() throws Exception {
        SignupRequest request=new SignupRequest();
        request.setPassword(null);
        request.setEmail("test@yahoo.com");
        request.setAdresse("mahdia");
        request.setFirstName("testname");
        request.setLastName("testlastname");
        request.setPhone("97979797");
        request.setCin("1111111");
        request.setRole("admin");
        request.setEmployeservice("plombier");
        String uri = "/api/authAdmin/signup";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(request)))
                .andExpect(status().isBadRequest()).andReturn();
    }
    @Test
    public void registerAdminWithEmptyEmail() throws Exception {
        SignupRequest request=new SignupRequest();
        request.setPassword("kaka0000");
        request.setEmail(null);
        request.setAdresse("mahdia");
        request.setFirstName("testname");
        request.setLastName("testlastname");
        request.setPhone("97979797");
        request.setCin("1111111");
        request.setRole("admin");
        request.setEmployeservice("plombier");
        String uri = "/api/authAdmin/signup";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(request)))
                .andExpect(status().isBadRequest()).andReturn();
    }
    @Test
    public void registerAdminEmptyLocation() throws Exception {
        SignupRequest request=new SignupRequest();
        request.setPassword("kaka0000");
        request.setEmail("test@yahoo.com");
        request.setAdresse(null);
        request.setFirstName("testname");
        request.setLastName("testlastname");
        request.setPhone("97979797");
        request.setCin("1111111");
        request.setRole("admin");
        request.setEmployeservice("plombier");
        String uri = "/api/authAdmin/signup";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(request)))
                .andExpect(status().isBadRequest()).andReturn();
    }
    @Test
    public void registerAdminWithEmptyFirsname() throws Exception {
        SignupRequest request=new SignupRequest();
        request.setPassword("kaka0000");
        request.setEmail("test@yahoo.com");
        request.setAdresse("mahdia");
        request.setFirstName(null);
        request.setLastName("testlastname");
        request.setPhone("97979797");
        request.setCin("1111111");
        request.setRole("admin");
        request.setEmployeservice("plombier");
        String uri = "/api/authAdmin/signup";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(request)))
                .andExpect(status().isBadRequest()).andReturn();
    }
    @Test
    public void registerAdminWithNullLastname() throws Exception {
        SignupRequest request=new SignupRequest();
        request.setPassword("kaka0000");
        request.setEmail("test@yahoo.com");
        request.setAdresse("mahdia");
        request.setFirstName("testname");
        request.setLastName(null);
        request.setPhone("97979797");
        request.setCin("1111111");
        request.setRole("admin");
        request.setEmployeservice("plombier");
        String uri = "/api/authAdmin/signup";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(request)))
                .andExpect(status().isBadRequest()).andReturn();
    }
    @Test
    public void registerAdminWithEmptyPhone() throws Exception {
        SignupRequest request=new SignupRequest();
        request.setPassword("kaka0000");
        request.setEmail("test@yahoo.com");
        request.setAdresse("mahdia");
        request.setFirstName("testname");
        request.setLastName("testlastname");
        request.setPhone(null);
        request.setCin("1111111");
        request.setRole("admin");
        request.setEmployeservice("plombier");
        String uri = "/api/authAdmin/signup";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(request)))
                .andExpect(status().isBadRequest()).andReturn();
    }
    @Test
    public void registerAdminWithEmptyCin() throws Exception {
        SignupRequest request=new SignupRequest();
        request.setPassword("kaka0000");
        request.setEmail("test@yahoo.com");
        request.setAdresse("mahdia");
        request.setFirstName("testname");
        request.setLastName("testlastname");
        request.setPhone("97979797");
        request.setCin(null);
        request.setRole("admin");
        request.setEmployeservice("plombier");
        String uri = "/api/authAdmin/signup";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(request)))
                .andExpect(status().isBadRequest()).andReturn();
    }
    @Test
    public void registerAdminWithEmptyRole() throws Exception {
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
        String uri = "/api/authAdmin/signup";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(request)))
                .andExpect(status().isBadRequest()).andReturn();
    }
    @Test
    public void registerAdminWithEmptyService() throws Exception {
        SignupRequest request=new SignupRequest();
        request.setPassword("kaka0000");
        request.setEmail("test@yahoo.com");
        request.setAdresse("mahdia");
        request.setFirstName("testname");
        request.setLastName("testlastname");
        request.setPhone("97979797");
        request.setCin("1111111");
        request.setRole("admin");
        request.setEmployeservice(null);
        String uri = "/api/authAdmin/signup";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(request)))
                .andExpect(status().isBadRequest()).andReturn();
    }
    @Test
    public void registerAdminWithAllDataNull() throws Exception {
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
        String uri = "/api/authAdmin/signup";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(request)))
                .andExpect(status().isBadRequest()).andReturn();
    }
    @Test
    public void registerAdminWithOnlyPasswordAndEmailNotNull() throws Exception {
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
        String uri = "/api/authAdmin/signup";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(request)))
                .andExpect(status().isBadRequest()).andReturn();
    }
    @Test
    public void registerAdminWithOnlyPasswordNotNull() throws Exception {
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
        String uri = "/api/authAdmin/signup";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(request)))
                .andExpect(status().isBadRequest()).andReturn();
    }
    @Test
    public void registerAdminWithOnlyEmailNotNull() throws Exception {
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
        String uri = "/api/authAdmin/signup";
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
