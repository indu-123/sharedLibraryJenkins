package de.devopsdus2020.external

import de.devopsdus2020.maven.*
import groovy.util.logging.Log

@Log
class MavenService implements InterfaceMavenService {
    
    Closure logger 

    MavenService (Closure logger){
        this.logger = logger
    }
    
    String executeMaven(Map config, String phase) {
        def convertToValueString = {it.collect { /$it.value/ } join ""}
        def csequence = "mvn " + convertToValueString(config) + " " + phase
        println csequence
        // return csequence.execute().text
    }

    String compile(Map config) {
        if (!config) {
            Map config [flag:"-f ", pompath: "${WORKSPACE}"]
        }
        return executeMaven(config, "compile")
    }

    String version(){
        return "mvn -v".execute().text
    }
}