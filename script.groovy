def buildJar() {
    sh 'mvn package'
}

def dockerBuild() {
    sh "docker build -t ${params.DOCKER_USER_NAME}/myapp:${BUILD_NUMBER} ."
}

def dockerLogin() {
    withCredentials([usernamePassword(credentialsId: 'dockerhub', passwordVariable: 'MYPSW', usernameVariable: 'USER')]) {
        sh "echo ${MYPSW} | docker login -u ${USER} --password-stdin"
    }
}

def dockerPush() {
    sh "docker push ${params.DOCKER_USER_NAME}/myapp:${BUILD_NUMBER}"
}

return this
