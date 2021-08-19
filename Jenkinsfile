node("linuxAgent1") {
    agent any
    stages {
        stage("Checkout"){
            checkout scm
        }
        stage("Test") {
            sh "mvn test"
        }
        stage("Build") {
            sh "mvn install"
        }
    }
}