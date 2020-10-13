package bbrow

import groovy.util.logging.Log

@Log
class UnitTesterService implements InterfaceUnitTesterService{

       
    Closure logger 

    CompilerService (Closure logger){
        this.logger = logger
    }
    
    String maventest(pompath) {
        return "mvn -f ${pompath} test".execute().text
    }
}