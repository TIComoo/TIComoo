package g5.app.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import g5.app.model.Rider;
import g5.app.service.RiderService;

@RestController
@RequestMapping("/rider")
public class RiderController {

    @Autowired
    private RiderService riderService;

    @PostMapping(value = "/guardarRider")
    public void guardarRider(@RequestBody @ModelAttribute("Rider") Rider rider ) {
  
        this.riderService.guardarRider(rider);
    }


    @GetMapping(value = "/leerRiders", produces = "application/json")
    @ResponseBody
    public List<Rider> leerRiders(){
       List<Rider> riders = this.riderService.leerRiders();
       return riders;
    }
     
    @GetMapping(value = "/leerRiderPorEmail", produces = "application/json")
    @ResponseBody
    public Rider leerRiderPorEmail(@RequestHeader String email){
        Rider rider = this.riderService.leerRiderPorEmail(email);
        return rider;

    }
    @DeleteMapping(value = "/borrarRiderPorEmail")
    public void borrarRiderPorEmail(@RequestHeader String email) {
        this.riderService.borrarRiderPorEmail(email);
    }

    
}