package xml

import java.io.StringReader

import javax.xml.transform.stream.StreamSource
import javax.xml.validation.SchemaFactory
import org.scalatest.{FunSuite, Matchers}

import scala.xml.XML

class ScalaXmlTest extends FunSuite with Matchers {
  val schema = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema").newSchema(getClass.getResource("/todo.xsd"))
  val xml = XML.load(getClass.getResource("/todo.xml"))

  test("validate") {
    val validator = schema.newValidator()
    validator.validate(new StreamSource(new StringReader(xml.toString)))
  }
}