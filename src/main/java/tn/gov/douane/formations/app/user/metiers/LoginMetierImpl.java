package tn.gov.douane.formations.app.user.metiers;

import tn.gov.douane.formations.api.dto.AgentDto;
import tn.gov.douane.formations.api.dto.AgentHistoryDto;
import tn.gov.douane.formations.api.dto.UserDto;
import tn.gov.douane.formations.api.model.Agent;
import tn.gov.douane.formations.api.model.TypeUser;
import tn.gov.douane.formations.api.model.User;
import tn.gov.douane.formations.app.user.functions.GSecurityData;
import tn.gov.douane.formations.app.user.metiers.interfaces.ILoginMetier;
import tn.gov.douane.formations.app.user.services.AgentTransactionService;
import tn.gov.douane.formations.app.user.services.UserTransactionService;
import java.util.ArrayList;
import java.util.List;

public class LoginMetierImpl implements ILoginMetier {

    private AgentTransactionService agentTransaction = new AgentTransactionService();
    private UserTransactionService userTransaction = new UserTransactionService();

    public LoginMetierImpl() {
    }

    @Override
    public Agent addAgent(AgentDto dto) {
        return agentTransaction.getAgentDao().createAgent(dto); }

    @Override
    public void addAgentHistory(AgentHistoryDto dto) {
        agentTransaction.getAgentHistoryDao().createAgentHistory(dto);
    }

    @Override
    public List<Agent> addAgents(List<AgentDto> dtos) {
        return agentTransaction.getAgentDao().createAgents(dtos);
    }

    @Override
    public void sendConnexionIdentifierAgent(List<AgentDto> dtos)  {

        //2- Recuperation de la liste d'agents n'ayants pas recu le mail
        boolean statut = false;
        List<Agent> agents = agentTransaction.getAgentDao().getAllAgentBySendMailStatut(statut);
        List<AgentDto> agents_receving_mail = new ArrayList<AgentDto>();

        for (Agent agent : agents) {

            for (AgentDto dto : dtos) {

                if (agent.getAgentMatricule().equalsIgnoreCase(dto.getMatricule())){
                    agents_receving_mail.add(dto);
                    break;
                }
            }
        }

        //3- Envoi d'un mail a chaque agent
        
        }

    @Override
    public Agent loginAgent(AgentDto dto) {
        return agentTransaction.getAgentDao().getAgentByUsernamePassword(dto);
    }

    @Override
    public void confirmLoginAgent(AgentDto dto) {
        agentTransaction.getAgentDao().updateAgent(dto);
    }

    @Override
    public Agent confirmAgent(AgentDto dto) {
        return agentTransaction.getAgentDao().getAgentByMatricule(dto.getMatricule());
    }

    @Override
    public User validerAgent(AgentDto dto) {

        User user = null;
        boolean agent_exists = userTransaction.getUserDao().existsUser(dto);

        if (!agent_exists){
            Agent agent = agentTransaction.getAgentDao().getAgentByMatricule(dto.getMatricule());

            UserDto userDto = new UserDto();
            userDto.setUserMatricule(agent.getAgentMatricule());
            userDto.setUserFirstName(agent.getAgentFirstName());
            userDto.setUserLastName(agent.getAgentLastName());
            userDto.setUserEmail(agent.getAgentEmail());
            userDto.setUserPhone(agent.getAgentPhone());
            userDto.setUserName(dto.getUsername());
            userDto.setUserPassword(dto.getPassword());
            TypeUser typeUser = userTransaction.getTypeUserDao().getTypeUserByLibelle(agent.getAgentType());
            userDto.setTypeUserId((int) typeUser.getId());

            user = userTransaction.getUserDao().createUser(userDto);
        }else{
            user = userTransaction.getUserDao().getUserByMatricule(dto.getMatricule());
        }

        return user;
    }

    @Override
    public void loadAgents(List<AgentDto> dtos) {

        for (AgentDto ob : dtos) {

            boolean exists = agentTransaction.getAgentDao().existsAgent(ob);

            if (!exists){
                //Generer automatiquement un username et un password
                char[] username = GSecurityData.generateUsername(8, ob.getMatricule(), ob.getFirstName(),
                        ob.getLastName(), ob.getEmail(), ob.getPhone());
                char[] password = GSecurityData.generatePassword(8);

                ob.setUsername(String.valueOf(username));
                ob.setPassword(String.valueOf(password));

                //Add Agent
                Agent agent = addAgent(ob);

                //Add Identifiants de connexion
                AgentHistoryDto agentHistoryDto = new AgentHistoryDto();
                agentHistoryDto.setUsername(ob.getUsername());
                agentHistoryDto.setPassword(ob.getPassword());
                agentHistoryDto.setAgentId((int) agent.getId());

                addAgentHistory(agentHistoryDto);
            }
        }
    }
}
