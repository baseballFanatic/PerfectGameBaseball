package Baseball.controller;

import Baseball.PlayBall;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

@Controller
public class PerfectGameController {
    @RequestMapping("/")
    public String perfectGameWebLaunch() {
        return "index";
    }

    @RequestMapping("/simulate")
    @ResponseBody
    public String perfectGameSimulate() throws ClassNotFoundException, SQLException, InstantiationException,
            NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        PlayBall game = new PlayBall();
        return "You simulated a game!";
    }
}
