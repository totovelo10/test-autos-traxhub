pipeline {
    agent any 
    stages {
        stage('Test') { 
            steps {
                bat 'mvn clean verify -Dwebdriver.driver=chrome' 
            }     
       }
    }
}
