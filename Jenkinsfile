pipeline {
    agent any 
    stages {
        stage('Test') { 
            steps {
                bat 'mvn clean verify -Dwebdriver.driver=chrome' 
            }     
       }
    }
    // publish the Serenity report
   
    publishHTML(target: [
        reportName : 'Serenity',
        reportDir:   'target/site/serenity',
        reportFiles: 'index.html',
        keepAll:     true,
        alwaysLinkToLastBuild: true,
        allowMissing: false
    ])
}
