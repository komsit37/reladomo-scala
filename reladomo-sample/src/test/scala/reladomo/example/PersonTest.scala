package reladomo.example

import com.gs.fw.common.mithra.test.{ConnectionManagerForTests, MithraTestResource}
import example.domain.Person
import org.scalatest.{BeforeAndAfterAll, FunSuite, Matchers}

class PersonTest extends FunSuite with Matchers with BeforeAndAfterAll {

  var mithraTestResource: MithraTestResource = _
  override def beforeAll(): Unit = {
    this.mithraTestResource = new MithraTestResource("reladomo/TestMithraRuntimeConfig.xml")
    val connectionManager = ConnectionManagerForTests.getInstanceForDbName("testdb")
    this.mithraTestResource.createSingleDatabase(connectionManager)
    this.mithraTestResource.addTestDataToDatabase("testdata/test_data.txt", connectionManager)
    this.mithraTestResource.setUp()
  }

  override def afterAll(): Unit = {
    this.mithraTestResource.tearDown()
  }

  test("get person") {
    val john = Person.findPersonNamed("John", "Smith")
    john.getFullName shouldBe "John Smith"
  }
}
