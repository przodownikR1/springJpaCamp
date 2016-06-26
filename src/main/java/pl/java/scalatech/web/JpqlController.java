package pl.java.scalatech.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.jpqlQuery.JPQLService;

@Controller
@RequestMapping("/jpql")
@Slf4j
public class JpqlController {
    private final JPQLService jpqlService;
    @Autowired
    public JpqlController(JPQLService jpqlService){
        this.jpqlService = jpqlService;
    }
   
    private final static String JPQLVIEW = "jpql";
       
    @RequestMapping(method = RequestMethod.GET)
    String getJPQL(Model model) {
        model.addAttribute("query", new QueryDTO());
        log.info("++++++++++++ query ");
        return JPQLVIEW;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String create(@Valid QueryDTO query, BindingResult result,Errors errors) {
        log.info("+++  query :  {}", query);
        // countryValidator.validate(invoice, errors);
        if (result.hasErrors()) {
            log.info("+++  invoice error  {}", result);
            return JPQLVIEW;
        }
        query.setResult(jpqlService.executeQuery(query.getName()));
        return JPQLVIEW;
    }


    
}
