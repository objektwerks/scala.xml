package xml

import org.slf4j.LoggerFactory
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

import Todos.*

final class ScalaXmlTest extends AnyFunSuite with Matchers:
  val logger = LoggerFactory.getLogger(getClass)

  test("features") {
    for
      schema <- loadSchema("/todos.xsd")
      xml <- loadXml("/todos.xml")
      validXml <- loadValidatedXml("/todos.xsd", "/todos.xml")
    yield
      isXmlValid(schema, xml) shouldBe true
      xml shouldEqual validXml

      val todos = xml.toTodos
      val todosAsXml = todos.toXml

      todos shouldEqual todosAsXml.toTodos
      todosAsXml shouldEqual todos.toXml

      logger.info(todos.toString)
      logger.info(formatXml(todosAsXml))

      saveXml("./target/todos.xml", todosAsXml).isSuccess shouldBe true
  }