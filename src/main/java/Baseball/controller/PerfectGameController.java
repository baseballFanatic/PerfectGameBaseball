package Baseball.controller;

import Baseball.PlayBall;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PerfectGameController {
    @RequestMapping("/")
    public String perfectGameWebLaunch() {
        return "index";
    }

    @RequestMapping("/simulate")
    @ResponseBody
    public String perfectGameSimulate() {
        PlayBall game = new PlayBall();
        return "You simulated a game!";
    }
}
