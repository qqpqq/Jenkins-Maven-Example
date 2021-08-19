pipeline {
    agent {
        label 'linuxAgent1'
    }
    stages {
        stage('Gradle Static Analysis') {
            steps {
                withSonarQubeEnv('SonarQube-Server') {
                    sh './mvn sonar:sonar'
                }
            }
        }
        stage("Build") {
             steps {
                sh "mvn install"
            }
        }
    }
}