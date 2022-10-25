package g5.app;


import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rider")
public class RiderController {

    @Autowired
    private RiderService riderService;

    @PostMapping(value = "/crearRider")
    public void crearAdmin(@RequestBody @ModelAttribute("Rider") Rider rider ) {
  
        this.riderService.crearRider(rider);
    }
    
}