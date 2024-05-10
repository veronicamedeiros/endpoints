package org.linketinder.service

import groovy.sql.Sql
import org.linketinder.DBDAO.VacancyDAO
import org.linketinder.controller.VacancyController
import org.linketinder.model.connection.ConnectionFactory
import org.linketinder.model.connection.DBconnection
import org.linketinder.model.connection.Db
import org.linketinder.model.entities.Vacancy
import org.linketinder.service.serviceInterfaces.IvacancyService

// implements IvacancyService
class VacancyService{

    VacancyService(){}

    DBconnection instance = new ConnectionFactory().instantiateDB(Db.POSTGRESQL)
    Sql dbConnection = instance.connectDataBase() as Sql
    VacancyDAO vacancyDao = new VacancyDAO(dbConnection)


    void registerVacancy(Vacancy vacancyInfo){

        try {
            Vacancy vacancy = new Vacancy(vacancyInfo.position, vacancyInfo.level, vacancyInfo.shift, vacancyInfo.model, vacancyInfo.city, vacancyInfo.state, vacancyInfo.jobDescription, vacancyInfo.desiredSkills, vacancyInfo.idCompany)

            VacancyDAO dbRegistration = new VacancyDAO(vacancy, dbConnection)
            dbRegistration.register()
        }
        catch (Exception e){
            e.printStackTrace()
        }
    }


    void updateVacancy(Integer id, Integer chosenOption, String updatedInformation) {

        vacancyDao.update(id, chosenOption, updatedInformation)
    }


    void updateVacancySkills(Integer id, Integer oldSkill, Integer updatedInformation){

        vacancyDao.updateSkills(id, oldSkill, updatedInformation)
    }


    void deleteVacancyInfo(Integer id, Integer oldSkill) {

        vacancyDao.delete(id, oldSkill)
    }


    void deleteVacancySkills(Integer id, Integer oldSkill){

        vacancyDao.deleteSkills(id, oldSkill)
    }


    List<Map> getVacancies(){

        List<Map> vacancies = vacancyDao.list()

        return vacancies
    }
}



