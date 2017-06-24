package reladomo.example

import com.gs.fw.common.mithra.generator.MithraGenerator

//set working dir to reladomo-gen first
object MithraGeneratorExample {
  def main(args: Array[String]): Unit = {
    val thisModule = "reladomo-gen"
    val targetModule = "reladomo-sample"
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
    gen.setXml(thisModule + "/src/main/resources/reladomo/models/ReladomoClassList.xml")

    gen.setGeneratedDir(targetModule + "/target/java/src_unmanaged/main")
    gen.setNonGeneratedDir(targetModule + "/src/main/java")
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
