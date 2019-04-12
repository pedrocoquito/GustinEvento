package br.evento.controller;

import br.evento.controller.actions.IActionsCommand;
import br.evento.controller.actions.impl.CallAjaxValidaPasswordAction;
import br.evento.controller.actions.impl.CallCadastroSalaViewAction;
import br.evento.controller.actions.impl.CallCadastroViewAction;
import br.evento.controller.actions.impl.CallHomeViewAction;
import br.evento.controller.actions.impl.CallLoginViewAction;
import br.evento.controller.actions.impl.CallReunioesViewAction;
import br.evento.controller.actions.impl.CallSairAction;
import br.evento.controller.actions.impl.CallSalvarUsuarioAction;
import br.evento.controller.actions.impl.CallSecuredReservaViewAction;
import br.evento.controller.actions.impl.CallValidaLoginAction;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "PrincipalController", urlPatterns = {"/home"})
public class PrincipalController extends HttpServlet {

    private static Map<String, IActionsCommand> comandos = new HashMap<>();
    
    static{
        comandos.put(null, new CallHomeViewAction());
        comandos.put("home", new CallHomeViewAction());
        comandos.put("login", new CallLoginViewAction());
        comandos.put("secured/reserva", new CallSecuredReservaViewAction());
        comandos.put("reunioes", new CallReunioesViewAction());
        comandos.put("cadastro", new CallCadastroViewAction());
        comandos.put("cadastroSala", new CallCadastroSalaViewAction());
        comandos.put("passwordAjax", new CallAjaxValidaPasswordAction());
        comandos.put("salvarUsuario", new CallSalvarUsuarioAction());
        comandos.put("validaLogin", new CallValidaLoginAction());
        comandos.put("sair", new CallSairAction());				
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String acao = request.getParameter("ac");
        
        try {
            if(acao.contains("secured") && request.getSession().getAttribute("user") != null){
                new CallLoginViewAction().executar(request, response);
            }
            comandos.get(acao).executar(request, response);
        } catch (Exception e) {
            RequestDispatcher rd = request.getRequestDispatcher("template.jsp?page=erro");
            request.setAttribute("erro", e.getMessage());
            rd.forward(request, response);
        }
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
