package br.evento.controller.actions.impl;

import br.evento.controller.actions.IActionsCommand;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CallAvisoViewAction implements IActionsCommand{

    @Override
    public void executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
            RequestDispatcher rd = request.getRequestDispatcher("template.jsp?page=aviso");
            rd.forward(request, response);   
    }
    
}
