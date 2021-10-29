package tn.gov.douane.formations.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import tn.gov.douane.formations.api.dto.AgentDto;
import tn.gov.douane.formations.app.user.metiers.interfaces.ILoginMetier;
import tn.gov.douane.formations.app.user.metiers.LoginMetierImpl;

import java.util.Arrays;
import java.util.List;

@Controller
public class Web {

    private ILoginMetier loginService = new LoginMetierImpl();

    @GetMapping("/")
    public String index() {

        AgentDto[] data = {
                new AgentDto("fdsd2121","zezee","gfhgfh","654123784","rretre@popo",
                        "sdfds","sdf","agent","g2","p2", false),
                new AgentDto("qsd1230","qsdcvv","jhkuiuy","651478923","vxcv@poerp",
                        "eazsdfqsd","qsdsqdsd","agent","g3","p3", false),
                new AgentDto("loic1450","loic","arnold","55648419","piedjouloic@gmail.com",
                        "eazsdfqsd","qsdsqdsd","agent","g4","p4", false),
        };

        List<AgentDto> dtos = Arrays.asList(data);
        loginService.loadAgents(dtos);

        return "pages/index";
    }

    @GetMapping("/postes/all")
    public String postes() {
        return "pages/posts/posts";
    }

    @GetMapping("/postes/vacants")
    public String postesVacants() {
        return "pages/posts/posts_vacancies";
    }

    @GetMapping("/formations/my_formation")
    public String formations() {
        return "pages/formations/formations";
    }

    @GetMapping("/formations/catalog")
    public String formations_catalog() {
        return "pages/formations/formations_catalog";
    }

    @GetMapping("/user/first_connection/insert_matricule")
    public String insertMatricule(){ return "pages/user/insert_matricule"; }

    @GetMapping("/user/first_connection/change_password")
    public String changePassword() { return "pages/user/change_default_password"; }

    @GetMapping("/user/profile")
    public String profile() { return "pages/user/profile"; }
}
