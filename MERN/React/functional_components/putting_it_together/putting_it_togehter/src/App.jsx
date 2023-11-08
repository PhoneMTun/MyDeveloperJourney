
import './App.css'
import PersonCard from './components/PersonCard.jsx';
const arrPerson= [{fName: 'Jane', lName: 'Doe', 'age' : 45, hColor: 'Black'}, {fName: 'John', lName: 'Smith', 'age' : 66, hColor: 'Brown'}];
function App() {

  return (
    <>
    <div className="App">
      {arrPerson.map((personObject, index) =>(
        <PersonCard 
        key={index}
        fName={personObject.fName}
        lName={personObject.lName}
        age={personObject.age}
        hColor={personObject.hColor}
      />
      ))}
      
    </div>
     {/* const  */}
    {/* <PersonCard 
    //     fname={"Jane"}
    //     lname={"Doe"}
    //     age={"18"}
    //     hcolor={"Black"}
    //   />
    //   <PersonCard 
    //     fname={"John"}
    //     lname={"Smith"}
    //     age={"88"}
    //     hcolor={"Brown"}
    //   /> */}
    </>
      
  )
}

export default App
