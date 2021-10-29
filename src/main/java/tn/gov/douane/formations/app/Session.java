package tn.gov.douane.formations.app;

import tn.gov.douane.formations.api.dto.AgentDto;
import tn.gov.douane.formations.api.model.User;

public class Session {

    public static AgentDto AGENT = null;
    public static User USER = null;

    public static AgentDto getAGENT(){
        return AGENT;
    }

    public static User getUSER(){
        return USER;
    }

    public static void setAGENT(AgentDto agent){
        AGENT = agent;
    }

    public static void setUSER(User user){
        USER = user;
    }
}
