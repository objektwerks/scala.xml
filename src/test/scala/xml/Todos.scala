package xml

import scala.xml.Node

case class Name(value: String)

case class Task(value: String)

case class Todo(name: Name, task: Task)

case class Todos(values: Seq[Todo])

object Todos extends ScalaXmlSupport {
  implicit class NodeOps(val todos: Node) {
    def toTodos: Todos = Todos {
      (todos \\ "todo").map { todo =>
        val name = Name((todo \\ "name").text)
        val task = Task((todo \\ "task").text)
        Todo(name, task)
      }
    }
  }

  implicit class TodosOps(val todos: Todos) {
    def toXml: Node =
      <todos>
        {todos.values.map { todo =>
        <todo>
          <name>{todo.name.value}</name>
          <task>{todo.task.value}</task>
        </todo>
      }}
      </todos>
  }
}
