pipeline {
  agent any
  environment {
    MY_ENV = 'dev'
    APPCI = 'ava'
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
        // environment {
        // MY_ENV = 'stg'
        // APPCI = 'cls'
        //     }
        echo "This is build stage"
        echo "${MY_ENV} ${APPCI}"
      }
    }
    stage("Deploy") {
      steps {
        echo "This is deploy stage"
        echo "${MY_ENV} ${APPCI}"
      }
    }
  }
}
