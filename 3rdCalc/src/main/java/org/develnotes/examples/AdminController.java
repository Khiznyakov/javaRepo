package org.develnotes.examples;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AdminController {	
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String home() {
		return "private/admin";
	}        
        @RequestMapping(value = "/calc", method = RequestMethod.POST)
    public @ResponseBody String Calculator(Double number1, Double number2, int operation,String error ) 
            throws JsonProcessingException {
        EntityManagerFactory entityManagerFactory;
        UserDetails user = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        entityManagerFactory = Persistence.createEntityManagerFactory("org.develnotes_examples_war_1.0.0-BUILD-SNAPSHOTPU");
        String username = user.getUsername();      
        Model model = new Model();
        Operation op = model.calc(number1, number2, operation, error);
        ObjectMapper mapper = new ObjectMapper();
        String results = mapper.writeValueAsString(op);
        EntityManager entityManager = entityManagerFactory.createEntityManager();        
        entityManager.getTransaction().begin();
        Date date = new Date();
        Report report = new Report();
        report.setUsername(username);
        report.setDateTime(date);
        report.setNumber1(Double.toString(number1));
        report.setNumber2(Double.toString(number2));
        String res = "";
         Type type = Type.values()[operation];
            switch (type) {
                case DIV:
                   res="/";
                case PLUS:
                    res = "+";
                    break;
                case MINUS:
                    res = "-";
                    break;
                case MUL:
                    res = "*";
                    break;                              
            }
        report.setOperation(res);
        report.setResult(Double.toString(op.result)); 
       entityManager.persist(report);
        entityManager.getTransaction().commit();
        entityManager.clear();
        entityManager.close();   
        entityManagerFactory.close();
                return results;
            }

    /**
     *
     * @return
     */
    @RequestMapping(value = "/calc", method = RequestMethod.GET)
	public String calc() {            
		return "private/calc";
	} 
        
 @RequestMapping(value = "/showT", method = RequestMethod.GET)
	public String showT() {
            EntityManagerFactory entityManagerFactory;
            entityManagerFactory = Persistence.createEntityManagerFactory("org.develnotes_examples_war_1.0.0-BUILD-SNAPSHOTPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Report> resultList = entityManager.createQuery("SELECT c FROM Report c").getResultList();
        entityManager.close();   
        entityManagerFactory.close();
        String json;        
            json = new Gson().toJson(resultList);
		return json;
	}            
}
