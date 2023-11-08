import React, {useState} from 'react';


const Form=(props)=> {
    const [content, setContent] = useState("")
    const {updatetodoList}= props;


const handletosubmit = (e) => {
    e.preventDefault();
    updatetodoList({
        content: content,
        isComplete: false,
        id: Math.floor(Math.random()* 100000000).toString(),
    });
    setContent("");
    }



  return (
    <div className='form'>
        <form onSubmit={handletosubmit}>
            <div>
                <input type='text' value={content} onChange={(e)=>{setContent(e.target.value)}}/><br/>
                <button type='submit' >Add task</button>
            </div>

        </form>
    </div>
  )
}

export default Form;






