import com.fasterxml.jackson.databind.ObjectMapper;
import com.hms.entity.CommandeEntity;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class CommandeControllerTest extends AbstractTest {

    @Override
    @Before
    public void setUp() {
        super.setUp();
    }
    @Test
    public void getAllCommandeList() throws Exception {
        String uri = "/CommandeController/getAllCommande";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        CommandeEntity[] Commande = super.mapFromJson(content, CommandeEntity[].class);
        assertTrue(Commande.length > 0);
    }


    @Test
    public void getAllCommandeByExistUserId() throws Exception {
       int id=35;
        String uri = "/CommandeController/getCommande/"+id;
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        CommandeEntity[] Commande = super.mapFromJson(content, CommandeEntity[].class);
        assertTrue(Commande.length > 0);
    }
    @Test
    public void getAllCommandeByInExistUserId() throws Exception {
        int id=1000;
        String uri = "/CommandeController/getCommande/"+id;
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        System.out.println("hatem:"+status);
       assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        CommandeEntity[] Commande = super.mapFromJson(content, CommandeEntity[].class);
        assertTrue(Commande.length == 0);
    }
    @Test
    public void getAllCommandeBynegativeUserId() throws Exception {
        int id=-1000;

        String uri = "/CommandeController/getCommande/"+id;
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        CommandeEntity[] Commande = super.mapFromJson(content, CommandeEntity[].class);
        assertTrue(Commande.length == 0);
    }
    @Test
    public void getAllCommandeByNullUserId() throws Exception {
        int id=0;

        String uri = "/CommandeController/getCommande/"+id;
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        CommandeEntity[] Commande = super.mapFromJson(content, CommandeEntity[].class);
        assertTrue(Commande.length == 0);
    }
    @Test
    public void getAllCommandeBypositveUserId() throws Exception {
        int id=35;

        String uri = "/CommandeController/getCommande/"+id;
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        CommandeEntity[] Commande = super.mapFromJson(content, CommandeEntity[].class);
        assertTrue(Commande.length > 0);
    }
    @Test
    public void getAllCommandeByPositveAndInExisteUserId() throws Exception {
        int id=2000;

        String uri = "/CommandeController/getCommande/"+id;
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        CommandeEntity[] Commande = super.mapFromJson(content, CommandeEntity[].class);
        assertTrue(Commande.length == 0);
    }
    @Test
    public void getAllCommandeByPositveAndExisteUserId() throws Exception {
        int id=35;

        String uri = "/CommandeController/getCommande/"+id;
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        CommandeEntity[] Commande = super.mapFromJson(content, CommandeEntity[].class);
        assertTrue(Commande.length > 0);
    }
    @Test
    public void getCommandByEmployeeNullArgimentService() throws Exception {
        String service=null;

        String uri = "/CommandeController/getCommandebyservice/"+service;
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        CommandeEntity[] Commande = super.mapFromJson(content, CommandeEntity[].class);
        assertTrue(Commande.length == 0);
    }
    @Test
    public void getCommandByEmployeeInExestedArgimentService() throws Exception {
        String service="vendeur";

        String uri = "/CommandeController/getCommandebyservice/"+service;
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        CommandeEntity[] Commande = super.mapFromJson(content, CommandeEntity[].class);
        assertTrue(Commande.length == 0);
    }
    @Test
    public void getCommandByEmployeeParabolisteArgimentService() throws Exception {
        String service="Paraboliste";

        String uri = "/CommandeController/getCommandebyservice/"+service;
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        CommandeEntity[] Commande = super.mapFromJson(content, CommandeEntity[].class);
        //assertTrue(Commande.length > 0);
    }
    @Test
    public void getCommandByEmployeePentureArgimentService() throws Exception {
        String service="Penture";

        String uri = "/CommandeController/getCommandebyservice/"+service;
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);

    }
    @Test
    public void getCommandByEmployeePlomberieArgimentService() throws Exception {
        String service="Plomberie";

        String uri = "/CommandeController/getCommandebyservice/"+service;
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        CommandeEntity[] Commande = super.mapFromJson(content, CommandeEntity[].class);
        assertTrue(Commande.length > 0);
    }

    @Test
    public void getCommandByEmployeeJardinageArgimentService() throws Exception {
        String service="Jardinage";

        String uri = "/CommandeController/getCommandebyservice/"+service;
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        CommandeEntity[] Commande = super.mapFromJson(content, CommandeEntity[].class);
        assertTrue(Commande.length > 0);
    }

    @Test
    public void getCommandByEmployeeMaçonneriegeneraleArgimentService() throws Exception {
        String service="General masonry";

        String uri = "/CommandeController/getCommandebyservice/"+service;
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        CommandeEntity[] Commande = super.mapFromJson(content, CommandeEntity[].class);
        assertTrue(Commande.length > 0);
    }

    @Test
    public void getCommandByEmployeeElectriciteArgimentService() throws Exception {
        String service="Electricite";

        String uri = "/CommandeController/getCommandebyservice/"+service;
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        CommandeEntity[] Commande = super.mapFromJson(content, CommandeEntity[].class);
        assertTrue(Commande.length > 0);
    }

    @Test
    public void getCommandByEmployeeCharpenterieArgimentService() throws Exception {
        String service="Charpenterie";

        String uri = "/CommandeController/getCommandebyservice/"+service;
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        CommandeEntity[] Commande = super.mapFromJson(content, CommandeEntity[].class);
        assertTrue(Commande.length > 0);
    }
    @Test
    public void getCommandByEmployeeEspaceArgimentService() throws Exception {
        String service=" ";

        String uri = "/CommandeController/getCommandebyservice/"+service;
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        CommandeEntity[] Commande = super.mapFromJson(content, CommandeEntity[].class);
        assertTrue(Commande.length == 0);
    }
    @Test
    public void getCommandByEmployeeNumberinArgimentService() throws Exception {
        int service=1;

        String uri = "/CommandeController/getCommandebyservice/"+service;
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        CommandeEntity[] Commande = super.mapFromJson(content, CommandeEntity[].class);
        assertTrue(Commande.length == 0);
    }

    @Test
    public void createEmptyCommande() throws Exception {
        CommandeEntity commandeEntity = new CommandeEntity();

        String uri = "/CommandeController/createCommande";
        MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(commandeEntity)))
                .andExpect(status().isOk()).andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        CommandeEntity Commande = super.mapFromJson(content, CommandeEntity.class);
        assertTrue(Commande.getId() != null);

    }

    @Test
    public void createCommandeWithAllData() throws Exception {
        CommandeEntity commandeEntity = new CommandeEntity();
        commandeEntity.setState("In Progress");
        commandeEntity.setDatedemmande("20-05-2021");
        commandeEntity.setAdresse("Mahdia");
        commandeEntity.setEmail("testunitaire@gmail.com");
        commandeEntity.setFirstName("firstnametest");
        commandeEntity.setLastName("lastnametest");
        commandeEntity.setPannedescription("testpanne");
        commandeEntity.setNameservice("Plomberie");
        commandeEntity.setPhone("97447666");
        String uri = "/CommandeController/createCommande";
        MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(commandeEntity)))
                .andExpect(status().isOk()).andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        CommandeEntity Commande = super.mapFromJson(content, CommandeEntity.class);
        assertTrue(Commande.getId() != null);

    }
    @Test
    public void createCommandeWithEmptyState() throws Exception {
        CommandeEntity commandeEntity = new CommandeEntity();
        commandeEntity.setDatedemmande("20-05-2021");
        commandeEntity.setAdresse("Mahdia");
        commandeEntity.setEmail("testunitaire@gmail.com");
        commandeEntity.setFirstName("firstnametest");
        commandeEntity.setLastName("lastnametest");
        commandeEntity.setPannedescription("testpanne");
        commandeEntity.setNameservice("Plomberie");
        commandeEntity.setPhone("97447666");
        String uri = "/CommandeController/createCommande";
        MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(commandeEntity)))
                .andExpect(status().isOk()).andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        CommandeEntity Commande = super.mapFromJson(content, CommandeEntity.class);
        assertTrue(Commande.getId() != null);

    }
    @Test
    public void createCommandeWithEmptyDateDemmande() throws Exception {
        CommandeEntity commandeEntity = new CommandeEntity();
        commandeEntity.setState("In Progress");
        commandeEntity.setAdresse("Mahdia");
        commandeEntity.setEmail("testunitaire@gmail.com");
        commandeEntity.setFirstName("firstnametest");
        commandeEntity.setLastName("lastnametest");
        commandeEntity.setPannedescription("testpanne");
        commandeEntity.setNameservice("Plomberie");
        commandeEntity.setPhone("97447666");
        String uri = "/CommandeController/createCommande";
        MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(commandeEntity)))
                .andExpect(status().isOk()).andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        CommandeEntity Commande = super.mapFromJson(content, CommandeEntity.class);
        assertTrue(Commande.getId() != null);

    }
    @Test
    public void createCommandeWithEmptyAdresse() throws Exception {
        CommandeEntity commandeEntity = new CommandeEntity();
        commandeEntity.setState("In Progress");
        commandeEntity.setDatedemmande("20-05-2021");
        commandeEntity.setEmail("testunitaire@gmail.com");
        commandeEntity.setFirstName("firstnametest");
        commandeEntity.setLastName("lastnametest");
        commandeEntity.setPannedescription("testpanne");
        commandeEntity.setNameservice("Plomberie");
        commandeEntity.setPhone("97447666");
        String uri = "/CommandeController/createCommande";
        MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(commandeEntity)))
                .andExpect(status().isOk()).andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        CommandeEntity Commande = super.mapFromJson(content, CommandeEntity.class);
        assertTrue(Commande.getId() != null);

    }
    @Test
    public void createCommandeWithEmptyEmail() throws Exception {
        CommandeEntity commandeEntity = new CommandeEntity();
        commandeEntity.setState("In Progress");
        commandeEntity.setDatedemmande("20-05-2021");
        commandeEntity.setAdresse("Mahdia");
        commandeEntity.setEmail("testunitaire@gmail.com");
        commandeEntity.setFirstName("firstnametest");
        commandeEntity.setLastName("lastnametest");
        commandeEntity.setPannedescription("testpanne");
        commandeEntity.setNameservice("Plomberie");
        commandeEntity.setPhone("97447666");
        String uri = "/CommandeController/createCommande";
        MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(commandeEntity)))
                .andExpect(status().isOk()).andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        CommandeEntity Commande = super.mapFromJson(content, CommandeEntity.class);
        assertTrue(Commande.getId() != null);

    }
    @Test
    public void createCommandeWithEmptyFirstName() throws Exception {
        CommandeEntity commandeEntity = new CommandeEntity();
        commandeEntity.setState("In Progress");
        commandeEntity.setDatedemmande("20-05-2021");
        commandeEntity.setAdresse("Mahdia");
        commandeEntity.setEmail("testunitaire@gmail.com");
        commandeEntity.setLastName("lastnametest");
        commandeEntity.setPannedescription("testpanne");
        commandeEntity.setNameservice("Plomberie");
        commandeEntity.setPhone("97447666");
        String uri = "/CommandeController/createCommande";
        MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(commandeEntity)))
                .andExpect(status().isOk()).andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        CommandeEntity Commande = super.mapFromJson(content, CommandeEntity.class);
        assertTrue(Commande.getId() != null);

    }
    @Test
    public void createCommandeWithEmptyLastname() throws Exception {
        CommandeEntity commandeEntity = new CommandeEntity();
        commandeEntity.setState("In Progress");
        commandeEntity.setDatedemmande("20-05-2021");
        commandeEntity.setAdresse("Mahdia");
        commandeEntity.setEmail("testunitaire@gmail.com");
        commandeEntity.setFirstName("firstnametest");
        commandeEntity.setPannedescription("testpanne");
        commandeEntity.setNameservice("Plomberie");
        commandeEntity.setPhone("97447666");
        String uri = "/CommandeController/createCommande";
        MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(commandeEntity)))
                .andExpect(status().isOk()).andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        CommandeEntity Commande = super.mapFromJson(content, CommandeEntity.class);
        assertTrue(Commande.getId() != null);

    }
    @Test
    public void createCommandeWithEmptyPanneDescription() throws Exception {
        CommandeEntity commandeEntity = new CommandeEntity();
        commandeEntity.setState("In Progress");
        commandeEntity.setDatedemmande("20-05-2021");
        commandeEntity.setAdresse("Mahdia");
        commandeEntity.setEmail("testunitaire@gmail.com");
        commandeEntity.setFirstName("firstnametest");
        commandeEntity.setLastName("lastnametest");
        commandeEntity.setNameservice("Plomberie");
        commandeEntity.setPhone("97447666");
        String uri = "/CommandeController/createCommande";
        MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(commandeEntity)))
                .andExpect(status().isOk()).andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        CommandeEntity Commande = super.mapFromJson(content, CommandeEntity.class);
        assertTrue(Commande.getId() != null);

    }
    @Test
    public void createCommandeWithEmptyNameService() throws Exception {
        CommandeEntity commandeEntity = new CommandeEntity();
        commandeEntity.setState("In Progress");
        commandeEntity.setDatedemmande("20-05-2021");
        commandeEntity.setAdresse("Mahdia");
        commandeEntity.setEmail("testunitaire@gmail.com");
        commandeEntity.setFirstName("firstnametest");
        commandeEntity.setLastName("lastnametest");
        commandeEntity.setPannedescription("testpanne");
        commandeEntity.setPhone("97447666");
        String uri = "/CommandeController/createCommande";
        MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(commandeEntity)))
                .andExpect(status().isOk()).andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        CommandeEntity Commande = super.mapFromJson(content, CommandeEntity.class);
        assertTrue(Commande.getId() != null);

    }
    @Test
    public void createCommandeWithEmptyPhone() throws Exception {
        CommandeEntity commandeEntity = new CommandeEntity();
        commandeEntity.setState("In Progress");
        commandeEntity.setDatedemmande("20-05-2021");
        commandeEntity.setAdresse("Mahdia");
        commandeEntity.setEmail("testunitaire@gmail.com");
        commandeEntity.setFirstName("firstnametest");
        commandeEntity.setLastName("lastnametest");
        commandeEntity.setPannedescription("testpanne");
        commandeEntity.setNameservice("Plomberie");
        String uri = "/CommandeController/createCommande";
        MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(commandeEntity)))
                .andExpect(status().isOk()).andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        CommandeEntity Commande = super.mapFromJson(content, CommandeEntity.class);
        assertTrue(Commande.getId() != null);

    }

    @Test
    public void createCommandeWithEmailAlreadyInUse() throws Exception {
        CommandeEntity commandeEntity = new CommandeEntity();
        commandeEntity.setState("In Progress");
        commandeEntity.setDatedemmande("20-05-2021");
        commandeEntity.setAdresse("Mahdia");
        commandeEntity.setEmail("testunitaire@gmail.com");
        commandeEntity.setFirstName("firstnametest");
        commandeEntity.setLastName("lastnametest");
        commandeEntity.setPannedescription("testpanne");
        commandeEntity.setNameservice("Plomberie");
        commandeEntity.setPhone("97447666");
        String uri = "/CommandeController/createCommande";
        MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(commandeEntity)))
                .andExpect(status().isOk()).andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        CommandeEntity Commande = super.mapFromJson(content, CommandeEntity.class);
        assertTrue(Commande.getId() != null);

    }




    @Test
    public void createCommandeWithNameAlreadyInUse() throws Exception {
        CommandeEntity commandeEntity = new CommandeEntity();
        commandeEntity.setState("In Progress");
        commandeEntity.setDatedemmande("20-05-2021");
        commandeEntity.setAdresse("Mahdia");
        commandeEntity.setEmail("testunitaire@gmail.com");
        commandeEntity.setFirstName("firstnametest");
        commandeEntity.setLastName("lastnametest");
        commandeEntity.setPannedescription("testpanne");
        commandeEntity.setNameservice("Plomberie");
        commandeEntity.setPhone("97447666");
        String uri = "/CommandeController/createCommande";
        MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(commandeEntity)))
                .andExpect(status().isOk()).andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        CommandeEntity Commande = super.mapFromJson(content, CommandeEntity.class);
        assertTrue(Commande.getId() != null);

    }

    @Test
    public void createCommandeWithFirstnamelAlreadyInUse() throws Exception {
        CommandeEntity commandeEntity = new CommandeEntity();
        commandeEntity.setState("In Progress");
        commandeEntity.setDatedemmande("20-05-2021");
        commandeEntity.setAdresse("Mahdia");
        commandeEntity.setEmail("testunitaire@gmail.com");
        commandeEntity.setFirstName("firstnametest");
        commandeEntity.setLastName("lastnametest");
        commandeEntity.setPannedescription("testpanne");
        commandeEntity.setNameservice("Plomberie");
        commandeEntity.setPhone("97447666");
        String uri = "/CommandeController/createCommande";
        MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(commandeEntity)))
                .andExpect(status().isOk()).andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        CommandeEntity Commande = super.mapFromJson(content, CommandeEntity.class);
        assertTrue(Commande.getId() != null);

    }

    @Test
    public void createCommandeWithLastAlreadyInUse() throws Exception {
        CommandeEntity commandeEntity = new CommandeEntity();
        commandeEntity.setState("In Progress");
        commandeEntity.setDatedemmande("20-05-2021");
        commandeEntity.setAdresse("Mahdia");
        commandeEntity.setEmail("testunitaire@gmail.com");
        commandeEntity.setFirstName("firstnametest");
        commandeEntity.setLastName("lastnametest");
        commandeEntity.setPannedescription("testpanne");
        commandeEntity.setNameservice("Plomberie");
        commandeEntity.setPhone("97447666");
        String uri = "/CommandeController/createCommande";
        MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(commandeEntity)))
                .andExpect(status().isOk()).andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        CommandeEntity Commande = super.mapFromJson(content, CommandeEntity.class);
        assertTrue(Commande.getId() != null);

    }

    @Test
    public void createCommandeWithPhoneAlreadyInUse() throws Exception {
        CommandeEntity commandeEntity = new CommandeEntity();
        commandeEntity.setState("In Progress");
        commandeEntity.setDatedemmande("20-05-2021");
        commandeEntity.setAdresse("Mahdia");
        commandeEntity.setEmail("testunitaire@gmail.com");
        commandeEntity.setFirstName("firstnametest");
        commandeEntity.setLastName("lastnametest");
        commandeEntity.setPannedescription("testpanne");
        commandeEntity.setNameservice("Plomberie");
        commandeEntity.setPhone("97447666");
        String uri = "/CommandeController/createCommande";
        MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(commandeEntity)))
                .andExpect(status().isOk()).andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        CommandeEntity Commande = super.mapFromJson(content, CommandeEntity.class);
        assertTrue(Commande.getId() != null);

    }

    @Test
    public void createCommandeWithAdresseAlreadyInUse() throws Exception {
        CommandeEntity commandeEntity = new CommandeEntity();
        commandeEntity.setState("In Progress");
        commandeEntity.setDatedemmande("20-05-2021");
        commandeEntity.setAdresse("Mahdia");
        commandeEntity.setEmail("testunitaire@gmail.com");
        commandeEntity.setFirstName("firstnametest");
        commandeEntity.setLastName("lastnametest");
        commandeEntity.setPannedescription("testpanne");
        commandeEntity.setNameservice("Plomberie");
        commandeEntity.setPhone("97447666");
        String uri = "/CommandeController/createCommande";
        MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(commandeEntity)))
                .andExpect(status().isOk()).andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        CommandeEntity Commande = super.mapFromJson(content, CommandeEntity.class);
        assertTrue(Commande.getId() != null);

    }

    @Test
    public void createCommandeWithNameserviceAlreadyInUse() throws Exception {
        CommandeEntity commandeEntity = new CommandeEntity();
        commandeEntity.setState("In Progress");
        commandeEntity.setDatedemmande("20-05-2021");
        commandeEntity.setAdresse("Mahdia");
        commandeEntity.setEmail("testunitaire@gmail.com");
        commandeEntity.setFirstName("firstnametest");
        commandeEntity.setLastName("lastnametest");
        commandeEntity.setPannedescription("testpanne");
        commandeEntity.setNameservice("Plomberie");
        commandeEntity.setPhone("97447666");
        String uri = "/CommandeController/createCommande";
        MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(commandeEntity)))
                .andExpect(status().isOk()).andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        CommandeEntity Commande = super.mapFromJson(content, CommandeEntity.class);
        assertTrue(Commande.getId() != null);

    }

    @Test
    public void createCommandeWithPaneDescriptionAlreadyInUse() throws Exception {
        CommandeEntity commandeEntity = new CommandeEntity();
        commandeEntity.setState("In Progress");
        commandeEntity.setDatedemmande("20-05-2021");
        commandeEntity.setAdresse("Mahdia");
        commandeEntity.setEmail("testunitaire@gmail.com");
        commandeEntity.setFirstName("firstnametest");
        commandeEntity.setLastName("lastnametest");
        commandeEntity.setPannedescription("testpanne");
        commandeEntity.setNameservice("Plomberie");
        commandeEntity.setPhone("97447666");
        String uri = "/CommandeController/createCommande";
        MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(commandeEntity)))
                .andExpect(status().isOk()).andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        CommandeEntity Commande = super.mapFromJson(content, CommandeEntity.class);
        assertTrue(Commande.getId() != null);

    }


    @Test
    public void UpadteAllCommandeParametre() throws Exception {
        CommandeEntity commandeEntity = new CommandeEntity();
        commandeEntity.setId(145L);
        commandeEntity.setState("In Progress");
        commandeEntity.setDatedemmande("20-05-2021");
        commandeEntity.setAdresse("Mahdia");
        commandeEntity.setEmail("testunitaire@gmail.com");
        commandeEntity.setFirstName("firstnametest");
        commandeEntity.setLastName("lastnametest");
        commandeEntity.setPannedescription("testpanne");
        commandeEntity.setNameservice("Plomberie");
        commandeEntity.setPhone("97447666");
        String uri = "/CommandeController/updateCommande";
        MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(commandeEntity)))
                .andExpect(status().isOk()).andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        assertTrue(content.equals("true"));

    }
    @Test
    public void UpadteCommandeParametreState() throws Exception {
        CommandeEntity commandeEntity = new CommandeEntity();
        commandeEntity.setId(145L);
        commandeEntity.setState("In Progress");
        String uri = "/CommandeController/updateCommande";
        MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(commandeEntity)))
                .andExpect(status().isOk()).andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        assertTrue(content.equals("true"));

    }
    @Test
    public void UpadteCommandeParametreEmptyState() throws Exception {
        CommandeEntity commandeEntity = new CommandeEntity();
        commandeEntity.setId(145L);
        commandeEntity.setState("");
        String uri = "/CommandeController/updateCommande";
        MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(commandeEntity)))
                .andExpect(status().isOk()).andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        assertTrue(content.equals("true"));

    }
    @Test
    public void UpadteCommandeParametreDateDemande() throws Exception {
        CommandeEntity commandeEntity = new CommandeEntity();
        commandeEntity.setId(145L);
        commandeEntity.setDatedemmande("20-05-2021");
        String uri = "/CommandeController/updateCommande";
        MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(commandeEntity)))
                .andExpect(status().isOk()).andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        assertTrue(content.equals("true"));

    }
    @Test
    public void UpadteCommandeParametreEmptyDateDemande() throws Exception {
        CommandeEntity commandeEntity = new CommandeEntity();
        commandeEntity.setId(145L);
        commandeEntity.setDatedemmande("");
        String uri = "/CommandeController/updateCommande";
        MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(commandeEntity)))
                .andExpect(status().isOk()).andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        assertTrue(content.equals("true"));

    }
    @Test
    public void UpadteCommandeParametreAdress() throws Exception {
        CommandeEntity commandeEntity = new CommandeEntity();
        commandeEntity.setId(145L);
        commandeEntity.setAdresse("Mahdia");

        String uri = "/CommandeController/updateCommande";
        MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(commandeEntity)))
                .andExpect(status().isOk()).andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        assertTrue(content.equals("true"));

    }
    @Test
    public void UpadteCommandeParametreEmptyAdress() throws Exception {
        CommandeEntity commandeEntity = new CommandeEntity();
        commandeEntity.setId(145L);
        commandeEntity.setAdresse("");

        String uri = "/CommandeController/updateCommande";
        MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(commandeEntity)))
                .andExpect(status().isOk()).andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        assertTrue(content.equals("true"));

    }
    @Test
    public void UpadteCommandeParametreEmail() throws Exception {
        CommandeEntity commandeEntity = new CommandeEntity();
        commandeEntity.setId(145L);
        commandeEntity.setEmail("testunitaire@gmail.com");
        String uri = "/CommandeController/updateCommande";
        MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(commandeEntity)))
                .andExpect(status().isOk()).andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        assertTrue(content.equals("true"));

    }
    @Test
    public void UpadteCommandeParametreEmptyEmail() throws Exception {
        CommandeEntity commandeEntity = new CommandeEntity();
        commandeEntity.setId(145L);
        commandeEntity.setEmail("");
        String uri = "/CommandeController/updateCommande";
        MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(commandeEntity)))
                .andExpect(status().isOk()).andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        assertTrue(content.equals("true"));

    }
    @Test
    public void UpadteCommandeParametreFirstname() throws Exception {
        CommandeEntity commandeEntity = new CommandeEntity();
        commandeEntity.setId(145L);
        commandeEntity.setFirstName("firstnametest");
        String uri = "/CommandeController/updateCommande";
        MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(commandeEntity)))
                .andExpect(status().isOk()).andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        assertTrue(content.equals("true"));

    }
    @Test
    public void UpadteCommandeParametreEmptyFirstname() throws Exception {
        CommandeEntity commandeEntity = new CommandeEntity();
        commandeEntity.setId(145L);
        commandeEntity.setFirstName("");
        String uri = "/CommandeController/updateCommande";
        MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(commandeEntity)))
                .andExpect(status().isOk()).andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        assertTrue(content.equals("true"));

    }
    @Test
    public void UpadteCommandeParametreLastname() throws Exception {
        CommandeEntity commandeEntity = new CommandeEntity();
        commandeEntity.setId(145L);
        commandeEntity.setLastName("lastnametest");
        String uri = "/CommandeController/updateCommande";
        MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(commandeEntity)))
                .andExpect(status().isOk()).andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        assertTrue(content.equals("true"));

    }
    @Test
    public void UpadteCommandeParametreEmptyLastname() throws Exception {
        CommandeEntity commandeEntity = new CommandeEntity();
        commandeEntity.setId(145L);
        commandeEntity.setLastName("");
        String uri = "/CommandeController/updateCommande";
        MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(commandeEntity)))
                .andExpect(status().isOk()).andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        assertTrue(content.equals("true"));

    }


    @Test
    public void UpadteCommandeParametrePanneDescription() throws Exception {
        CommandeEntity commandeEntity = new CommandeEntity();
        commandeEntity.setId(145L);
        commandeEntity.setPannedescription("testpanne");
        String uri = "/CommandeController/updateCommande";
        MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(commandeEntity)))
                .andExpect(status().isOk()).andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        assertTrue(content.equals("true"));

    }
    @Test
    public void UpadteCommandeParametreEmptyPanneDescription() throws Exception {
        CommandeEntity commandeEntity = new CommandeEntity();
        commandeEntity.setId(145L);
        commandeEntity.setPannedescription("");
        String uri = "/CommandeController/updateCommande";
        MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(commandeEntity)))
                .andExpect(status().isOk()).andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        assertTrue(content.equals("true"));

    }
    @Test
    public void UpadteCommandeParametreServiceName() throws Exception {
        CommandeEntity commandeEntity = new CommandeEntity();
        commandeEntity.setId(145L);
        commandeEntity.setNameservice("Plomberie");
        String uri = "/CommandeController/updateCommande";
        MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(commandeEntity)))
                .andExpect(status().isOk()).andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        assertTrue(content.equals("true"));

    }
    @Test
    public void UpadteCommandeParametreEmptyServiceName() throws Exception {
        CommandeEntity commandeEntity = new CommandeEntity();
        commandeEntity.setId(145L);
        commandeEntity.setNameservice("");
        String uri = "/CommandeController/updateCommande";
        MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(commandeEntity)))
                .andExpect(status().isOk()).andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        assertTrue(content.equals("true"));

    }
    @Test
    public void UpadteCommandeParametrePhone() throws Exception {
        CommandeEntity commandeEntity = new CommandeEntity();
        commandeEntity.setId(145L);
        commandeEntity.setPhone("97447666");
        String uri = "/CommandeController/updateCommande";
        MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(commandeEntity)))
                .andExpect(status().isOk()).andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        assertTrue(content.equals("true"));

    }
    @Test
    public void UpadteCommandeParametreEmptyPhone() throws Exception {
        CommandeEntity commandeEntity = new CommandeEntity();
        commandeEntity.setId(145L);
        commandeEntity.setPhone("");
        String uri = "/CommandeController/updateCommande";
        MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(commandeEntity)))
                .andExpect(status().isOk()).andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        assertTrue(content.equals("true"));

    }

 @Test
    public void deleteCommandeByID() throws Exception {
        CommandeEntity commandeEntity = new CommandeEntity();
        String uricreate = "/CommandeController/createCommande";
        MvcResult mvcResult=mvc.perform(MockMvcRequestBuilders.post(uricreate).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(commandeEntity)))
                .andExpect(status().isOk()).andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        CommandeEntity Commande = super.mapFromJson(content, CommandeEntity.class);
        String uri = "/CommandeController/deleteCommande";
        MvcResult mvcResultDetete=mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                    .content(asJsonString(Commande.getId())))
                .andExpect(status().isOk()).andReturn();

    }
    @Test
    public void deleteInexisteCommandeByID() throws Exception {
        CommandeEntity commandeEntity = new CommandeEntity();
        String uri = "/CommandeController/deleteCommande";
        MvcResult mvcResultDetete=mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(commandeEntity.getId())))
                .andExpect(status().isBadRequest()).andReturn();
    }

    @Test
    public void deleteCommandeByNegativeID() throws Exception {
        CommandeEntity commandeEntity = new CommandeEntity();
        commandeEntity.setId(-1L);
        String uri = "/CommandeController/deleteCommande";
        MvcResult mvcResultDetete=mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(commandeEntity.getId())))
                .andExpect(status().isNotFound()).andReturn();

    }
    @Test
    public void deleteCommandeByZeroID() throws Exception {
        CommandeEntity commandeEntity = new CommandeEntity();
        commandeEntity.setId(0L);
        String uri = "/CommandeController/deleteCommande";
        MvcResult mvcResultDetete=mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(commandeEntity.getId())))
                .andExpect(status().isNotFound()).andReturn();

    }

    @Test
    public void deleteCommandeByPositveAndIexisteID() throws Exception {
        CommandeEntity commandeEntity = new CommandeEntity();
        commandeEntity.setId(1L);
        String uri = "/CommandeController/deleteCommande";
        MvcResult mvcResultDetete=mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(commandeEntity.getId())))
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
