pipeline {
    agent any 
    triggers { upstream(upstreamProjects: 'job1,job2', threshold: hudson.model.Result.SUCCESS) }
    stages {
        stage('Test') { 
            steps {
                bat 'mvn clean verify -Dwebdriver.driver=chrome' 
            }   
            
            post {
                always {
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
            }
       }
    }
    
}
