import com.fasterxml.jackson.databind.ObjectMapper;
import com.hms.entity.EmployeeEntity;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
public class EmployeeControllerTest extends AbstractTest {
    @Override
    @Before
    public void setUp() {
        super.setUp();
    }
    @Test
    public void getAllEmployeeList() throws Exception {
        String uri = "/EmployeeController/getEmployee";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        EmployeeEntity[] employeeEntities = super.mapFromJson(content, EmployeeEntity[].class);
        assertTrue(employeeEntities.length > 0);
    }
    @Test
    public void getEmployeeByExistEmail() throws Exception {
        String email="employee2@gmail.com";
        String uri = "/EmployeeController/getEmployeeByEmail/"+email;
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
       String exite = mvcResult.getResponse().getContentAsString();
        assertTrue(exite.equals("false"));
    }
    @Test
    public void getEmployeeByInExistEmail() throws Exception {
        String email="inexisteemail@gmail.com";
        String uri = "/EmployeeController/getEmployeeByEmail/"+email;
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String exite = mvcResult.getResponse().getContentAsString();
        assertTrue(exite.equals("false"));
    }
    @Test
    public void getEmployeeByInValidEmail() throws Exception {
        String email="inexisteemailgmailcom";
        String uri = "/EmployeeController/getEmployeeByEmail/"+email;
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String exite = mvcResult.getResponse().getContentAsString();
        assertTrue(exite.equals("false"));
    }
    @Test
    public void getEmployeeByEmailofClient() throws Exception {
        String email="cilent@gmail.com";
        String uri = "/EmployeeController/getEmployeeByEmail/"+email;
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String exite = mvcResult.getResponse().getContentAsString();
        assertTrue(exite.equals("false"));
    }
    @Test
    public void getEmployeeByEmailofAdmin() throws Exception {
        String email="hms@gmail.com";
        String uri = "/EmployeeController/getEmployeeByEmail/"+email;
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String exite = mvcResult.getResponse().getContentAsString();
        assertTrue(exite.equals("false"));
    }

    @Test
    public void getEmployeeByValidID() throws Exception {
        Long id =31L;
        String uri = "/EmployeeController/employees/"+id;
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
       String employee = mvcResult.getResponse().getContentAsString();


    }
    @Test
    public void getEmployeeByInvValidId() throws Exception {
        Long id =999L;
        String uri = "/EmployeeController/employees/"+id;
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(404, status);
        String employee = mvcResult.getResponse().getContentAsString();


    }
    @Test
    public void getEmployeeByNegativeValidId() throws Exception {
        Long id =-999L;
        String uri = "/EmployeeController/employees/"+id;
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(404, status);
        String employee = mvcResult.getResponse().getContentAsString();


    }
    @Test
    public void getEmployeeByPositveAndInValidId() throws Exception {
        Long id =12121L;
        String uri = "/EmployeeController/employees/"+id;
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(404, status);
        String employee = mvcResult.getResponse().getContentAsString();
    }
    @Test
    public void getEmployeeByZeroId() throws Exception {
        Long id =0L;
        String uri = "/EmployeeController/employees/"+id;
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(404, status);
        String employee = mvcResult.getResponse().getContentAsString();
    }
    @Test
    public void getEmployeeByIdOfClient() throws Exception {
        Long id =3005L;
        String uri = "/EmployeeController/employees/"+id;
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(404, status);
        String employee = mvcResult.getResponse().getContentAsString();
    }
    @Test
    public void getEmployeeByIdOfAdmin() throws Exception {
        Long id =1L;
        String uri = "/EmployeeController/employees/"+id;
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(404, status);
        String employee = mvcResult.getResponse().getContentAsString();
    }
    @Test
    public void getEmployeeByIdOfCommand() throws Exception {
        Long id =343L;
        String uri = "/EmployeeController/employees/"+id;
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(404, status);
        String employee = mvcResult.getResponse().getContentAsString();
    }

