pipeline {
    agent {
        label 'linuxAgent1'
    }
    stages {
        stage('Gradle Static Analysis') {
            steps {
                withSonarQubeEnv('SonarQube-Server') {
                    sh 'mvn clean sonar:sonar'
                }
            }
        }
        stage('Test') {
            steps {
                sh 'mvn clean test'
            }
        }
        stage('Jacoco') {
            steps {
                jacoco (execPattern: '**/target/*.exec',
                        classPattern: '**/target/classes',
                        inclusionPattern: '**/*.class',
                        exclusionPattern: '**/test/**,**/integrationTest**,**/*Test.class,**/Q*.class,**/config/**/*.class',
                        sourcePattern: '**/src/main/java',
                        sourceInclusionPattern: '**/*.java',
                        changeBuildStatus: true)
            }
        }
        stage("Build") {
             steps {
                sh "mvn clean install"
            }
        }
    }
}