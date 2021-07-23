import com.fasterxml.jackson.databind.ObjectMapper;

import com.hms.entity.UserEntity;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static junit.framework.TestCase.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
public class UserControllerTest extends AbstractTest{
    @Override
    @Before
    public void setUp() {
        super.setUp();
    }
    @Test
    public void getUserWithExistId() throws Exception {
        String uri = "/UserController/getUser";
        UserEntity userEntity = new UserEntity();
        userEntity.setId(35L);
        MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(userEntity)))
                .andExpect(status().isOk()).andReturn();

       String content = mvcResult.getResponse().getContentAsString();
        UserEntity user = super.mapFromJson(content, UserEntity.class);
        assertTrue(user.getId() != null);
    }

    @Test
    public void getUserWithIdZero() throws Exception {
        String uri = "/UserController/getUser";
        UserEntity userEntity = new UserEntity();
        userEntity.setId(0L);
        MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(userEntity)))
                .andExpect(status().isNotFound()).andReturn();
    }

    @Test
    public void getUserWithNegativeId() throws Exception {
        String uri = "/UserController/getUser";
        UserEntity userEntity = new UserEntity();
        userEntity.setId(-10L);
        MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(userEntity)))
                .andExpect(status().isNotFound()).andReturn();
    }
    @Test
    public void getUserWithIdOfAdmin() throws Exception {
        String uri = "/UserController/getUser";
        UserEntity userEntity = new UserEntity();
        userEntity.setId(1L);
        MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(userEntity)))
                .andExpect(status().isNotFound()).andReturn();
    }
    @Test
    public void getUserWithEmployeeId() throws Exception {
        String uri = "/UserController/getUser";
        UserEntity userEntity = new UserEntity();
        userEntity.setId(11L);
        MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(userEntity)))
                .andExpect(status().isNotFound()).andReturn();
    }

    @Test
    public void updateAllUserDataWithNoNullArgument() throws Exception {
        String uri = "/UserController/updateUser";
        UserEntity userEntity = new UserEntity();
        userEntity.setCin("1111111");
        userEntity.setAdresse("mahdia");
        userEntity.setEmail("test@test.tes");
        userEntity.setPhone("22444444");
        userEntity.setPassword("kaka0000");
        userEntity.setFirstName("testfirstname");
        userEntity.setLastName("testLastname");
        userEntity.setId(37L);
        MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(userEntity)))
                .andExpect(status().isOk()).andReturn();
    }
    @Test
    public void updateAllUserDataWithNullArgument() throws Exception {
        String uri = "/UserController/updateUser";
        UserEntity userEntity = new UserEntity();
        userEntity.setCin(null);
        userEntity.setAdresse(null);
        userEntity.setEmail(null);
        userEntity.setPhone(null);
        userEntity.setPassword(null);
        userEntity.setFirstName(null);
        userEntity.setLastName(null);
        userEntity.setId(37L);
        MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(userEntity)))
                .andExpect(status().isOk()).andReturn();
    }
    @Test
    public void updateAllUserDataWithNullIdAndNullDada() throws Exception {
        String uri = "/UserController/updateUser";
        UserEntity userEntity = new UserEntity();
        userEntity.setCin(null);
        userEntity.setAdresse(null);
        userEntity.setEmail(null);
        userEntity.setPhone(null);
        userEntity.setPassword(null);
        userEntity.setFirstName(null);
        userEntity.setLastName(null);
        userEntity.setId(0L);
        MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(userEntity)))
                .andExpect(status().isNotFound()).andReturn();
    }
    @Test
    public void updateAllUserDataWithNullIdAndNoNullDada() throws Exception {
        String uri = "/UserController/updateUser";
        UserEntity userEntity = new UserEntity();
        userEntity.setCin("54454");
        userEntity.setAdresse("hbjhbjhb");
        userEntity.setEmail("sdcs@sdcsc.com");
        userEntity.setPhone("979797979");
        userEntity.setPassword("dcdcdc");
        userEntity.setFirstName("testname");
        userEntity.setLastName("test lastname");
        userEntity.setId(0L);
        MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(userEntity)))
                .andExpect(status().isNotFound()).andReturn();
    }
    @Test
    public void updateUserCin() throws Exception {
        String uri = "/UserController/updateUser";
        UserEntity userEntity = new UserEntity();
        userEntity.setCin("1111111");
        userEntity.setId(37L);
        MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(userEntity)))
                .andExpect(status().isOk()).andReturn();
    }
    @Test
    public void updateUserWithNullCin() throws Exception {
        String uri = "/UserController/updateUser";
        UserEntity userEntity = new UserEntity();
        userEntity.setCin(null);
        userEntity.setId(37L);
        MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(userEntity)))
                .andExpect(status().isOk()).andReturn();
    }
    @Test
    public void updateUserLocation() throws Exception {
        String uri = "/UserController/updateUser";
        UserEntity userEntity = new UserEntity();
        userEntity.setAdresse("mahdia");
        userEntity.setId(37L);
        MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(userEntity)))
                .andExpect(status().isOk()).andReturn();
    }
    @Test
    public void updateUserWithNullLocation() throws Exception {
        String uri = "/UserController/updateUser";
        UserEntity userEntity = new UserEntity();
        userEntity.setAdresse(null);
        userEntity.setId(37L);
        MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(userEntity)))
                .andExpect(status().isOk()).andReturn();
    }
    @Test
    public void updateUserEmail() throws Exception {
        String uri = "/UserController/updateUser";
        UserEntity userEntity = new UserEntity();
        userEntity.setEmail("test@test.tes");
        userEntity.setId(37L);
        MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(userEntity)))
                .andExpect(status().isOk()).andReturn();
    }
    @Test
    public void updateUserWithNullEmail() throws Exception {
        String uri = "/UserController/updateUser";
        UserEntity userEntity = new UserEntity();
        userEntity.setEmail(null);
        userEntity.setId(37L);
        MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(userEntity)))
                .andExpect(status().isOk()).andReturn();
    }
    @Test
    public void updateUserPhone() throws Exception {
        String uri = "/UserController/updateUser";
        UserEntity userEntity = new UserEntity();
        userEntity.setPhone("22444444");

        userEntity.setId(37L);
        MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(userEntity)))
                .andExpect(status().isOk()).andReturn();
    }
    @Test
    public void updateUserWithNullPhone() throws Exception {
        String uri = "/UserController/updateUser";
        UserEntity userEntity = new UserEntity();
        userEntity.setPhone(null);

        userEntity.setId(37L);
        MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(userEntity)))
                .andExpect(status().isOk()).andReturn();
    }
    @Test
    public void updateUserPassword() throws Exception {
        String uri = "/UserController/updateUser";
        UserEntity userEntity = new UserEntity();
        userEntity.setPassword("kaka0000");
        userEntity.setId(37L);
        MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(userEntity)))
                .andExpect(status().isOk()).andReturn();
    }
    @Test
    public void updateUserwithNullPassword() throws Exception {
        String uri = "/UserController/updateUser";
        UserEntity userEntity = new UserEntity();
        userEntity.setPassword(null);
        userEntity.setId(37L);
        MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(userEntity)))
                .andExpect(status().isOk()).andReturn();
    }
    @Test
    public void updateUserFirstname() throws Exception {
        String uri = "/UserController/updateUser";
        UserEntity userEntity = new UserEntity();
        userEntity.setPassword("kaka0000");
        userEntity.setFirstName("testfirstname");
        userEntity.setId(37L);
        MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(userEntity)))
                .andExpect(status().isOk()).andReturn();
    }
    @Test
    public void updateUserWithNullFirstname() throws Exception {
        String uri = "/UserController/updateUser";
        UserEntity userEntity = new UserEntity();
        userEntity.setPassword("kaka0000");
        userEntity.setFirstName(null);
        userEntity.setId(37L);
        MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(userEntity)))
                .andExpect(status().isOk()).andReturn();
    }
    @Test
    public void updateUserLastName() throws Exception {
        String uri = "/UserController/updateUser";
        UserEntity userEntity = new UserEntity();
        userEntity.setPassword("kaka0000");
        userEntity.setLastName("testLastname");
        userEntity.setId(37L);
        MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(userEntity)))
                .andExpect(status().isOk()).andReturn();
    }
    @Test
    public void updateUserLastNameAndFirstname() throws Exception {
        String uri = "/UserController/updateUser";
        UserEntity userEntity = new UserEntity();
        userEntity.setPassword("kaka0000");
        userEntity.setLastName("testLastname");
        userEntity.setLastName("testLast name");
        userEntity.setId(37L);
        MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(userEntity)))
                .andExpect(status().isOk()).andReturn();
    }
    @Test
    public void updateUserLastNameAndFirstnameAndpassWord() throws Exception {
        String uri = "/UserController/updateUser";
        UserEntity userEntity = new UserEntity();
        userEntity.setPassword("kaka0000");
        userEntity.setLastName("testLastname");
        userEntity.setLastName("testLast name");
        userEntity.setId(37L);
        MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(userEntity)))
                .andExpect(status().isOk()).andReturn();
    }
    @Test
    public void updateUserLastNameAndFirstnameAndpassWordAndCin() throws Exception {
        String uri = "/UserController/updateUser";
        UserEntity userEntity = new UserEntity();
        userEntity.setPassword("kaka0000");
        userEntity.setLastName("testLastname");
        userEntity.setLastName("testLast name");
        userEntity.setCin("11122233");
        userEntity.setId(37L);
        MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(userEntity)))
                .andExpect(status().isOk()).andReturn();
    }
    @Test
    public void updateUserLastNameAndFirstnameAndpassWordAndCinAndEmail() throws Exception {
        String uri = "/UserController/updateUser";
        UserEntity userEntity = new UserEntity();
        userEntity.setPassword("kaka0000");
        userEntity.setLastName("testLastname");
        userEntity.setLastName("testLast name");
        userEntity.setCin("11122233");
        userEntity.setEmail("test@gmail.com");
        userEntity.setId(37L);
        MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(userEntity)))
                .andExpect(status().isOk()).andReturn();
    }
    @Test
    public void updateUserLastNameAndFirstnameAndpassWordAndCinAndEmailAndAdressAndPhone() throws Exception {
        String uri = "/UserController/updateUser";
        UserEntity userEntity = new UserEntity();
        userEntity.setPassword("kaka0000");
        userEntity.setLastName("testLastname");
        userEntity.setLastName("testLast name");
        userEntity.setCin("11122233");
        userEntity.setEmail("test@gmail.com");
        userEntity.setAdresse("test");
        userEntity.setPhone("974475555");
        userEntity.setId(37L);
        MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(userEntity)))
                .andExpect(status().isOk()).andReturn();
    }

    @Test
    public void updateUserWithNullLastName() throws Exception {
        String uri = "/UserController/updateUser";
        UserEntity userEntity = new UserEntity();
        userEntity.setPassword("kaka0000");
        userEntity.setLastName(null);
        userEntity.setId(37L);
        MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(userEntity)))
                .andExpect(status().isOk()).andReturn();
    }
    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
