node("linuxAgent1") {
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