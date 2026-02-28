pipeline{
  agent any
  
  tools {

  maven 'MVN3.9'
}
  environment {

  DOCKERHUB_CREDENTIALS = 'dockerid'
  JenkinsAPIToken = '118548f24a3254f6d15951725d455d0a63'
  registery_url='https://registry-1.docker.io/v2/'

}
  stages {
  stage('Build Maven') {

  steps {

  checkout scmGit(branches: [ [ name: '*/master' ] ], extensions: [ ], userRemoteConfigs: [ [ url: 'https://github.com/anilprpr/demo.git' ] ])

        bat 'mvn clean install'
                                                                                            

}

  post {

  success {
  junit '**/target/surefire-reports/TEST-*.xml'
  archiveArtifacts 'target/*.jar'
}
}
}
  stage('Build Docker Image')
  {

        steps{

              script{
                      bat 'docker build  -t anilprpr/jenkins-demo .'
              }
        }
  }
  stage('Push Image to Hub') {

  steps{

  script{



            bat 'docker push anilprpr/jenkins-demo'

}
}
}
  stage('Deploy to k8s') {

  steps{

  script{

  echo "Deployment Completed!!!!!!!"
}
}
}

}
}
