package reladomo.example

import com.gs.fw.common.mithra.generator.MithraGenerator

//set working dir to reladomogen first
object MithraGeneratorExample {
  def main(args: Array[String]): Unit = {
    val gen = new MithraGenerator() {
      override def log(s: String): Unit = {
        println(s)
      }

      override def log(s: String, i: Int): Unit = {
        println(s)
      }
    }
    val startTime = System.currentTimeMillis
    //minimum required settings
    gen.setGeneratedDir("target/java/src_unmanaged/test")
    gen.setXml("src/test/resources/reladomo/models/ReladomoClassList.xml")
    gen.setNonGeneratedDir("src/test/java")
    gen.setGenerateGscListMethod(true)
//    gen.setCodeFormat(CoreMithraGenerator.FORMAT_FAST)

//    var generatorImport = new MithraGeneratorImport
//    generatorImport.setDir("H:/projects/Mithra/Mithra/xml/mithra/test/")
//    generatorImport.setFilename("MithraClassListToImport.xml")
//    gen.addConfiguredMithraImport(generatorImport)

//    generatorImport = new MithraGeneratorImport
//    generatorImport.setDir("H:/projects/Mithra/Mithra/xml/mithra/test/testmithraimport")
//    generatorImport.setFilename("MithraTestImportClassList.xml")
//    gen.addConfiguredMithraImport(generatorImport)

    gen.execute()
    System.out.println("time: " + (System.currentTimeMillis - startTime))
  }
}
