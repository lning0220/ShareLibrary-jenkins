package org.devops
//构建类型
def Build(buildType,buildShell){
  def buildTools = ["mvn":"m2","ant":"ANT","gradle":"GRADLE","npm":"NPM"]
  
  println("当前选择的构建类型为 ${buildType}")
  buildHome = tool buildTools[buildType]
  
  if("${buildType}" == "npm"){
    sh " export NODE_HOME=${buildHome} && export PATH=\$NODE_HOME/bin:\$PATH && ${buildHome}/bin/npm ${buildShell}"
  }
  
  
  sh "${buildHome}/bin/${buildType} ${buildShell}"
  
}
