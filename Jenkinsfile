pipeline {
    agent any
    stages {    
        stage("git checkout") {
            steps {    
                git 'https://github.com/weaverj/testpyramidexample.git'
            }
        }   
        stage(" change directory"){
            steps{
                dir ('rxdemo-ui') {
                sh 'pwd'
               }
            }   
        }
        
    }
}
    
