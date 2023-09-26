package application;

import application.DAO.AdminDAO;
import application.DAO.AgentDAO;
import application.DTO.Admin;
import application.DTO.Agent;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        AgentDAO agentDAO = new AgentDAO();
        Agent agent = new Agent();
//        AgentDAO.sendMail("The first email", "subject", "sidatinouhi@gmail.com");
        agent.setEmail("sidatnouhi@gmail.com");
        agent.setPassword("Hassan2000");
        if(agentDAO.login(agent)){
            System.out.println("Inter the code: ");
            Scanner sc = new Scanner(System.in);
            System.out.println(agentDAO.verifyLogin(agent, sc.nextInt()));

        }
        else
            System.out.println("false");
    }
}