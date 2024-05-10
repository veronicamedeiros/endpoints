package org.linketinder.service

import groovy.json.JsonBuilder
import groovy.sql.Sql
import org.linketinder.DBDAO.CompanyDAO
import org.linketinder.controller.CandidateController
import org.linketinder.controller.CompanyController
import org.linketinder.model.connection.ConnectionFactory
import org.linketinder.model.connection.DBconnection
import org.linketinder.model.connection.Db
import org.linketinder.model.entities.Company

import org.linketinder.service.serviceInterfaces.IcompanyService


//implements IcompanyService


class CompanyService{

    CompanyService() {}



    DBconnection instance = new ConnectionFactory().instantiateDB(Db.POSTGRESQL)
    Sql dbConnection = instance.connectDataBase() as Sql

    CompanyDAO companyDao = new CompanyDAO(dbConnection)


    void registerCompany(Company companyInfo){

        try {

            /*String name = companyInfo.name
            String email = companyInfo.email
            String country = companyInfo.country
            String cep = companyInfo.cep
            String state = companyInfo.state
            String description = companyInfo.description
            String cnpj = companyInfo.cnpj
            String password = companyInfo.password*/

            Company company = new Company(companyInfo.name, companyInfo.email, companyInfo.country, companyInfo.cep, companyInfo.state, companyInfo.description, companyInfo.cnpj, companyInfo.password)

            CompanyDAO companyDao = new CompanyDAO(company, dbConnection)
            companyDao.register()
        }
        catch (Exception e){
            e.printStackTrace()
        }
    }


    void updateCompany(Integer id, Integer chosenOption, String updatedInformation) {

        companyDao.update(id, chosenOption, updatedInformation)
    }


    void deleteCompanyInfo(Integer id, Integer chosenOption) {

        companyDao.delete(id, chosenOption)
    }


    List<Map> getCompanies(){

        List<Map> companies = companyDao.list()
        return companies
    }
}
