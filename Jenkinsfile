pipeline {
  agent any
  environment {
    MY_ENV = 'dev'
    APPCI = 'ava'
  }
  parameters {
    string(name: 'PERSON', defaultValue: 'Mr Mukesh')
    text(name: 'BIO', defaultValue: '')
    booleanParam(name: 'TOGGLE', defaultValue: true)
    choice(name: 'CHOICE', choices: ['one', 'two','three'], description: 'please select true or false')
    password(name: 'PASSWORD', defaultValue: 'mysecret')
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
      when {
        expression {
          $BRANCH_NAME == 'main'
        }
      }
      steps {
        echo "This is build stage"
        echo "${MY_ENV} ${APPCI}"
        script {
          withEnv(['MY_ENV=inside_script', 'APPCI=check']) {
          echo "${MY_ENV} ${APPCI}"
          }
        }
      }
    }
    stage("Deploy") {
      when {
        expression {
          params.TOGGLE && $BRANCH_NAME == 'main'
        }
      }
      steps {
        echo "This is deploy stage"
        withCredentials([usernamePassword(credentialsId: 'nexus', passwordVariable: 'PSW', usernameVariable: 'USR')]) {
          echo "${PSW} ${USR}"
        }
      }
    }
    stage('ParamCheck') {
      steps {
        echo 'This is  Param check'
        echo "${params.PERSON}"
        echo "${params.BIO}"
        echo "${params.TOGGLE}"
        echo "${params.CHOICE}"
        echo "${params.PASSWORD}"
      }
    }
    stage('inputparamcheck') {
      input {
        message 'please select your env'
        ok 'env selected'
        parameters {
          choice(name: 'MY_ENV', choices: ['one', 'two','three'], description: 'please select env')
        }
      }
      steps {
        echo 'This is  InputParam check'
        echo "${MY_ENV}"
      }
    }
  }
}
