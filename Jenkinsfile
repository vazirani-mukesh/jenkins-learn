pipeline {
  agent any
  environment {
    MY_ENV = 'dev'
    APPCI = 'ava'
    nexus_cred = credentials('nexus')
  }
  stages {
    stage('Test') {
      steps {
        echo 'This is test stage'
        echo "${MY_ENV} ${APPCI}"
      }
    }
    stage('Build') {
      environment {
        MY_ENV = 'qa'
        APPCI = 'drq'
      }
      steps {
        echo "This is build stage"
        echo "${MY_ENV} ${APPCI}"
        echo "${nexus_cred}"
      }
    }
    stage("Deploy") {
      steps {
        echo "This is deploy stage"
        echo "${MY_ENV} ${APPCI}"
        echo "${nexus_cred}"
      }
    }
  }
}
