node('linuxAgent1') {
    stage('Checkout') {
        checkout( [
                $class : 'GitSCM',
                branches : [[name: 'main']],
                userRemoteConfigs : [
                        [credentialsId: 'mallycrip', url: 'https://github.com/qqpqq/Jenkins-Maven-Example.git']
                ] ]
        )
    }
    stage('Test Execution') {
        testExecution()
    }
    stage('Dynamic Analysis') {
        dynamicAnalysis()
    }
    stage('Static Analysis') {
        withSonarQubeEnv('SonarQube-Server') {
            staticAnalysis()
        }
    }
    stage('Build') {
        mavenBuild()
    }
}

def testExecution() {
    try {
        sh('mvn clean test')
    } catch (Exception e) {
        sendErrorMessageToSlack("Test Failed", e)
        throw e
    }
}

def mavenBuild() {
    sh('mvn clean install')
}

def staticAnalysis() {
    sh('mvn clean sonar:sonar')
}

def dynamicAnalysis() {
    jacoco (
        execPattern: '**/target/*.exec',
        classPattern: '**/target/classes',
        inclusionPattern: '**/*.class',
        exclusionPattern: '**/test/**,**/integrationTest**,**/*Test.class,**/Q*.class,**/config/**/*.class',
        sourcePattern: '**/src/main/java',
        sourceInclusionPattern: '**/*.java',
        buildOverBuild: true,
        changeBuildStatus: true
    )
}

def sendErrorMessageToSlack(message, errorMessage) {
    slackSend (color: '#fE3E3E', message: """*Error at ${env.JOB_NAME} [${env.BUILD_NUMBER}]*
Reason : ${message}
Detail : ${errorMessage}
> Build URL : ${env.BUILD_URL}""")
}

def sendCommonMessageToSlack(message) {
    slackSend (color: '#42B9E4', message: """*${env.JOB_NAME} [${env.BUILD_NUMBER}]*
${message}
> Build URL : ${env.BUILD_URL}""")
}
