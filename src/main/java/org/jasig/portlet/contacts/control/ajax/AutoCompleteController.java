package org.jasig.portlet.contacts.control.ajax;

import java.util.*;
import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.jasig.portlet.contacts.model.Contact;
import org.jasig.portlet.contacts.model.ContactSet;
import org.jasig.portlet.contacts.adapters.SearchAdapter;

@Controller
@RequestMapping("/autocomplete")
public class AutoCompleteController {

    private static Log log = LogFactory.getLog(AutoCompleteController.class);
    private SearchAdapter searchAdapter;

    
    public AutoCompleteController(SearchAdapter searchAdapter) {
        this.searchAdapter = searchAdapter;
    }

    @RequestMapping
    public String showAutoComplete(
            HttpServletRequest request, 
            HttpServletResponse response, 
            Model model,
            @RequestParam("term") String query
    ) {
        Boolean ok = (Boolean) request.getSession().getAttribute("SECURITY");

        String filter = request.getParameter("filter");

        log.debug("filter is " + filter);

            log.debug("q is " + query);

            ContactSet contacts = searchAdapter.search(query, filter);
            
            Map<String, Integer> countedResults = getCountedSearchResults(contacts);
            
            if (countedResults.size() > 0) {
                List<Map<String,String>> data = new ArrayList<Map<String,String>>();
                for (String key : countedResults.keySet()) {
                    
                    Map<String,String> entry = new HashMap<String,String>();
                    if (countedResults.get(key) > 1)
                        entry.put("label", "<span>" + countedResults.get(key) + " results</span>" + key);
                    else
                        entry.put("label", key);
                    entry.put("value", key);
                    data.add(entry);
                }
                model.addAttribute("data",data.toArray());
            }
        return "JSONView";
    }

    private Map<String, Integer> getCountedSearchResults(ContactSet results) {
        Map<String, Integer> countedResults = new LinkedHashMap<String, Integer>();

        for (Contact contact : results) {
            String value = contact.getFirstname() + " " + contact.getSurname();
            Integer count = countedResults.get(value);
            if (count == null) {
                count = 0;
            }
            countedResults.put(value, ++count);
        }
        return countedResults;
    }
    private MessageSource messageSource;

    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }
}
