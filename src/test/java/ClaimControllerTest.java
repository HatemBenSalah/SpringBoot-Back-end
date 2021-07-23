import com.fasterxml.jackson.databind.ObjectMapper;
import com.hms.entity.ClaimEntity;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class ClaimControllerTest extends AbstractTest{
    @Override
    @Before
    public void setUp() {
        super.setUp();
    }

    @Test
    public void getAllClaimList() throws Exception {
        String uri = "/ClaimController/getallClaim";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        ClaimEntity[] Claim = super.mapFromJson(content, ClaimEntity[].class);
        assertTrue(Claim.length > 0);
    }
    @Test
    public void getAllClaimByExistUserId() throws Exception {
        int id=35;

        String uri = "/ClaimController/getClaim/"+id;
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        ClaimEntity[] Claim = super.mapFromJson(content, ClaimEntity[].class);
        assertTrue(Claim.length > 0);
    }

    @Test
    public void getClaimByInExistUserId() throws Exception {
        int id=1000;

        String uri = "/ClaimController/getClaim/"+id;
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        ClaimEntity[] Claim = super.mapFromJson(content, ClaimEntity[].class);
        assertTrue(Claim.length == 0);
    }

    @Test
    public void getClaimByInExistPositveUserId() throws Exception {
        int id=1000;

        String uri = "/ClaimController/getClaim/"+id;
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        ClaimEntity[] Claim = super.mapFromJson(content, ClaimEntity[].class);
        assertTrue(Claim.length == 0);
    }
    @Test
    public void getClaimByInExisNegativetUserId() throws Exception {
        int id=-1000;

        String uri = "/ClaimController/getClaim/"+id;
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        ClaimEntity[] Claim = super.mapFromJson(content, ClaimEntity[].class);
        assertTrue(Claim.length == 0);
    }

    @Test
    public void getClaimByNullUserId() throws Exception {
        int id=0;

        String uri = "/ClaimController/getClaim/"+id;
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        ClaimEntity[] Claim = super.mapFromJson(content, ClaimEntity[].class);
        assertTrue(Claim.length == 0);
    }

    @Test
    public void getClaimByPositiveAndInexisteUserId() throws Exception {
        int id=99999;

        String uri = "/ClaimController/getClaim/"+id;
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        ClaimEntity[] Claim = super.mapFromJson(content, ClaimEntity[].class);
        assertTrue(Claim.length == 0);
    }
    @Test
    public void getClaimByPositiveAndExisteUserId() throws Exception {
        int id=35;

        String uri = "/ClaimController/getClaim/"+id;
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        ClaimEntity[] Claim = super.mapFromJson(content, ClaimEntity[].class);
        assertTrue(Claim.length >0);
    }
    @Test
    public void getClaimByEmployeeNullArgimentService() throws Exception {
        String service=null;

        String uri = "/ClaimController/getClaimByEmployeeService/"+service;
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        ClaimEntity[] Claim = super.mapFromJson(content, ClaimEntity[].class);
        assertTrue(Claim.length == 0);
    }

    @Test
    public void getClaimByEmployeeInexisteArgimentService() throws Exception {
        String service="testeur";

        String uri = "/ClaimController/getClaimByEmployeeService/"+service;
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        ClaimEntity[] Claim = super.mapFromJson(content, ClaimEntity[].class);
        assertTrue(Claim.length == 0);
    }
    @Test
    public void getClaimByEmployeeByPlombierArgimentService() throws Exception {
        String service="Plomberie";

        String uri = "/ClaimController/getClaimByEmployeeService/"+service;
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        ClaimEntity[] Claim = super.mapFromJson(content, ClaimEntity[].class);
        assertTrue(Claim.length > 0);
    }

    @Test
    public void getClaimByEmployeeByJardinierArgimentService() throws Exception {
        String service="Jardinage";

        String uri = "/ClaimController/getClaimByEmployeeService/"+service;
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        ClaimEntity[] Claim = super.mapFromJson(content, ClaimEntity[].class);
        assertTrue(Claim.length > 0);
    }
    @Test
    public void getClaimByEmployeeByElectriciteArgimentService() throws Exception {
        String service="Electricite";

        String uri = "/ClaimController/getClaimByEmployeeService/"+service;
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        ClaimEntity[] Claim = super.mapFromJson(content, ClaimEntity[].class);
        assertTrue(Claim.length > 0);
    }
    @Test
    public void getClaimByEmployeeByCharpenterieArgimentService() throws Exception {
        String service="Charpenterie";

        String uri = "/ClaimController/getClaimByEmployeeService/"+service;
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        ClaimEntity[] Claim = super.mapFromJson(content, ClaimEntity[].class);
        assertTrue(Claim.length > 0);
    }
    @Test
    public void getClaimByEmployeeByMasonryArgimentService() throws Exception {
        String service="General masonry";

        String uri = "/ClaimController/getClaimByEmployeeService/"+service;
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        ClaimEntity[] Claim = super.mapFromJson(content, ClaimEntity[].class);
        assertTrue(Claim.length > 0);
    }
    @Test
    public void getClaimByEmployeeByPentureArgimentService() throws Exception {
        String service="Penture";

        String uri = "/ClaimController/getClaimByEmployeeService/"+service;
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        ClaimEntity[] Claim = super.mapFromJson(content, ClaimEntity[].class);
        assertTrue(Claim.length > 0);
    }
    @Test
    public void getClaimByEmployeeByParabolisteArgimentService() throws Exception {
        String service="Paraboliste";

        String uri = "/ClaimController/getClaimByEmployeeService/"+service;
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        ClaimEntity[] Claim = super.mapFromJson(content, ClaimEntity[].class);
        assertTrue(Claim.length > 0);
    }

    @Test
    public void getClaimByEmployeeByEspaceArgimentService() throws Exception {
        String service=" ";

        String uri = "/ClaimController/getClaimByEmployeeService/"+service;
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        ClaimEntity[] Claim = super.mapFromJson(content, ClaimEntity[].class);
        assertTrue(Claim.length == 0);
    }
    @Test
    public void getClaimByEmployeeByNumberArgimentService() throws Exception {
        String service="1";

        String uri = "/ClaimController/getClaimByEmployeeService/"+service;
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        ClaimEntity[] Claim = super.mapFromJson(content, ClaimEntity[].class);
        assertTrue(Claim.length == 0);
    }
    @Test
    public void createEmptyClaim() throws Exception {
        ClaimEntity claimEntity = new ClaimEntity();

        String uri = "/ClaimController/createClaim";
        MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(claimEntity)))
                .andExpect(status().isOk()).andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        ClaimEntity Claim = super.mapFromJson(content, ClaimEntity.class);
        assertTrue(Claim.getId() != null);

    }
    @Test
    public void createClaimWithEmptyState() throws Exception {
        ClaimEntity claimEntity = new ClaimEntity();
        claimEntity.setDatedemmande("20-05-2021");
        claimEntity.setAdresse("Mahdia");
        claimEntity.setEmail("testunitaire@gmail.com");
        claimEntity.setFirstName("firstnametest");
        claimEntity.setLastName("lastnametest");
        claimEntity.setClaimdescription("testpanne");
        claimEntity.setNameservice("Plomberie");
        claimEntity.setPhone("97447666");
        String uri = "/ClaimController/createClaim";
        MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(claimEntity)))
                .andExpect(status().isOk()).andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        ClaimEntity Claim = super.mapFromJson(content, ClaimEntity.class);
        assertTrue(Claim.getId() != null);

    }
    @Test
    public void createClaimWithEmptyDateDemmande() throws Exception {
        ClaimEntity claimEntity = new ClaimEntity();
        claimEntity.setState("In Progress");
        claimEntity.setAdresse("Mahdia");
        claimEntity.setEmail("testunitaire@gmail.com");
        claimEntity.setFirstName("firstnametest");
        claimEntity.setLastName("lastnametest");
        claimEntity.setClaimdescription("testpanne");
        claimEntity.setNameservice("Plomberie");
        claimEntity.setPhone("97447666");
        String uri = "/ClaimController/createClaim";
        MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(claimEntity)))
                .andExpect(status().isOk()).andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        ClaimEntity Claim = super.mapFromJson(content, ClaimEntity.class);
        assertTrue(Claim.getId() != null);

    }
    @Test
    public void createClaimWithEmptyAdresse() throws Exception {
        ClaimEntity claimEntity = new ClaimEntity();
        claimEntity.setState("In Progress");
        claimEntity.setDatedemmande("20-05-2021");
        claimEntity.setEmail("testunitaire@gmail.com");
        claimEntity.setFirstName("firstnametest");
        claimEntity.setLastName("lastnametest");
        claimEntity.setClaimdescription("testpanne");
        claimEntity.setNameservice("Plomberie");
        claimEntity.setPhone("97447666");
        String uri = "/ClaimController/createClaim";
        MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(claimEntity)))
                .andExpect(status().isOk()).andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        ClaimEntity Claim = super.mapFromJson(content, ClaimEntity.class);
        assertTrue(Claim.getId() != null);

    }
    @Test
    public void createClaimWithEmptyEmail() throws Exception {
        ClaimEntity claimEntity = new ClaimEntity();
        claimEntity.setState("In Progress");
        claimEntity.setDatedemmande("20-05-2021");
        claimEntity.setAdresse("Mahdia");
        claimEntity.setFirstName("firstnametest");
        claimEntity.setLastName("lastnametest");
        claimEntity.setClaimdescription("testpanne");
        claimEntity.setNameservice("Plomberie");
        claimEntity.setPhone("97447666");
        String uri = "/ClaimController/createClaim";
        MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(claimEntity)))
                .andExpect(status().isOk()).andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        ClaimEntity Claim = super.mapFromJson(content, ClaimEntity.class);
        assertTrue(Claim.getId() != null);

    }
    @Test
    public void createClaimWithEmtyFirstName() throws Exception {
        ClaimEntity claimEntity = new ClaimEntity();
        claimEntity.setState("In Progress");
        claimEntity.setDatedemmande("20-05-2021");
        claimEntity.setAdresse("Mahdia");
        claimEntity.setEmail("testunitaire@gmail.com");
        claimEntity.setLastName("lastnametest");
        claimEntity.setClaimdescription("testpanne");
        claimEntity.setNameservice("Plomberie");
        claimEntity.setPhone("97447666");
        String uri = "/ClaimController/createClaim";
        MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(claimEntity)))
                .andExpect(status().isOk()).andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        ClaimEntity Claim = super.mapFromJson(content, ClaimEntity.class);
        assertTrue(Claim.getId() != null);

    }
    @Test
    public void createClaimWithEmptyLastname() throws Exception {
        ClaimEntity claimEntity = new ClaimEntity();
        claimEntity.setState("In Progress");
        claimEntity.setDatedemmande("20-05-2021");
        claimEntity.setAdresse("Mahdia");
        claimEntity.setEmail("testunitaire@gmail.com");
        claimEntity.setFirstName("firstnametest");
        claimEntity.setClaimdescription("testpanne");
        claimEntity.setNameservice("Plomberie");
        claimEntity.setPhone("97447666");
        String uri = "/ClaimController/createClaim";
        MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(claimEntity)))
                .andExpect(status().isOk()).andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        ClaimEntity Claim = super.mapFromJson(content, ClaimEntity.class);
        assertTrue(Claim.getId() != null);

    }
    @Test
    public void createClaimWithEmtyClaimeDescription() throws Exception {
        ClaimEntity claimEntity = new ClaimEntity();
        claimEntity.setState("In Progress");
        claimEntity.setDatedemmande("20-05-2021");
        claimEntity.setAdresse("Mahdia");
        claimEntity.setEmail("testunitaire@gmail.com");
        claimEntity.setFirstName("firstnametest");
        claimEntity.setLastName("lastnametest");
        claimEntity.setNameservice("Plomberie");
        claimEntity.setPhone("97447666");
        String uri = "/ClaimController/createClaim";
        MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(claimEntity)))
                .andExpect(status().isOk()).andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        ClaimEntity Claim = super.mapFromJson(content, ClaimEntity.class);
        assertTrue(Claim.getId() != null);

    }
    @Test
    public void createClaimWithEmptyNameService() throws Exception {
        ClaimEntity claimEntity = new ClaimEntity();
        claimEntity.setState("In Progress");
        claimEntity.setDatedemmande("20-05-2021");
        claimEntity.setAdresse("Mahdia");
        claimEntity.setEmail("testunitaire@gmail.com");
        claimEntity.setFirstName("firstnametest");
        claimEntity.setLastName("lastnametest");
        claimEntity.setClaimdescription("testpanne");
        claimEntity.setPhone("97447666");
        String uri = "/ClaimController/createClaim";
        MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(claimEntity)))
                .andExpect(status().isOk()).andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        ClaimEntity Claim = super.mapFromJson(content, ClaimEntity.class);
        assertTrue(Claim.getId() != null);

    }
    @Test
    public void createClaimWithEmptyPhone() throws Exception {
        ClaimEntity claimEntity = new ClaimEntity();
        claimEntity.setState("In Progress");
        claimEntity.setDatedemmande("20-05-2021");
        claimEntity.setAdresse("Mahdia");
        claimEntity.setEmail("testunitaire@gmail.com");
        claimEntity.setFirstName("firstnametest");
        claimEntity.setLastName("lastnametest");
        claimEntity.setClaimdescription("testpanne");
        claimEntity.setNameservice("Plomborie");
        String uri = "/ClaimController/createClaim";
        MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(claimEntity)))
                .andExpect(status().isOk()).andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        ClaimEntity Claim = super.mapFromJson(content, ClaimEntity.class);
        assertTrue(Claim.getId() != null);

    }
    @Test
    public void createClaimWithEmailAlreadyinUse() throws Exception {
        ClaimEntity claimEntity = new ClaimEntity();
        claimEntity.setState("In Progress");
        claimEntity.setDatedemmande("20-05-2021");
        claimEntity.setAdresse("Mahdia");
        claimEntity.setEmail("testunitaire@gmail.com");
        claimEntity.setFirstName("firstnametest");
        claimEntity.setLastName("lastnametest");
        claimEntity.setClaimdescription("testpanne");
        claimEntity.setNameservice("Plomborie");
        String uri = "/ClaimController/createClaim";
        MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(claimEntity)))
                .andExpect(status().isOk()).andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        ClaimEntity Claim = super.mapFromJson(content, ClaimEntity.class);
        assertTrue(Claim.getId() != null);

    }
    @Test
    public void createClaimWithStateAlreaydinUse() throws Exception {
        ClaimEntity claimEntity = new ClaimEntity();
        claimEntity.setState("In Progress");
        claimEntity.setDatedemmande("20-05-2021");
        claimEntity.setAdresse("Mahdia");
        claimEntity.setEmail("testunitaire@gmail.com");
        claimEntity.setFirstName("firstnametest");
        claimEntity.setLastName("lastnametest");
        claimEntity.setClaimdescription("testpanne");
        claimEntity.setNameservice("Plomborie");
        String uri = "/ClaimController/createClaim";
        MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(claimEntity)))
                .andExpect(status().isOk()).andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        ClaimEntity Claim = super.mapFromJson(content, ClaimEntity.class);
        assertTrue(Claim.getId() != null);

    }
    @Test
    public void createClaimWithDateDemmandeAlreadyINUSe() throws Exception {
        ClaimEntity claimEntity = new ClaimEntity();
        claimEntity.setState("In Progress");
        claimEntity.setDatedemmande("20-05-2021");
        claimEntity.setAdresse("Mahdia");
        claimEntity.setEmail("testunitaire@gmail.com");
        claimEntity.setFirstName("firstnametest");
        claimEntity.setLastName("lastnametest");
        claimEntity.setClaimdescription("testpanne");
        claimEntity.setNameservice("Plomborie");
        String uri = "/ClaimController/createClaim";
        MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(claimEntity)))
                .andExpect(status().isOk()).andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        ClaimEntity Claim = super.mapFromJson(content, ClaimEntity.class);
        assertTrue(Claim.getId() != null);

    }
    @Test
    public void createClaimWithLocationAlReadyInUse() throws Exception {
        ClaimEntity claimEntity = new ClaimEntity();
        claimEntity.setState("In Progress");
        claimEntity.setDatedemmande("20-05-2021");
        claimEntity.setAdresse("Mahdia");
        claimEntity.setEmail("testunitaire@gmail.com");
        claimEntity.setFirstName("firstnametest");
        claimEntity.setLastName("lastnametest");
        claimEntity.setClaimdescription("testpanne");
        claimEntity.setNameservice("Plomborie");
        String uri = "/ClaimController/createClaim";
        MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(claimEntity)))
                .andExpect(status().isOk()).andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        ClaimEntity Claim = super.mapFromJson(content, ClaimEntity.class);
        assertTrue(Claim.getId() != null);

    }
    @Test
    public void createClaimWithFirstNameAlreadyInUse() throws Exception {
        ClaimEntity claimEntity = new ClaimEntity();
        claimEntity.setState("In Progress");
        claimEntity.setDatedemmande("20-05-2021");
        claimEntity.setAdresse("Mahdia");
        claimEntity.setEmail("testunitaire@gmail.com");
        claimEntity.setFirstName("firstnametest");
        claimEntity.setLastName("lastnametest");
        claimEntity.setClaimdescription("testpanne");
        claimEntity.setNameservice("Plomborie");
        String uri = "/ClaimController/createClaim";
        MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(claimEntity)))
                .andExpect(status().isOk()).andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        ClaimEntity Claim = super.mapFromJson(content, ClaimEntity.class);
        assertTrue(Claim.getId() != null);

    }
    @Test
    public void createClaimWithLastNameAllreadyinUse() throws Exception {
        ClaimEntity claimEntity = new ClaimEntity();
        claimEntity.setState("In Progress");
        claimEntity.setDatedemmande("20-05-2021");
        claimEntity.setAdresse("Mahdia");
        claimEntity.setEmail("testunitaire@gmail.com");
        claimEntity.setFirstName("firstnametest");
        claimEntity.setLastName("lastnametest");
        claimEntity.setClaimdescription("testpanne");
        claimEntity.setNameservice("Plomborie");
        String uri = "/ClaimController/createClaim";
        MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(claimEntity)))
                .andExpect(status().isOk()).andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        ClaimEntity Claim = super.mapFromJson(content, ClaimEntity.class);
        assertTrue(Claim.getId() != null);


    }
    @Test
    public void createClaimWithClaimeDescriptionAllreadyInUse() throws Exception {
        ClaimEntity claimEntity = new ClaimEntity();
        claimEntity.setState("In Progress");
        claimEntity.setDatedemmande("20-05-2021");
        claimEntity.setAdresse("Mahdia");
        claimEntity.setEmail("testunitaire@gmail.com");
        claimEntity.setFirstName("firstnametest");
        claimEntity.setLastName("lastnametest");
        claimEntity.setClaimdescription("testpanne");
        claimEntity.setNameservice("Plomborie");
        String uri = "/ClaimController/createClaim";
        MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(claimEntity)))
                .andExpect(status().isOk()).andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        ClaimEntity Claim = super.mapFromJson(content, ClaimEntity.class);
        assertTrue(Claim.getId() != null);

    }
    @Test
    public void createClaimWithServiceNameAllreadyInUse() throws Exception {
        ClaimEntity claimEntity = new ClaimEntity();
        claimEntity.setState("In Progress");
        claimEntity.setDatedemmande("20-05-2021");
        claimEntity.setAdresse("Mahdia");
        claimEntity.setEmail("testunitaire@gmail.com");
        claimEntity.setFirstName("firstnametest");
        claimEntity.setLastName("lastnametest");
        claimEntity.setClaimdescription("testpanne");
        claimEntity.setNameservice("Plomborie");
        String uri = "/ClaimController/createClaim";
        MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(claimEntity)))
                .andExpect(status().isOk()).andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        ClaimEntity Claim = super.mapFromJson(content, ClaimEntity.class);
        assertTrue(Claim.getId() != null);

    }
    @Test
    public void UpadteAllClaimParametre() throws Exception {
        ClaimEntity claimEntity = new ClaimEntity();
        claimEntity.setId(63);
        claimEntity.setState("In Progress");
        claimEntity.setDatedemmande("20-05-2021");
        claimEntity.setAdresse("Mahdia");
        claimEntity.setEmail("testunitaire@gmail.com");
        claimEntity.setFirstName("firstnametest");
        claimEntity.setLastName("lastnametest");
        claimEntity.setClaimdescription("testpanne");
        claimEntity.setNameservice("Plomberie");
        claimEntity.setPhone("97447666");
        String uri = "/ClaimController/updateClaim";
        MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(claimEntity)))
                .andExpect(status().isOk()).andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        assertTrue(content.equals("true"));

    }
    @Test
    public void UpadteStateClaimParametre() throws Exception {
        ClaimEntity claimEntity = new ClaimEntity();
        claimEntity.setId(63);
        claimEntity.setState("Accepted");

        String uri = "/ClaimController/updateClaim";
        MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(claimEntity)))
                .andExpect(status().isOk()).andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        assertTrue(content.equals("true"));

    }
    @Test
    public void UpadteEmptyStateClaimParametre() throws Exception {
        ClaimEntity claimEntity = new ClaimEntity();
        claimEntity.setId(63);
        claimEntity.setState("");
        String uri = "/ClaimController/updateClaim";
        MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(claimEntity)))
                .andExpect(status().isOk()).andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        assertTrue(content.equals("true"));

    }
    @Test
    public void UpadteDAtedemmandeClaimParametre() throws Exception {
        ClaimEntity claimEntity = new ClaimEntity();
        claimEntity.setId(63);
        claimEntity.setDatedemmande("20-05-2021");
        String uri = "/ClaimController/updateClaim";
        MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(claimEntity)))
                .andExpect(status().isOk()).andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        assertTrue(content.equals("true"));

    }
    @Test
    public void UpadteEmptyDAtedemmandeClaimParametre() throws Exception {
        ClaimEntity claimEntity = new ClaimEntity();
        claimEntity.setId(63);
        claimEntity.setDatedemmande("");
        String uri = "/ClaimController/updateClaim";
        MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(claimEntity)))
                .andExpect(status().isOk()).andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        assertTrue(content.equals("true"));

    }
    @Test
    public void UpadteLocationClaimParametre() throws Exception {
        ClaimEntity claimEntity = new ClaimEntity();
        claimEntity.setId(63);
        claimEntity.setAdresse("Mahdia");
        String uri = "/ClaimController/updateClaim";
        MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(claimEntity)))
                .andExpect(status().isOk()).andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        assertTrue(content.equals("true"));

    }
    @Test
    public void UpadteEmptyLocationClaimParametre() throws Exception {
        ClaimEntity claimEntity = new ClaimEntity();
        claimEntity.setId(63);
        claimEntity.setAdresse("");
        String uri = "/ClaimController/updateClaim";
        MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(claimEntity)))
                .andExpect(status().isOk()).andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        assertTrue(content.equals("true"));

    }
    @Test
    public void UpadteEmailClaimParametre() throws Exception {
        ClaimEntity claimEntity = new ClaimEntity();
        claimEntity.setId(63);
        claimEntity.setEmail("testunitaire@gmail.com");
        String uri = "/ClaimController/updateClaim";
        MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(claimEntity)))
                .andExpect(status().isOk()).andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        assertTrue(content.equals("true"));

    }
    @Test
    public void UpadteEmptyEmailClaimParametre() throws Exception {
        ClaimEntity claimEntity = new ClaimEntity();
        claimEntity.setId(63);
        claimEntity.setEmail("");
        String uri = "/ClaimController/updateClaim";
        MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(claimEntity)))
                .andExpect(status().isOk()).andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        assertTrue(content.equals("true"));

    }
    @Test
    public void UpadteFirstNameClaimParametre() throws Exception {
        ClaimEntity claimEntity = new ClaimEntity();
        claimEntity.setId(63);
        claimEntity.setFirstName("firstnametest");
        String uri = "/ClaimController/updateClaim";
        MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(claimEntity)))
                .andExpect(status().isOk()).andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        assertTrue(content.equals("true"));

    }
    @Test
    public void UpadteEmptyFirstNameClaimParametre() throws Exception {
        ClaimEntity claimEntity = new ClaimEntity();
        claimEntity.setId(63);
        claimEntity.setFirstName("");
        String uri = "/ClaimController/updateClaim";
        MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(claimEntity)))
                .andExpect(status().isOk()).andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        assertTrue(content.equals("true"));

    }
    @Test
    public void UpadteLastNameClaimParametre() throws Exception {
        ClaimEntity claimEntity = new ClaimEntity();
        claimEntity.setId(63);
        claimEntity.setLastName("lastnametest");
        String uri = "/ClaimController/updateClaim";
        MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(claimEntity)))
                .andExpect(status().isOk()).andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        assertTrue(content.equals("true"));

    }
    @Test
    public void UpadteEmptyLastNameClaimParametre() throws Exception {
        ClaimEntity claimEntity = new ClaimEntity();
        claimEntity.setId(63);
        claimEntity.setLastName("");
        String uri = "/ClaimController/updateClaim";
        MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(claimEntity)))
                .andExpect(status().isOk()).andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        assertTrue(content.equals("true"));

    }
    @Test
    public void UpadteClaimdesciprtionClaimParametre() throws Exception {
        ClaimEntity claimEntity = new ClaimEntity();
        claimEntity.setId(63);
        claimEntity.setClaimdescription("testpanne");
        String uri = "/ClaimController/updateClaim";
        MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(claimEntity)))
                .andExpect(status().isOk()).andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        assertTrue(content.equals("true"));

    }
    @Test
    public void UpadteEmptyClaimdesciprtionClaimParametre() throws Exception {
        ClaimEntity claimEntity = new ClaimEntity();
        claimEntity.setId(63);
        claimEntity.setClaimdescription("");
        String uri = "/ClaimController/updateClaim";
        MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(claimEntity)))
                .andExpect(status().isOk()).andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        assertTrue(content.equals("true"));

    }
    @Test
    public void UpadteServiceNameClaimParametre() throws Exception {
        ClaimEntity claimEntity = new ClaimEntity();
        claimEntity.setId(63);
        claimEntity.setNameservice("Plomberie");
        String uri = "/ClaimController/updateClaim";
        MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(claimEntity)))
                .andExpect(status().isOk()).andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        assertTrue(content.equals("true"));

    }
    @Test
    public void UpadteEmptyServiceNameClaimParametre() throws Exception {
        ClaimEntity claimEntity = new ClaimEntity();
        claimEntity.setId(63);
        claimEntity.setNameservice("");
        String uri = "/ClaimController/updateClaim";
        MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(claimEntity)))
                .andExpect(status().isOk()).andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        assertTrue(content.equals("true"));

    }
    @Test
    public void UpadtePhoneClaimParametre() throws Exception {
        ClaimEntity claimEntity = new ClaimEntity();
        claimEntity.setId(63);
        claimEntity.setPhone("97447666");
        String uri = "/ClaimController/updateClaim";
        MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(claimEntity)))
                .andExpect(status().isOk()).andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        assertTrue(content.equals("true"));

    }
    @Test
    public void UpadteEmptyPhoneClaimParametre() throws Exception {
        ClaimEntity claimEntity = new ClaimEntity();
        claimEntity.setId(63);
        claimEntity.setPhone("");
        String uri = "/ClaimController/updateClaim";
        MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(claimEntity)))
                .andExpect(status().isOk()).andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        assertTrue(content.equals("true"));

    }

    @Test
    public void deleteClaimByID() throws Exception {
        ClaimEntity claimEntity = new ClaimEntity();
        String uricreate = "/ClaimController/createClaim";
        MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.post(uricreate).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(claimEntity)))
                .andExpect(status().isOk()).andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        ClaimEntity Claim = super.mapFromJson(content, ClaimEntity.class);
        String uri = "/ClaimController/deleteClaim";
        MvcResult mvcResultDetete=mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(Claim.getId())))
                .andExpect(status().isOk()).andReturn();
    }
    @Test
    public void deleteInexisteClaimByID() throws Exception {
        ClaimEntity claimEntity = new ClaimEntity();
        String uri = "/ClaimController/deleteClaim";
        MvcResult mvcResultDetete=mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(claimEntity.getId())))
                .andExpect(status().isBadRequest()).andReturn();
    }
    @Test
    public void deleteClaimByNegativeID() throws Exception {
        ClaimEntity claimEntity = new ClaimEntity();
        claimEntity.setId(-1);
        String uri = "/ClaimController/deleteClaim";
        MvcResult mvcResultDetete=mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(claimEntity.getId())))
                .andExpect(status().isNotFound()).andReturn();

    }
    @Test
    public void deleteClaimByZeroID() throws Exception {
        ClaimEntity claimEntity = new ClaimEntity();
        claimEntity.setId(0);
        String uri = "/ClaimController/deleteClaim";
        MvcResult mvcResultDetete=mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(claimEntity.getId())))
                .andExpect(status().isNotFound()).andReturn();

    }
    @Test
    public void deleteClaimByPositveAndIexisteID() throws Exception {
        ClaimEntity claimEntity = new ClaimEntity();
        claimEntity.setId(1);
        String uri = "/ClaimController/deleteClaim";
        MvcResult mvcResultDetete=mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(claimEntity.getId())))
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
