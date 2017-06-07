package Baseball;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

import static java.lang.System.*;

class GameEngine {

    public static void main(String[] args) throws ClassNotFoundException, SQLException, InstantiationException,
            NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        out.println("Take me out to the ballgame!\n");

        PlayBall game = new PlayBall();

    }

}

