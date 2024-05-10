package org.linketinder.service

import groovy.sql.Sql
import org.linketinder.DBDAO.CandidateDAO
import org.linketinder.controller.CandidateController
import org.linketinder.model.connection.ConnectionFactory
import org.linketinder.model.connection.DBconnection
import org.linketinder.model.connection.Db
import org.linketinder.model.entities.Candidate
import org.linketinder.service.serviceInterfaces.IcandidateService

// implements IcandidateService
class CandidateService{

    DBconnection instance = new ConnectionFactory().instantiateDB(Db.POSTGRESQL)
    Sql dbConnection = instance.connectDataBase()
    CandidateDAO candidateDao = new CandidateDAO(dbConnection)

    CandidateService() {}


    void registerCandidate(Candidate candidateInfo){

        try {
            Candidate candidate = new Candidate(candidateInfo.name, candidateInfo.surname, candidateInfo.birth, candidateInfo.email, candidateInfo.country, candidateInfo.cep, candidateInfo.state, candidateInfo.description, candidateInfo.age, candidateInfo.cpf, candidateInfo.skills, candidateInfo.password)
            CandidateDAO candidateDao = new CandidateDAO(candidate, dbConnection)
            candidateDao.register()
        }
        catch (Exception e){
            e.printStackTrace()
        }
    }


    void updateCandidate(Integer id, Integer chosenOption, String updatedInformation) {

        candidateDao.update(id, chosenOption, updatedInformation)
    }


    void updateCandidateSkills(Integer id, Integer oldSkill, Integer newSkill){

        candidateDao.updateSkills(id, oldSkill, newSkill)
    }


    void deleteCandidateInfo(Integer id, Integer chosenOption) {

        candidateDao.delete(id, chosenOption)
    }


    void deleteCandidateSkills(Integer id, Integer oldSkill){

        candidateDao.deleteSkills(id, oldSkill)
    }


    List<Map> getCandidates(){

        List<Map> candidates = candidateDao.list()

        return candidates
    }
}
