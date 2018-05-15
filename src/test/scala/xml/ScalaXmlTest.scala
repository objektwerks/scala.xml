package xml

import javax.xml.XMLConstants
import javax.xml.validation.SchemaFactory
import org.scalatest.{FunSuite, Matchers}

class ScalaXmlTest extends FunSuite with Matchers {
  import Todos._

  val schema = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI).newSchema(getClass.getResource("/todo.xsd"))
  val xml = loadXml("/todo.xml")

  test("validate") {
    validateXml(schema, xml)
  }

  test("binding") {
    val todos = fromXml(xml)
    todos shouldEqual fromXml(xml)
    println(s"Scala: $todos")
    println(s"Xml: ${toXml(todos)}")
  }
}