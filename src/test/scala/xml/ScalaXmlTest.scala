package xml

import javax.xml.XMLConstants
import javax.xml.validation.SchemaFactory
import org.scalatest.{FunSuite, Matchers}

class ScalaXmlTest extends FunSuite with Matchers {
  test("features") {
    import Todos._

    val schema = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI).newSchema(this.getClass.getResource("/todo.xsd"))
    val xml = loadXml("/todo.xml")

    val todos = fromXml(xml)
    val todosAsXml = toXml(todos)

    todos shouldEqual fromXml(xml)
    validateXml(schema, todosAsXml).isSuccess shouldBe true
    formatXml(xml) shouldEqual formatXml(todosAsXml)

    println(todos)
    println(formatXml(todosAsXml))
  }
}