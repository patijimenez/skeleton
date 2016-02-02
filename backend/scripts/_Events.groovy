eventCompileStart = { kind ->
  println "UUID"
  metadata.'app.buildNumber' = UUID.randomUUID().toString()
  metadata.persist()

  def buildNumber = metadata.'app.buildNumber'
  println "**** Compile Starting on Build #${buildNumber}"
}