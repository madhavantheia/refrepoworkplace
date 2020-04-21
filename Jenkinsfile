pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        echo 'Build'
      }
    }

    stage('Inspection') {
      steps {
        echo 'Test execution'
      }
    }

    stage('Test') {
      steps {
        bat(script: 'mvn test', label: 'maven command', returnStatus: true)
      }
    }

  }
}