    @Test
    public void getEmployeeByIdOfClaim() throws Exception {
        Long id =99999L;
        String uri = "/EmployeeController/employees/"+id;
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(404, status);
        String employee = mvcResult.getResponse().getContentAsString();
    }

    @Test
    public void createEmptyEmployee() throws Exception {
        EmployeeEntity employeeEntity = new EmployeeEntity();

        String uri = "/EmployeeController/createEmployee";
        MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(employeeEntity)))
                .andExpect(status().isOk()).andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        EmployeeEntity employee = super.mapFromJson(content, EmployeeEntity.class);
        assertTrue(employee.getId() != null);

    }
    @Test
    public void createEmployeeWithAllData() throws Exception {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setAdresse("sfax");
        employeeEntity.setPhone("97447666");
        employeeEntity.setEmail("employee4@jmail.com");
        employeeEntity.setPassword("$2a$10$TrZNKlMTUy3TowLNjBYNNu6.2TUwYpM.WfFiF9QY.AonPf3bqTO4u");
        employeeEntity.setFirstName("hatem");
        employeeEntity.setLastName("khazri");
        employeeEntity.setCin("11105449");
        employeeEntity.setRoles("employee");
        employeeEntity.setEmployeservice("Plomberie");
        String uri = "/EmployeeController/createEmployee";
        MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(employeeEntity)))
                .andExpect(status().isOk()).andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        EmployeeEntity employee = super.mapFromJson(content, EmployeeEntity.class);
        assertTrue(employee.getId() != null);
    }
    @Test
    public void createEmployeeWithoutadresse() throws Exception {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setPhone("97447666");
        employeeEntity.setEmail("employee4@jmail.com");
        employeeEntity.setPassword("$2a$10$TrZNKlMTUy3TowLNjBYNNu6.2TUwYpM.WfFiF9QY.AonPf3bqTO4u");
        employeeEntity.setFirstName("hatem");
        employeeEntity.setLastName("khazri");
        employeeEntity.setCin("11105449");
        employeeEntity.setRoles("employee");
        employeeEntity.setEmployeservice("Plomberie");

        String uri = "/EmployeeController/createEmployee";
        MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(employeeEntity)))
                .andExpect(status().isOk()).andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        EmployeeEntity employee = super.mapFromJson(content, EmployeeEntity.class);
        assertTrue(employee.getId() != null);
    }
    @Test
    public void createEmployeeWithoutPhone() throws Exception {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setAdresse("sfax");
        employeeEntity.setEmail("employee4@jmail.com");
        employeeEntity.setPassword("$2a$10$TrZNKlMTUy3TowLNjBYNNu6.2TUwYpM.WfFiF9QY.AonPf3bqTO4u");
        employeeEntity.setFirstName("hatem");
        employeeEntity.setLastName("khazri");
        employeeEntity.setCin("11105449");
        employeeEntity.setRoles("employee");
        employeeEntity.setEmployeservice("Plomberie");
        String uri = "/EmployeeController/createEmployee";
        MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(employeeEntity)))
                .andExpect(status().isOk()).andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        EmployeeEntity employee = super.mapFromJson(content, EmployeeEntity.class);
        assertTrue(employee.getId() != null);

    }
    @Test
    public void createEmployeeWithoutemail() throws Exception {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setAdresse("sfax");
        employeeEntity.setPhone("97447666");
        employeeEntity.setPassword("$2a$10$TrZNKlMTUy3TowLNjBYNNu6.2TUwYpM.WfFiF9QY.AonPf3bqTO4u");
        employeeEntity.setFirstName("hatem");
        employeeEntity.setLastName("khazri");
        employeeEntity.setCin("11105449");
        employeeEntity.setRoles("employee");
        employeeEntity.setEmployeservice("Plomberie");
        String uri = "/EmployeeController/createEmployee";
        MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(employeeEntity)))
                .andExpect(status().isOk()).andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        EmployeeEntity employee = super.mapFromJson(content, EmployeeEntity.class);
        assertTrue(employee.getId() != null);
    }
    @Test
    public void createEmployeeWithoutPassword() throws Exception {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setAdresse("sfax");
        employeeEntity.setPhone("97447666");
        employeeEntity.setEmail("employee4@jmail.com");
        employeeEntity.setFirstName("hatem");
        employeeEntity.setLastName("khazri");
        employeeEntity.setCin("11105449");
        employeeEntity.setRoles("employee");
        employeeEntity.setEmployeservice("Plomberie");

        String uri = "/EmployeeController/createEmployee";
        MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(employeeEntity)))
                .andExpect(status().isOk()).andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        EmployeeEntity employee = super.mapFromJson(content, EmployeeEntity.class);
        assertTrue(employee.getId() != null);
    }
    @Test
    public void createEmployeeWithoutFirstname() throws Exception {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setAdresse("sfax");
        employeeEntity.setPhone("97447666");
        employeeEntity.setEmail("employee4@jmail.com");
        employeeEntity.setPassword("$2a$10$TrZNKlMTUy3TowLNjBYNNu6.2TUwYpM.WfFiF9QY.AonPf3bqTO4u");
        employeeEntity.setLastName("khazri");
        employeeEntity.setCin("11105449");
        employeeEntity.setRoles("employee");
        employeeEntity.setEmployeservice("Plomberie");
        String uri = "/EmployeeController/createEmployee";
        MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(employeeEntity)))
                .andExpect(status().isOk()).andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        EmployeeEntity employee = super.mapFromJson(content, EmployeeEntity.class);
        assertTrue(employee.getId() != null);
    }
    @Test
    public void createEmployeeWithoutLastName() throws Exception {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setAdresse("sfax");
        employeeEntity.setPhone("97447666");
        employeeEntity.setEmail("employee4@jmail.com");
        employeeEntity.setPassword("$2a$10$TrZNKlMTUy3TowLNjBYNNu6.2TUwYpM.WfFiF9QY.AonPf3bqTO4u");
        employeeEntity.setFirstName("hatem");
        employeeEntity.setCin("11105449");
        employeeEntity.setRoles("employee");
        employeeEntity.setEmployeservice("Plomberie");
        String uri = "/EmployeeController/createEmployee";
        MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(employeeEntity)))
                .andExpect(status().isOk()).andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        EmployeeEntity employee = super.mapFromJson(content, EmployeeEntity.class);
        assertTrue(employee.getId() != null);
    }
    @Test
    public void createEmployeeWithoutCin() throws Exception {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setAdresse("sfax");
        employeeEntity.setPhone("97447666");
        employeeEntity.setEmail("employee4@jmail.com");
        employeeEntity.setPassword("$2a$10$TrZNKlMTUy3TowLNjBYNNu6.2TUwYpM.WfFiF9QY.AonPf3bqTO4u");
        employeeEntity.setFirstName("hatem");
        employeeEntity.setLastName("khazri");
        employeeEntity.setRoles("employee");
        employeeEntity.setEmployeservice("Plomberie");
        String uri = "/EmployeeController/createEmployee";
        MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(employeeEntity)))
                .andExpect(status().isOk()).andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        EmployeeEntity employee = super.mapFromJson(content, EmployeeEntity.class);
        assertTrue(employee.getId() != null);
    }
    @Test
    public void createEmployeeWithoutRoles() throws Exception {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setAdresse("sfax");
        employeeEntity.setPhone("97447666");
        employeeEntity.setEmail("employee4@jmail.com");
        employeeEntity.setPassword("$2a$10$TrZNKlMTUy3TowLNjBYNNu6.2TUwYpM.WfFiF9QY.AonPf3bqTO4u");
        employeeEntity.setFirstName("hatem");
        employeeEntity.setLastName("khazri");
        employeeEntity.setCin("11105449");
        employeeEntity.setEmployeservice("Plomberie");
        String uri = "/EmployeeController/createEmployee";
        MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(employeeEntity)))
                .andExpect(status().isOk()).andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        EmployeeEntity employee = super.mapFromJson(content, EmployeeEntity.class);
        assertTrue(employee.getId() != null);
    }
    @Test
    public void createEmployeeWithoutEmployeeService() throws Exception {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setAdresse("sfax");
        employeeEntity.setPhone("97447666");
        employeeEntity.setEmail("employee4@jmail.com");
        employeeEntity.setPassword("$2a$10$TrZNKlMTUy3TowLNjBYNNu6.2TUwYpM.WfFiF9QY.AonPf3bqTO4u");
        employeeEntity.setFirstName("hatem");
        employeeEntity.setLastName("khazri");
        employeeEntity.setCin("11105449");
        employeeEntity.setRoles("employee");
        String uri = "/EmployeeController/createEmployee";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(employeeEntity)))
                .andExpect(status().isOk()).andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        EmployeeEntity employee = super.mapFromJson(content, EmployeeEntity.class);
        assertTrue(employee.getId() != null);
    }
    @Test
    public void createEmployeeWithoutAnyParametre() throws Exception {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        String uri = "/EmployeeController/createEmployee";
        MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(employeeEntity)))
                .andExpect(status().isOk()).andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        EmployeeEntity employee = super.mapFromJson(content, EmployeeEntity.class);
        assertTrue(employee.getId() != null);
    }
    @Test
    public void UpadteEmployeeCin() throws Exception {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setId(33L);
        employeeEntity.setPassword("kaka0000");
        employeeEntity.setCin("11105449");
        String uri = "/EmployeeController/updateEmployee";
        MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(employeeEntity)))
                .andExpect(status().isOk()).andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        assertTrue(content.equals("true"));
    }
    @Test
    public void UpadteEmployeeLocation() throws Exception {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setPassword("kaka0000");
        employeeEntity.setId(33L);
        employeeEntity.setAdresse("Mahdia");
        String uri = "/EmployeeController/updateEmployee";
        MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(employeeEntity)))
                .andExpect(status().isOk()).andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        assertTrue(content.equals("true"));
    }
    @Test
    public void UpadteEmployeeEmail() throws Exception {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setPassword("kaka0000");
        employeeEntity.setId(33L);
        employeeEntity.setEmail("employee2@gmail.com");
        String uri = "/EmployeeController/updateEmployee";
        MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(employeeEntity)))
                .andExpect(status().isOk()).andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        assertTrue(content.equals("true"));
    }
    @Test
    public void UpadteEmployeeFirsName() throws Exception {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setPassword("kaka0000");
        employeeEntity.setId(33L);
        employeeEntity.setFirstName("firstnametest");
        String uri = "/EmployeeController/updateEmployee";
        MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(employeeEntity)))
                .andExpect(status().isOk()).andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        assertTrue(content.equals("true"));
    }
    @Test
    public void UpadteEmployeeLastName() throws Exception {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setPassword("kaka0000");
        employeeEntity.setId(33L);
        employeeEntity.setLastName("lastnametest");
        String uri = "/EmployeeController/updateEmployee";
        MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(employeeEntity)))
                .andExpect(status().isOk()).andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        assertTrue(content.equals("true"));
    }
    @Test
    public void UpadteEmployeePassword() throws Exception {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setPassword("kaka0000");
        employeeEntity.setId(33L);
        employeeEntity.setPassword("kaka0000");
        String uri = "/EmployeeController/updateEmployee";
        MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(employeeEntity)))
                .andExpect(status().isOk()).andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        assertTrue(content.equals("true"));
    }
    @Test
    public void UpadteEmployeeService() throws Exception {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setPassword("kaka0000");
        employeeEntity.setId(33L);
        employeeEntity.setEmployeservice("Plomberie");
        String uri = "/EmployeeController/updateEmployee";
        MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(employeeEntity)))
                .andExpect(status().isOk()).andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        assertTrue(content.equals("true"));
    }
    @Test
    public void UpadteEmployeePhone() throws Exception {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setPassword("kaka0000");
        employeeEntity.setId(33L);
        employeeEntity.setPhone("97447666");
        String uri = "/EmployeeController/updateEmployee";
        MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(employeeEntity)))
                .andExpect(status().isOk()).andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        assertTrue(content.equals("true"));
    }
    @Test
    public void UpadteEmployeeRoles() throws Exception {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setId(33L);
        employeeEntity.setPassword("kaka0000");
        employeeEntity.setRoles("employee");
        String uri = "/EmployeeController/updateEmployee";
        MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(employeeEntity)))
                .andExpect(status().isOk()).andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        assertTrue(content.equals("true"));
    }


    @Test
    public void UpadteAllEmployeeParametre() throws Exception {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setId(33L);
        employeeEntity.setCin("11105449");
        employeeEntity.setAdresse("Mahdia");
        employeeEntity.setEmail("employee2@gmail.com");
        employeeEntity.setFirstName("firstnametest");
        employeeEntity.setLastName("lastnametest");
        employeeEntity.setPassword("kaka0000");
        employeeEntity.setEmployeservice("Plomberie");
        employeeEntity.setPhone("97447666");
        employeeEntity.setRoles("employee");
        String uri = "/EmployeeController/updateEmployee";
        MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(employeeEntity)))
                .andExpect(status().isOk()).andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        assertTrue(content.equals("true"));
    }

    @Test
    public void deleteEmployeeByID() throws Exception {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        String uricreate = "/EmployeeController/createEmployee";
        MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.post(uricreate).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(employeeEntity)))
                .andExpect(status().isOk()).andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        EmployeeEntity Employee = super.mapFromJson(content, EmployeeEntity.class);
        String uri = "/EmployeeController/deleteEmployee";
        MvcResult mvcResultDetete=mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(Employee.getId())))
                .andExpect(status().isOk()).andReturn();

    }

    @Test
    public void deleteInexisteEmployeeByID() throws Exception {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        String uri = "/EmployeeController/deleteEmployee";
        MvcResult mvcResultDetete=mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(employeeEntity.getId())))
                .andExpect(status().isBadRequest()).andReturn();
    }

    @Test
    public void deleteEmployeeByNegativeID() throws Exception {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setId(-1L);
        String uri = "/EmployeeController/deleteEmployee";
        MvcResult mvcResultDetete=mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(employeeEntity.getId())))
                .andExpect(status().isNotFound()).andReturn();

    }
    @Test
    public void deleteEmployeeByZeroID() throws Exception {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setId(0L);
        String uri = "/EmployeeController/deleteEmployee";
        MvcResult mvcResultDetete=mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(employeeEntity.getId())))
                .andExpect(status().isNotFound()).andReturn();

    }

    @Test
    public void deleteEmployeeByPositveAndIexisteID() throws Exception {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setId(1L);
        String uri = "/EmployeeController/deleteEmployee";
        MvcResult mvcResultDetete=mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(employeeEntity.getId())))
                .andExpect(status().isNotFound()).andReturn();

    }

    @Test
    public void deleteEmployeeByClientId() throws Exception {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setId(2L);
        String uri = "/EmployeeController/deleteEmployee";
        MvcResult mvcResultDetete=mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(employeeEntity.getId())))
                .andExpect(status().isNotFound()).andReturn();

    }
    @Test
    public void deleteEmployeeByIdOfAdmin() throws Exception {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setId(2L);
        String uri = "/EmployeeController/deleteEmployee";
        MvcResult mvcResultDetete=mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(employeeEntity.getId())))
                .andExpect(status().isNotFound()).andReturn();

    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
