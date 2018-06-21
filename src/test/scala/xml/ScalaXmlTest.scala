package xml

import org.scalatest.{FunSuite, Matchers}
import org.slf4j.LoggerFactory

class ScalaXmlTest extends FunSuite with Matchers {
  val logger = LoggerFactory.getLogger(getClass)

  test("features") {
    import Todos._

    for {
      schema <- loadSchema("/todos.xsd")
      xml <- loadXml("/todos.xml")
      validXml <- loadValidatedXml("/todos.xsd", "/todos.xml")
    } yield {
      isXmlValid(schema, xml) shouldBe true
      xml shouldEqual validXml

      val todos = fromXml(xml)
      val todosAsXml = toXml(todos)

      todos shouldEqual fromXml(todosAsXml)
      todosAsXml shouldEqual toXml(todos)

      logger.info(todos.toString)
      logger.info(formatXml(todosAsXml))

      saveXml("./target/todos.xml", todosAsXml).isSuccess shouldBe true
    }
  }
}