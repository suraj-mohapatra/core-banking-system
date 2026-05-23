pipeline {
    agent any

    environment {
        MAVEN_OPTS = "-Dmaven.repo.local=.m2/repository"
        IMAGE_NAME = "core-banking-system:${env.GIT_COMMIT.take(8)}"
    }

    stages {
        stage('Test') {
            agent {
                docker {
                    image 'maven:3.9.9-eclipse-temurin-21'
                    args '-v $HOME/.m2:/root/.m2'
                }
            }
            steps {
                sh 'mvn clean verify'
            }
        }

        stage('Package') {
            agent {
                docker {
                    image 'maven:3.9.9-eclipse-temurin-21'
                    args '-v $HOME/.m2:/root/.m2'
                }
            }
            steps {
                sh 'mvn clean package -DskipTests'
                archiveArtifacts artifacts: 'api/target/api.jar', fingerprint: true
            }
        }

        stage('Docker Build') {
            steps {
                sh 'docker build -f api/Dockerfile -t $IMAGE_NAME api'
            }
        }
    }
}


// Important: Jenkins machine/agent must have Docker installed for this stage: stage('Docker Build')
// because it runs: docker build