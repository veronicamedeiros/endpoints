package org.linketinder.controller

import org.linketinder.model.entities.Vacancy
import org.linketinder.service.VacancyService

import com.google.gson.Gson
import javax.servlet.ServletException
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


@WebServlet("/vacancy")

class VacancyController extends HttpServlet{

    VacancyController(){}

    VacancyService vacancyService = new VacancyService()
    Gson gson = new Gson()


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            Vacancy vacancy = gson.fromJson(request.getReader(), Vacancy)
            vacancyService.registerVacancy(vacancy)

            response.setStatus(HttpServletResponse.SC_CREATED)
            response.getWriter().write(gson.toJson(vacancy))

        } catch (Exception e) {

            response.setStatus(HttpServletResponse.SC_BAD_REQUEST)
            response.getWriter().println("Não foi possível realizar a operação.")
            e.printStackTrace()
        }
    }
}