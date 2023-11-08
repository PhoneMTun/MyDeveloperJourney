import React from 'react';

const Display=(props)=>{

    const {todoList, deleteButton, handlecompleted} = props;


return(
    <>
        {
            todoList.map((todo, index)=>(
                <div key={todo.id}>
                    <p className={todo.isComplete? "yes": ""}>{todo.content}</p>
                    <input type='checkbox' onChange={()=>handlecompleted(todo)} />
                    <button onClick={()=> deleteButton(todo.id)}>Delete</button>
                </div>
            ))
        }
    </>
);
    };

export default Display;