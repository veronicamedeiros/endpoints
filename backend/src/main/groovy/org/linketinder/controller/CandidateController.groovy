package org.linketinder.controller

import org.linketinder.model.entities.Candidate
import org.linketinder.service.CandidateService

import com.google.gson.Gson
import javax.servlet.ServletException
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


@WebServlet(value = "/candidate")

class CandidateController extends HttpServlet{

    CandidateController(){}

    CandidateService candidateService = new CandidateService()
    Gson gson = new Gson()


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            Candidate candidate = gson.fromJson(request.getReader(), Candidate)
            candidateService.registerCandidate(candidate)

            response.setStatus(HttpServletResponse.SC_CREATED)
            response.getWriter().write(gson.toJson(candidate))

        } catch (Exception e) {

            response.setStatus(HttpServletResponse.SC_BAD_REQUEST)
            response.getWriter().println("Não foi possível realizar a operação.")
            e.printStackTrace()
        }
    }
}