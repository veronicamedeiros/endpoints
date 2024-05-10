package org.linketinder.controller

import org.linketinder.model.entities.Company
import org.linketinder.service.CompanyService

import com.google.gson.Gson
import javax.servlet.ServletException
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


@WebServlet(value = "/company")

class CompanyController extends HttpServlet{

    CompanyController(){}

    CompanyService companyService = new CompanyService()
    Gson gson = new Gson()


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            Company company = gson.fromJson(request.getReader(), Company)
            companyService.registerCompany(company)

            response.setStatus(HttpServletResponse.SC_CREATED)
            response.getWriter().write(gson.toJson(company))


        } catch (Exception e) {

            response.setStatus(HttpServletResponse.SC_BAD_REQUEST)
            response.getWriter().println("Não foi possível realizar a operação. ERRO: ${e}")
            e.printStackTrace()
        }
    }
}