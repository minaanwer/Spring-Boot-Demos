package ebc.demo.ui;

import org.apache.catalina.valves.HealthCheckValve;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api")
public class HomeController {

    @PersistenceContext
    EntityManager entityManager;

    @GetMapping("checkstatus")
    public String checkStatus() {
        return "OK!";
    }


    @GetMapping("/get")
    public  List<String> GetHomePageArray() {
        List<Long[]> trxs  = entityManager.createNativeQuery(
                "select (extract(month from creation_date)) as Month_of_year , count (id) as total_ReturnRequests from dbo.return_request rr \n" +
                        "group by Extract (month from creation_date) order by Month_of_year")
                .getResultList();
        List<String> trxAsString  = FormatTrxAsStringJustToShowThemOnBrowser(trxs);
        return trxAsString ;
    }

    private List<String> FormatTrxAsStringJustToShowThemOnBrowser(List<Long[]> trxs) {
        List<String> str = new ArrayList<String>();
        str.add("    Month    :    Count    ");
        for (Object[] item : trxs){
            str.add("    "+item[0] +"                  :                    "+item[1] );
        }
        return str;
    }
}
