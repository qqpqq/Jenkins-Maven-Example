pipeline {
    agent {
        label 'linuxAgent1'
    }
    stages {
        stage("Test") {
            steps {
                sh "mvn test"
            }
        }
        stage("Build") {
             steps {
                sh "mvn install"
            }
        }
    }
}