pipeline{
  agent any
  
  tools {
  # Install the Maven version configured as "M3" and add it to the path.
  maven 'MVN3.9'
}
  environment {
  # Define Docker Hub credentials ID stored in Jenkins credentials store
  DOCKERHUB_CREDENTIALS = 'dockerid'
  JenkinsAPIToken = '118548f24a3254f6d15951725d455d0a63'
  registery_url='https://registry-1.docker.io/v2/'
  #IMAGE_NAME = 'amazonlinux'
  #IMAGE_TAG = 'latest'
}
  stages {
  stage('Build Maven') {

  steps {
        # Get some code from a GitHub repository
        # git 'https://github.com/anilprpr/demo.git'
  checkout scmGit(branches: [ [ name: '*/master' ] ], extensions: [ ], userRemoteConfigs: [ [ url: 'https://github.com/anilprpr/demo.git' ] ])
        # Run Maven on a Unix agent.
        bat 'mvn clean install'
                                                                                            
       #To run Maven on a Windows agent, use
      #bat "mvn -Dmaven.test.failure.ignore=true clean package"
}

  post {
  # If Maven was able to run the tests, even if some of the test
  # failed, record the test results and archive the jar file.
  success {
  junit '**/target/surefire-reports/TEST-*.xml'
  archiveArtifacts 'target/*.jar'
}
}#end post
}#end stage
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

  #withCredentials([ usernamePassword(credentialsId: DOCKERHUB_CREDENTIALS, passwordVariable: 'doc_pwd', usernameVariable: 'doc_user') ])
  #{
  #  bat 'docker login -u ${ doc_user } -p ${ doc_pwd }'
            bat 'docker push anilprpr/jenkins-demo'
  # }
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
