import Form from './components/form';
import React, {useState, useEffect} from 'react';
import Display from './components/Display'

import './App.css'

function App() {

  const [todoList, setTodoList] = useState(()=>
  {
    const savedTodos =localStorage.getItem('todoList');
    return savedTodos? JSON.parse(savedTodos) : [];
  });


  const updatetodoList =(newTodo)=>{
    setTodoList((oldTodo)=>(
      [...oldTodo, newTodo]
      ))
    }
    const deleteButton =(idselected)=>{
      const filteredTodo = todoList.filter((todo)=>{
        return todo.id !== idselected;
      })
    setTodoList(filteredTodo);
    }

  const handlecompleted =(todoselected)=>{
    let updatetodo= todoList.map((todo)=>{
      if(todo===todoselected) {
        let thistodo = {...todo}
        thistodo.isComplete = !thistodo.isComplete 
        return thistodo;
      }
      return todo;
      
  })
  setTodoList(updatetodo); //
  }
  useEffect(()=>{
    localStorage.setItem('todoList', JSON.stringify(todoList));
  }, [todoList]
  )

  return (
    <div className='App'>
      <Form updatetodoList={updatetodoList} />
      <Display todoList={todoList} deleteButton={deleteButton} handlecompleted={handlecompleted}/>
    </div>
  )
}

export default App
