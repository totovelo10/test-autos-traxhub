pipeline {
    agent any 
    triggers {
        cron('20 14 * * *')
    }
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
				
				success{
				emailext (
    subject: "Job '${env.JOB_NAME} ${env.BUILD_NUMBER}'",
    body: """<p>Check console output at <a href="${env.BUILD_URL}">${env.JOB_NAME}</a></p>""",
    to: "traxtesteur@gmail.com,a.melki@traxens.com,s.boina-ext@traxens.com",
    from: "jenkins@traxens.com"
)
				
				
				}
				
				
				
            }
       }
    }
    
}
